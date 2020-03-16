Feature: Opportunity

  Scenario: Change an owner
    Given I create opportunity as OpportunityTest
    When I change an opportunity's owner with "CurrentOwner"
    Then the application should display an information message in Opportunity page with the format "[[Owner Name]] now owns the record for [[Opportunity Name]]"

    