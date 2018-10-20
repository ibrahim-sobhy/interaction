package com.andromeda.interaction.api;

import com.andromeda.interaction.model.Interaction;
import com.andromeda.interaction.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
@RequestMapping("/api/interactions")
public class InteractionApi {

  @Autowired
  private InteractionService interactionService;

  /**
   * Fetch all interactions for an account.
   *
   * @param accountNumber the target account for interactions to retrieve.
   * @return list of interactions by default for the last 2 weeks
   */
  @GetMapping("/{accountNumber}")
  public ResponseEntity<List<Interaction>> fetch(
      @Valid @NotNull @PathVariable("accountNumber") String accountNumber) {
    return interactionService.fetch(accountNumber)
        .map(ResponseEntity::ok)
        .orElse(noContent().build());
  }
}
