Feature: Installation Requests
  Customers can request installation services for certain products.
  Form to specify installation details (e.g., car make/model, preferred date).
  Installer availability and appointment scheduling.

  Scenario: Customer submits an installation request
    Given I'm the Customer
    And My name is "Mai"
    And  I'm on the installation request page
    When the customer fills in the following details: model is "Toyota" and date "20-10-2023"
    And submits the form
    Then the request should be successfully submitted if the date available

  Scenario: Customer submits an invalid installation request
    Given I'm the Customer
    And My name is "Mai"
    And  I'm on the installation request page
    When the customer fills in the following details: model is "Honda" and date "25-10-2023"
    And  submits the form
    Then the request should not be submitted if the date is not available
