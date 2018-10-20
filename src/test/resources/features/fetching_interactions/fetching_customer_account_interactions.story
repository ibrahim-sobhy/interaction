Fetch customer account interactions through any channel like email or SMS.

Narrative:
In order to help agent to view the  interactions of customer with the system
As a Call Center user
I want to view the interactions of the customer account

Scenario: show last interactions within last two weeks
Given Sam logged in the system
When Sam type 0501234567 account number of the customer John in the search box
And Sam clicks on Search button
Then System will display the last interactions within the last 2 weeks for John account
And data should have <interaction_date>, <interaction_type>, <interaction_direction>
Examples:
  | interaction_date | interaction_type | interaction_direction |
  | 25 Aug 2018      | SMS              | Inbound               |
