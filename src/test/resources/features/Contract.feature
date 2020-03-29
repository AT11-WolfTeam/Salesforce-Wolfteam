Feature: Contract

  @wip
  Scenario: Close an opportunity created through a contract
    Given  I create 1 "Basic" accounts
    And I go to "Contract Page"
    And I create New Contract with
      | Account       | [new Account] |
      | Start Date    | TODAY         |
      | Contract Term | 3             |
    And I go to "Opportunities Page"
    And I create New Opportunity with
      | Opportunity Name | New Opportunity     |
      | Close Date       | TODAY             |
      | Stage Name       | Value Proposition |
    When I close the opportunity as "Won Closed"
    Then the application should display a message "Stage changed successfully."
    And On opportunities object should be display current stage
