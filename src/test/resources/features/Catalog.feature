Feature: Catalog

  Scenario: Categories
    Given I'm the admin
    When the name is "motor" and categorie is "Interior" and price is "5000" and availability "true" and descriptions is "essintial part"
    Then the product is added to the Interior section

  Scenario: Product listings
    Given I'm the admin
    When I request information about specific product by entering its name "motor"
    Then Make the product descriptions, prices, and availability appear

  Scenario: Search
    Given I'm the admin
    When I request information about products by entering there categories "Electronics"
    Then List all the products name, prices, availability and descriptions

  Scenario: Search
    Given I'm the admin
    When I request information about products by entering there price "1000"
    Then List all the products name, categories, availability and descriptions

    Scenario: Filter
      Given I'm the admin
      And the product categories is loaded "Electronics"
      When I filter products by a price range of "100" to "500"
      Then List all the products name, prices, availability and descriptions within that price range
