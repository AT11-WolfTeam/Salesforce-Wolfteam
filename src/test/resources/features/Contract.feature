Feature: Contract

  @AlanEscalera
  @DeleteAccounts @DeleteContract @DeleteAnOpportunity
  Scenario: Close an opportunity created through a contract
    Given  I create 1 "Basic" accounts
      And I go to "Contracts Page"
      And I create New Contract with
        | Account       | [new Account] |
        | Start Date    | TODAY         |
        | Contract Term | 3             |
      And I go to "Opportunities Page"
      And I create new opportunity with the following values
        | Name      | New Opportunity   |
        | CloseDate | TODAY             |
        | StageName | Value Proposition |
    When I select stage as "Closed"
      And I close the opportunity as "Closed Won"
    Then the application should display a message "Stage changed successfully."
      And I go to "Opportunities Page"
    And On opportunities object should be display the current stage
