Feature: AdminDash
  Scenario: adding a product
    Given I'm the admin
    When the name is "motor_v5" and the category is "Interior" and the price is 5000 and the num of av p is 1 and the discription is "good way"
    Then the product add successfully
  Scenario: view customer account
    Given I'm the admin
    When I ask you to list all the customer account
    Then the customer account must be appear on the screen
  Scenario: change customer's information
    Given I'm the admin
    When I enter the name for user "Fatina" and the new password that i want to put it "234345"
    Then The password must change successfully
  Scenario: update product
    Given I'm the admin
    When I give the name of product"motor" and the new price for it 1000
    Then The price must change successfully
  Scenario: make a schedule for appointments
    Given I'm the admin
    When I give you a date "20-10-2023"
    Then this date must be added to the appointment as a free day to install