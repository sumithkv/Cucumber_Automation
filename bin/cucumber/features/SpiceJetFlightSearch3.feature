Feature: Finding the low cost flight between two different stations on different dates

  # Feature file to learn BACKGROUND keyword.
  # Background keyword is used to define steps which are common to all the tests in the feature file
  Background: User Selected One Way Trip
    Given I am on SpiceJet Website
    And I selected One Way Trip

  @SpiceJet @Flight
  Scenario: Flights from "Bengaluru" to "Chennai"
    And I am travelling from "Bengaluru (BLR)" to "Chennai (MAA)"
    And I am travelling on 23-12-2015
    And I selected 3 Adults and 1 Child
    And I click on the Find Flight button
    Then I should get the Flight Information
    And I close my window

  @SpiceJet @Flight
  Scenario: Flights from "Bengaluru" to "Mumbai"
    And I am travelling from "Bengaluru (BLR)" to "Mumbai (BOM)"
    And I am travelling on 27-10-2015
    And I selected 2 Adults and 1 Child
    And I click on the Find Flight button
    Then I should get the Flight Information
    And I close my window

  @SpiceJet @Flight
  Scenario: Flights from "Mumbai" to "Chennai"
    And I am travelling from "Mumbai (BOM)" to "Chennai (MAA)"
    And I am travelling on 30-10-2015
    And I selected 2 Adults and 2 Child
    And I click on the Find Flight button
    Then I should get the Flight Information
    And I close my window
