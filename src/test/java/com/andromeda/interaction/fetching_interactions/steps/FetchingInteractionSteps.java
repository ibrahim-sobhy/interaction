package com.andromeda.interaction.fetching_interactions.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FetchingInteractionSteps {
  @Given("^(.*) logged in the system$")
  public void userLoggedInTheSystem(String user) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
  }

  @When("^(.*) type (.*) account number of the customer John in the search box$")
  public void typeAccountNumberOfTheCustomerInTheSearchBox(String user, String accountNumber) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
  }

  @And("^(.*) click on Search button$")
  public void clickOnSearchButton(String user) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
  }

  @Then("^System will display the last interactions within the last (.*) for John account$")
  public void systemWillDisplayTheLastInteractionsWithinTheLastTwoWeeks(String duration) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    System.out.println(duration);
//    throw new PendingException();
  }


  @And("^data should have <interaction_date>, <interaction_type>, <interaction_direction>$")
  public void dataShouldHaveInteractionDateInteractionTypeInteractionDirection(String interactionDate, String interactionType, String direction) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
}
