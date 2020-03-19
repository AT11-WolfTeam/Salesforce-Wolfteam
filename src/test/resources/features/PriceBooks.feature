Feature: PriceBooks

  @wip
  Scenario: Assign products to a new Price Book
    Given I login as "Admin"
    And I create product as ProductTest01
    And I create product as ProductTest02
    And I create PriceBook as "PriceBookTest"
    And I search "PriceBookTest"
    When I change an opportunity's owner with "CurrentOwner"
    Then the application should display an information message in Opportunity page with the format "[[Owner Name]] now owns the record for [[Opportunity Name]]"