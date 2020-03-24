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


  @CampaignAccounts
  Scenario: Assign 3 contacts to campaign
    Given I create 3 "Basic" contacts
    And I go to "Campaigns Page"
    And I create a new Campaign with
      | Campaign Name | Testing Contacts |
      | Active        | true             |
    When I add the contacts to "Campaigns Page"
    Then The added contacts should be displayed on "Campaign Members" page
    And I delete created accounts
