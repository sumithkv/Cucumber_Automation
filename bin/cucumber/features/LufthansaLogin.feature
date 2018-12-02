Feature: Testing the different options in Login page

  # Feature file to learn the basic cucumber
  @Lufthansa @Flight
  Scenario: Verifying the login using invalid user credentials
    Given I am on Lufthansa website
    When I click on the Login link
    And I enters invalid User Name and Password
    And I uncheck the Keep Me Logged In checkbox
    And I click on the Login button
    Then I should see Login Failed message
    And I close the browser

  @Lufthansa @Flight
  Scenario: Verifying the login using valid user credentials
    Given I am on Lufthansa website
    When I click on the Login link
    And I enters valid User Name and Password
    And I uncheck the Keep Me Logged In checkbox
    And I click on the Login button
    Then I should see User Profiles
    And I close the browser

  @Lufthansa @Flight
  Scenario: Verifying Forgot Password
    Given I am on Lufthansa website
    When I click on the Login link
    And I click on the Forgot Password link
    Then I should see Request new password
    And I close the browser
