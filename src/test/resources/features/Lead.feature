Feature: Lead

  Scenario: Change Status to leads at the same time
    Given I create 3 "Basic" leads
    When I go to "Leads Page"
      And I change Lead Status to "Working - Contacted" of the leads in list "Recently Viewed Leads"
    Then the application should display this message in Leads Page only for Lightning Experience
      |  |
      And Leads Page should display the leads modified