Feature: Campaign

  @DeletesCampaign
  Scenario: Add leads at the same time
    Given I create 3 "Basic" leads
      And I go to "Campaigns Page"
      And I create a new Campaign with
        | Campaign Name | Promotion |
        | Active        | true      |
    When I add the leads to the campaign
    Then the application should display this message in Campaign Page only for Lightning
      | "[Campaign Name] was successfully updated. 2 new members were added to [Campaign Name]" |
      And the campaign's details should display

