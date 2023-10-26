Feature: UserProfile

  Scenario: Customer edits their profile
    Given I'm the Customer
    And my name is "Fatina"
    When I entered new password "234354"
    Then Your information Updates successfully

  Scenario: Customer views order history and installation requests
    Given I'm the Customer
    When my name is "Fatina"
    Then The information should appear
