Feature: PriceBooks

  @wip
  Scenario: Assign product to a new Price Book
    Given I go to "Products Page"
    And I create a new product with the following values
      | Product Name        | Oreo            |
      | Product Code        | coke01          |
      | Product Description | Testing product |
      | List Price          | 12              |
    And I go to "Products Page"
    And I select the product
    And I add the product to "Standard Price Book"
    And I go to "PriceBooks Page"
    And I create a new PriceBook with
      | Price Book Name | New Price Book |
    When I add the product created
    Then the application should display "1 record was updated."
    And the product should be displayed on the table
