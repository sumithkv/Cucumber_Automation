Feature: Registering multiple users on Fluent English Learning WebSite

  # Feature file for learning DATA TABLES
  @FluentEnglish
  Scenario: Registerig in www.fluentin3months.com for User 1
    Given I am on Fluent English page
    When I enters valid data and submit the page
      | Field    | Value                    |
      | Name     | Sanusha Sumith           |
      | Email    | sanusha.sumith@gmail.com |
      | Language | French                   |
    Then I should register the user successfully
    And I close the browser

  @FluentEnglish
  Scenario: Registerig in www.fluentin3months.com for User 2
    Given I am on Fluent English page
    When I enters valid data and submit the page
      | Field    | Value               |
      | Name     | Swara Das           |
      | Email    | swara.das@gmail.com |
      | Language | German              |
    Then I should register the user successfully
    And I close the browser

  @FluentEnglish
  Scenario: Registerig in www.fluentin3months.com for User 3
    Given I am on Fluent English page
    When I enters valid data and submit the page
      | Field    | Value              |
      | Name     | Test Man           |
      | Email    | test.man@yahoo.com |
      | Language | Spanish            |
    Then I should register the user successfully
    And I close the browser
