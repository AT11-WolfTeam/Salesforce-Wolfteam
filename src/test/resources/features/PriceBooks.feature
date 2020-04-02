Feature: PriceBooks

  @wip
  Scenario: Assign products to a new Price Book
    Given I go to "PriceBooks Page"
      And I create a new PriceBook with
      |Price Book Name| New Price Book|
      When I add the product "detergentes"
    Then the application should display "1 record was updated."
    And the product should be displayed on the table


    