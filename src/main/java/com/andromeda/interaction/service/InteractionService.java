package com.andromeda.interaction.service;

import com.andromeda.interaction.model.Interaction;
import com.andromeda.interaction.repo.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang.StringUtils.isBlank;
import static org.apache.commons.lang.StringUtils.isNumeric;


public class InteractionService {

  @Autowired
  private InteractionRepository interactionRepository;

  /**
   * Fetch the interactions for customer account.
   *
   * @param accountNumber to get the interactions.
   * @return the list of interactions optionally.
   */
  public Optional<List<Interaction>> fetch(String accountNumber) {
    if (isBlank(accountNumber)) {
      throw new IllegalArgumentException("Account number is not exist");
    }
    if (!isNumeric(accountNumber)) {
      throw new IllegalArgumentException("Account number is not numeric");
    }
    return interactionRepository.find(accountNumber);
  }
}
