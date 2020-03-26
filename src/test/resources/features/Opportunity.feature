Feature: Opportunity

  @DeletesOpportunity
  Scenario: Change opportunity owner to another user
    Given I create 1 "Basic" opportunities
    When I go to "Opportunities Page"
    And I search for the opportunity in list "All Opportunities"
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
      | Campaign Name | Promotion |
    Then On the details section should display the Campaign name


  @DeletesOpportunity @DeletesContact
  Scenario: add contact with due Date to a new Task
    Given I create 1 "Basic" contacts
      And I create 1 "Basic" opportunities
      And I go to "Opportunities Page"
    When I add new Task with
      | Subject  | Meeting            |
      | Contact  | [Contact]          |
      | Due Date | TODAY-AFTER 3 DAYS |
    Then I validate the information on user lightning experience
      |Task [Task Name] was created. |
      And the task should display the information added


  @DeletesOpportunity
  Scenario: Add new Task with required values
    Given I create 1 "Basic" opportunities
    And I go to "Opportunities Page"
    And I search the opportunity in list "All Opportunities"
    When TO DO
    Then TO DO


  @wip
  Scenario: Add new event with required values
    Given I login as "Admin"
    And I create opportunity as OpportunityTest
    And I navigate to Opportunities Page
    And I search "OpportunityTest"
    When I add an event to "OpportunityTest"
      | Subject    | Example Subject |
      | Start Date | Today           |
      | End Date   | In a week       |
    Then the application should display an information message in Opportunity page with the format "Event Example Subject was created"
    And Upcoming & Overview tab contains the event created


  Scenario: Create a new opportunity
    Given I create 2 "Basic" opportunities
    When I delete created opportunities

