Feature: Campaign

  @DeletesLeads
  @DeletesCampaign
  Scenario: Add leads at the same time
    Given I create 3 "Basic" leads
      And I go to "Campaigns Page"
      And I create a new Campaign with
        | Campaign Name | Promotion Test |
        | Active        | true           |
    When I add the leads to the campaign
    Then the application should display this message in Campaign Page
      | Lightning | [Campaign Name] was successfully updated. 3 new members were added to [Campaign Name]. |
      | Classic   | You have successfully added 3 member(s).                                               |
      And campaign members should display the leads added


  @JuanMartinez
  @DeletesCampaign
  @DeletesContacts
  Scenario: Assign 3 contacts to campaign
    Given I create 3 "Basic" contacts
      And I go to "Campaigns Page"
      And I create a new Campaign with
        | Campaign Name | Testing Contacts |
        | Active        | true             |
    When I go to "Campaigns Page"
      And I select the campaign
      And I add the contacts the campaign
    When I go to "Campaigns Page"
      And I select the campaign
    Then The added contacts should be displayed on Campaign Members page
