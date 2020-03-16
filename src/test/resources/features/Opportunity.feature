Feature: Opportunity

  Scenario: Change an owner
    Given Create opportunity as "OpportunityTest"
    When I change a opportunity's owner with "CurrentOwner"
    Then The application should display information message "CurrentOwner.name now owns the record for OpportunityTest.name."