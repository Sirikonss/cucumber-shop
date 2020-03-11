Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given a product Bread with price 20.50 exists and have 4 pieces
    And a product Jam with price 80.00 exists and have 5 pieces

Scenario: Buy one product
    When I buy Bread with quantity 2
    Then Product Bread left 2 pieces
    Then total should be 41.00

Scenario: Buy multiple products
    When I buy Bread with quantity 2
    And I buy Jam with quantity 1
    Then total should be 121.00
    Then Product Bread left 2 pieces
    Then Product Jam left 4 pieces



