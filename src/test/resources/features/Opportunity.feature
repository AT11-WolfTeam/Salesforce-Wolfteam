Feature: Opportunity

  @wip
  Scenario: Change opportunity owner to another user
    Given I create opportunity as OpportunityTest
    And I navigate to Opportunities Page
    And I search an opportunity "Edge SLA" in list "All Opportunities"
    When I change an opportunity's owner with "CurrentOwner"
    Then the application should display an information message in Opportunity page with the format "[[Owner Name]] now owns the record for [[Opportunity Name]]"


  @wip
  Scenario: Close an opportunity with another owner
    Given I login as "Admin"
    And I navigate to Opportunities Page
    And I create an Opportunity with
      | Opportunity Name | testing close stage |
      | Close Date       | 03/31/2020          |
      | Stage            | Qualification       |
    And I select to "AdminUser" as a new owner
    When I close the opportunity as Close Won
    Then the application should display an information message in Opportunity page with the format "Stage changed successfully."
    And On the opportunities page should display on the column stage as "Closed Won"


  @wip
  Scenario: Add additional information to created task.
    Given I create opportunity with task as OpportunityTest
    And I go to Opportunity Page
    And I go to the opportunity already created
    And I created a task with requirement fields
    When I add additional information to the task
      | Subject  | Call      |
      | Due date | 3/31/2020 |
    Then  the application should display an information message in Opportunity page with the format "Task [subject] was saved"
    And the section Upcoming & Overdue should display the "[subject]"


  @wip
  Scenario: Assign a campaign to an opportunity
    Given I go to Campaign Page
    And I create a new Campaign with
      | Campaign Name | Promotion |
    And I go to Opportunity Page
    And I go to the opportunity already created
    And I go to Edit opportunity
    When I assign the Campaign
    Then the application should display an information message in Opportunity page with the format "Opportunity [Name Opportunity] was saved."
    And On the details section should display the Campaign name "[campaign name]"


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