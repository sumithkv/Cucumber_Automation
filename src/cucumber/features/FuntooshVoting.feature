Feature: Testing the Funtoosh Poll based on Age

  # Feature file to learn Cucumber Hooks
  @FunToosh
  Scenario Outline: Voting for different Age groups
    Given I am on FunToosh website
    When I selected the Age <Radio>
    And I clicked on Vote button
    Then I should get Funtoosh Poll Results

    Examples: 
      | Radio         |
      | less than 15  |
      | 15 - 18       |
      | 19 - 24       |
      | 25 - 30       |
      | More than 30  |
      | More than 100 |
