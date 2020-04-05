Feature: Account

  @JuanMartinez
  Scenario: Test create account
    Given I create 2 "Complete" accounts
    When I delete created accounts
