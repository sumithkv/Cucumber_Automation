Feature: Listing Flights between two stations on different dates

  # Feature file for learning OUTLINE DATA TABLES
  # This will run the Scenario multiple times by using the values in the Data Table
  @SpiceJet @Flight
  Scenario Outline: Flights between two stations
    Given I am on SpiceJet Website
    When I selected One Way Trip
    And I am travelling between <Source> to <Destination>
    And I am travelling on 23-11-2015
    And I selected <Adults> and <Child>
    And I click on the Find Flight button
    Then I should get the Flight Information
    And I close my window

    Examples: 
      | Source          | Destination   | Adults | Child |
      | Bengaluru (BLR) | Chennai (MAA) |      3 |     1 |
      | Goa (GOI)       | Chennai (MAA) |      2 |     2 |
      | Delhi (DEL)     | Kochi (COK)   |      4 |     3 |
      | Bengaluru (BLR) | Mumbai (BOM)  |      1 |     1 |
      | Mumbai (BOM)    | Chennai (MAA) |      2 |     1 |
