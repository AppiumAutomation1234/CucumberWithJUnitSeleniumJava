Feature: Search and place the orders for products

  @checkout
  Scenario Outline: Search experience for product search in both home and offers page

    Given User is on GreenCard landing page
    When User searched with shortname as <Name> and extracted actual name of product
    And Added 3 items of the selected product to cart
    Then User proceeds to checkout and validate the <Name> items in checkout page
    And Verify user has ability to enter the promo code and place the order
    Examples:
      |Name  |
      |Tomato|
