Feature: Search and place the orders for products

  @product
  Scenario Outline: Search experience for product search in both home and offers page

    Given User is on GreenCard landing page
    When User searched with shortname as <Name> and extracted actual name of product
    Then user searched for <Name> same shortname in offers page to check if product exist with same name
    Examples:
      |Name  |
      |Tom   |
      |pot   |