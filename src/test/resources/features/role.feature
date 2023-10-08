Feature: Roles

  Scenario: Admin role
    Given I am in system
    And I'm the admin
    When set user name "haya" and pass "123"
    Then you can Manage products
    And see categories
    And access user accounts


  Scenario: Customer role
    Given I am in system
    And I'm the Customer
    When set user name "Mai" and pass "54321"
    Then You can Browse products
    And Make purchases
    And View orders


  Scenario: Installer role
    Given I am in system
    And I'm the Installer
    When Set user name "haya" and pass "123"
    Then You can View installation requests
    And View schedule appointments