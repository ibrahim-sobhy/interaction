package com.andromeda.interaction.fetching_interactions;


import net.serenitybdd.jbehave.SerenityJBehaveTestRunner;
import net.serenitybdd.screenplay.Actor;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.runner.RunWith;

@RunWith(SerenityJBehaveTestRunner.class)
public class WhenFetchingInteraction {

  private Actor sam;

  @Pending
  @Given("<username> logged in the system")
  public void userLoggedInTheSystem(String username) {
    // Write code here that turns the phrase above into concrete actions
    sam = Actor.named(username);
  }

  @When("<username> type <accountNumber> account number of the customer John in the search box")
  public void typeAccountNumberOfTheCustomerInTheSearchBox(String username, String accountNumber) {
    // Write code here that turns the phrase above into concrete actions
  }

  @When("<username> clicks on Search button$")
  public void clickOnSearchButton(String username) {
    // Write code here that turns the phrase above into concrete actions
  }

  @Then("System will display the last interactions within the last <duration> for John account")
  public void systemWillDisplayTheLastInteractionsWithinTheLastTwoWeeks(String duration) {
    // Write code here that turns the phrase above into concrete actions
  }


  @Then("data should have <interaction_date>, <interaction_type>, <interaction_direction>")
  public void dataShouldHaveInteractionDateInteractionTypeInteractionDirection(String interactionDate, String interactionType, String direction) {
    // Write code here that turns the phrase above into concrete actions
  }
}
