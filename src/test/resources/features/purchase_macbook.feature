Feature: Purchase MacBook Air
  As a Demoblaze user
  I want to purchase a MacBook Air
  So that I can confirm the site works correctly

  Scenario: Add MacBook Air to cart and complete the purchase
    Given I am on the Demoblaze website
    When I select the Laptops category
    And I choose the product "MacBook air" with price "700"
    And I add it to the cart
    And I open the shopping cart
    Then the product "MacBook air" should have the price "700"
    When I place the order with the following details:
      | name     | country | city      | credit card       | month | year |
      | John Doe | USA     | New York  | 1234567890123456  | 12    | 2026 |
