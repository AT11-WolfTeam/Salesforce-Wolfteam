Feature: Product

  @DeletesOpportunity
  @Product
  Scenario: Add a product to opportunity through Standard Price Book
    Given I go to "Products Page"
      And I create a new product with the following values
        | Product Name        | Cookie          |
        | Product Code        | c101            |
        | Product Description | Testing product |
        | List Price          | 5               |
        | Quantity            | 20              |
        | Date                | TODAY           |
      And I go to "Products Page"
      And I select the product
      And I add the product to "Standard Price Book"
      And I create 1 "Basic" opportunities
      And I go to "Opportunities Page"
    When I select the opportunity
      And I add the product to opportunity
    Then The product should be displayed on Products page
