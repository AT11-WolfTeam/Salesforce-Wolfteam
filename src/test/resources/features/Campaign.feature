Feature: Campaign

  @wip
  Scenario: Add leads at the same time
    Given I login as "Admin"
    And I create account as "CurrentAccount"
    And I create campaign as "CampaignTest"
    And I create lead as "LeadTest01"
    And I create lead as "LeadTest02"
    And I go to "Home" page
    And I got to "Campaign" page
    And I search "CampaignTest"
    When I add leads created to the campaign
    Then the application should display an information message in Campaign page with the format "[[Campaign Name]] was successfully updated. 2 new members were added to [[Campaign Name]]"

