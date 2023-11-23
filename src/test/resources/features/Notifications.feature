
Feature: Notifications

  Scenario: Customer receives order confirmation and updates
    Given I'm the Customer
    And I have placed an order
    When the order is confirmed and updates are available
    Then Send email to "maiislmii84@gmail.com"

  Scenario: Installer receives notification for new installation requests
    Given I'm the Installer
    When the request is ready to be assigned to an installer
    Then Send email to "tahertona@gmail.com"