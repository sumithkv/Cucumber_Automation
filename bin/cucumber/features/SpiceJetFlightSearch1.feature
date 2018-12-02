Feature: Finding the low cost flight between two different stations on different dates

  # Feature file to learn normal PARAMETER passing
  @SpiceJet @Flight
  Scenario: Flights from "Bengaluru" to "Chennai"
    Given I am on SpiceJet Website
    When I selected One Way Trip
    And I am travelling from "Bengaluru (BLR)" to "Chennai (MAA)"
    And I am travelling on 23-11-2015
    And I selected 3 Adults and 1 Child
    And I click on the Find Flight button
    Then I should get the Flight Information
    And I close my window

  @SpiceJet @Flight
  Scenario: Flights from "Bengaluru" to "Mumbai"
    Given I am on SpiceJet Website
    When I selected One Way Trip
    And I am travelling from "Bengaluru (BLR)" to "Mumbai (BOM)"
    And I am travelling on 27-11-2015
    And I selected 2 Adults and 1 Child
    And I click on the Find Flight button
    Then I should get the Flight Information
    And I close my window

  @SpiceJet @Flight
  Scenario: Flights from "Mumbai" to "Chennai"
    Given I am on SpiceJet Website
    When I selected One Way Trip
    And I am travelling from "Mumbai (BOM)" to "Chennai (MAA)"
    And I am travelling on 30-11-2015
    And I selected 2 Adults and 2 Child
    And I click on the Find Flight button
    Then I should get the Flight Information
    And I close my window

  @SpiceJet @Flight
  Scenario: Flights from "Goa" to "Chennai"
    Given I am on SpiceJet Website
    When I selected One Way Trip
    And I am travelling from "Goa (GOI)" to "Chennai (MAA)"
    And I am travelling on 22-12-2015
    And I selected 2 Adults and 4 Child
    And I click on the Find Flight button
    Then I should get the Flight Information
    And I close my window

  @SpiceJet @Flight
  Scenario: Flights from "Delhi" to "Kochi"
    Given I am on SpiceJet Website
    When I selected One Way Trip
    And I am travelling from "Delhi (DEL)" to "Kochi (COK)"
    And I am travelling on 13-11-2015
    And I selected 4 Adults and 1 Child
    And I click on the Find Flight button
    Then I should get the Flight Information
    And I close my window
