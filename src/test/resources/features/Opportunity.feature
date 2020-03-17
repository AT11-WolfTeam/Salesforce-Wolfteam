Feature: Opportunity

  Scenario: Change an owner
    Given I create opportunity as OpportunityTest
    When I change an opportunity's owner with "CurrentOwner"
    Then the application should display an information message in Opportunity page with the format "[[Owner Name]] now owns the record for [[Opportunity Name]]"


  Scenario: Close an opportunity with an another owner
    Given I login as "Admin"
    And I navigate to Opportunities Page
    And I create an Opportunity with
      | Opportunity Name | testing close stage |
      | Close Date       | 03/31/2020       |
      | Stage            | Qualification    |
    And I select to "Juan Martinez" as a new owner
    When I close the opportunity as close won
    And I save it
    Then the application should display an information message in Opportunity page with the format "Stage changed successfully."
    And On the opportunities page Should display On the column stage as "Closed Won"


    Given I have created an Opportunity
    And I go to Opportunity Page
    And I go to the opportunity already created
    And I created a task with requirement fields
    When I add additional information to the task
      | Subject  | Call      |
      | Due date | 3/31/2020 |
    Then  the application should display an information message in Opportunity page with the format "Task [subject] was saved"
    And On the section Upcoming & Overdue should display the "[subject]"


  Scenario: Assign a campaign to an opportunity
    Given I go to Campaign Page
    And I create a new Campaign with the name "Promotion"
    And I go to Opportunity Page
    And I go to the opportunity already created
    And I go to Edit opportunity
    When I assign the Campaign
    Then the application should display an information message in Opportunity page with the format "Opportunity [Name Opportunity] was saved."
    And On the edit section should display the Campaign name "[campaign name]"
