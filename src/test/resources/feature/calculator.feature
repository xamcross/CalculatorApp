Feature: Calculator
  Scenario: Sum two numbers
    Given I have two numbers: 50 and 2
    When the calculator sums them
    Then I receive 52 as a result