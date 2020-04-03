Feature: Opportunity

  @DeleteAccounts
  @DeletesCampaign
  Scenario: Create new opportunity with all values.
    Given I create 1 "Basic" accounts
    And I go to "Campaigns Page"
    And I create a new Campaign with
      | Campaign Name | Testing Campaign |
      | Active        | true             |
    When I go to "Opportunities Page"
    And I create new opportunity with the following values
      | Name                        | Testing Opportunity |
      | AccountName                 | BasicAccount1       |
      | Type                        | New Customer        |
      | LeadSource                  | Web                 |
      | Amount                      | 10000               |
      | CloseDate                   | TODAY               |
      | NextStep                    | Level 2             |
      | StageName                   | Prospecting         |
      | Probability                 | 0                   |
      | PrimaryCampaignSource       | Testing Campaign    |
      | OrderNumber                 | 10                  |
      | CurrentGenerator            | First               |
      | TrackingNumber              | 123456              |
      | MainCompetitor              | Trello              |
      | Delivery/InstallationStatus | In progress         |
      | Description                 | Testing Description |
    Then The added Information should be displayed on Opportunity Page


  @DeletesOpportunity
  Scenario: Change opportunity owner to another user
    Given I create 1 "Basic" opportunities
    When I go to "Opportunities Page"
      And I search for the opportunity in list "Recently Viewed Opportunities"
      And I change the opportunity's owner with "Current User"
    Then the application should display this message in Opportunity Page only for Lightning Experience
      | [Current User] now owns the record for [Opportunity Name]. |
      And the opportunity page displays the owner "Current User"


  @DeletesOpportunity
  Scenario: Add additional information to created task.
    Given I create 1 "Basic" opportunities
      And I go to "Opportunities Page"
      And I add new Task with
      | Subject | Call |
    When I add additional information to the task
      | Subject  | Call to meeting |
      | Status   | In Progress     |
      | Priority | High            |
      And the task should display the information added


  @DeletesCampaign @DeletesOpportunity
  Scenario: Assign a campaign to an opportunity
    Given I create 1 "Basic" opportunities
      And I go to "Campaigns Page"
      And I create a new Campaign with
        | Campaign Name | Promotion |
        | Active        | true      |
      And I go to "Opportunities Page"
    When I assign the Campaign to the opportunity
      | PrimaryCampaignSource | Promotion |
    Then On the details section should display the Campaign name


  @DeletesOpportunity @DeletesContacts
  Scenario: add contact with due Date to a new Task
    Given I create 1 "Basic" contacts
      And I create 1 "Basic" opportunities
      And I go to "Opportunities Page"
    When I add new Task with
      | Subject  | Meeting                                |
      | Contact  | [Contact]                              |
      | Due Date | 3 DAYS-0 MONTH-0 YEAR-AFTER-FROM TODAY |
    Then the application should this message only for Lightning Experience
      |Task [Task Name] was created. |
      And the task should display the information added


  @DeletesOpportunity
  Scenario: Add new Task with required values
    Given I create 1 "Basic" opportunities
    When I go to "Opportunities Page"
      And I add new Task with
        | Subject     | Call        |
        | Assigned To | Admin User  |
        | Status      | In Progress |
    Then the application should this message only for Lightning Experience
      | Task [Task Name] was created. |
    And the task should display the information added


  @DeletesOpportunity
  Scenario: Add new event with required values
    Given I create 1 "Basic" opportunities
    When I go to "Opportunities Page"
      And I search for the opportunity in list "Recently Viewed Opportunities"
      And I add new Event with
        | Subject    | Example Subject                        |
        | Start Date | TODAY                                  |
        | End Date   | 3 DAYS-0 MONTH-0 YEAR-AFTER-FROM TODAY |
    Then the application should display this message in Opportunity Page
      | Event Example Subject was created. |
    And Upcoming & Overview tab contains the event created


  Scenario: Create a new opportunity
    Given I create 2 "Basic" opportunities
    When I delete created opportunities


  @DeleteContacts
  @DeletesOpportunity
  Scenario: Add roles to contacts of an opportunity
    Given I create 3 "Basic" contacts
      And I create 1 "Basic" opportunities
    When I go to "Opportunities Page"
      And I select the opportunity
      And I add roles its contacts
    Then The added contacts with roles should be displayed on Contact Roles page

