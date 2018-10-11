package com.andromeda.interaction;

import com.andromeda.interaction.model.Interaction;
import com.andromeda.interaction.repo.InteractionRepository;
import com.andromeda.interaction.service.InteractionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.andromeda.interaction.model.InteractioType.EMAIL;
import static com.andromeda.interaction.model.InteractioType.SMS;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class FetchingAccountInteractionTest {

  @InjectMocks
  private InteractionService interactionService;
  @Mock
  private InteractionRepository interactionRepository;

  @Test
  public void whenAccountNumberIsMissingThenThrowIllegalArgumentException() {
    String accountNumber = null;

    Throwable throwable = catchThrowable(() -> interactionService.fetch(accountNumber));
    assertThat(throwable)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("Account number is not exist");
  }

  @Test
  public void whenAccountNumberIsNotnumericThenThrowIllegalArgumentException() {
    String accountNumber = "Not Valid";

    Throwable throwable = catchThrowable(() -> interactionService.fetch(accountNumber));
    assertThat(throwable)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("Account number is not numeric");
  }

  @Test
  public void whenFetchingAccountInteractionsReturnNoData() {
    String accountNumber = "0501234567";
    interactionService.fetch(accountNumber)
        .ifPresent(interactions -> fail("Should not return data"));
  }

  @Test
  public void whenFetchingAccountInteractionsRecords() {
    String accountNumber = "0501234567";

    List<Interaction> expectedInteractionList = asList(
        Interaction.builder()
            .createdAt(LocalDateTime.now())
            .type(EMAIL)
            .build(),
        Interaction.builder()
            .createdAt(LocalDateTime.now())
            .type(SMS)
            .build()
    );

    when(interactionRepository.find(accountNumber))
        .thenReturn(Optional.of(
            expectedInteractionList
        ));
    interactionService.fetch(accountNumber)
        .ifPresent(interactions -> assertThat(interactions)
            .containsExactlyElementsOf(expectedInteractionList));
    verify(interactionRepository, times(1)).find(accountNumber);
  }
}
