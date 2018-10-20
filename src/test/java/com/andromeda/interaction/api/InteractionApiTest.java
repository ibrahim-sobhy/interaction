package com.andromeda.interaction.api;

import com.andromeda.interaction.service.InteractionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class InteractionApiTest {

  private MockMvc mvc;

  @InjectMocks
  private InteractionApi interactionApi;

  @Mock
  private InteractionService interactionService;


  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    mvc = MockMvcBuilders.standaloneSetup(interactionApi).build();
  }

  @Test
  public void shouldReturnEmptyIfThereIsNoInteractions() throws Exception {
    String accountNumber = "0505234243";
    when(interactionService.fetch(accountNumber)).thenReturn(Optional.empty());
    mvc.perform(get("/api/interactions/" + accountNumber))
        .andExpect(status().isNoContent());
  }
}
