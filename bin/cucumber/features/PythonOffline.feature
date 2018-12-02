Feature: Clicking the different links on the Python offline tutorial

  # Feature file to to use when the internet connectivity is slow
  @Python @OfflineTest
  Scenario: Clicking the Tutorial link
    Given I am on Python Website
    When I click on "Tutorial" link
    Then I close window

  @Python @OfflineTest
  Scenario: Clicking the FAQs link
    Given I am on Python Website
    When I click on "FAQs" link
    Then I close window

  @Python @OfflineTest
  Scenario: Clicking the Test Fail link
    Given I am on Python Website
    When I click on "Test Fail" link
    Then I close window

  @Python @OfflineTest
  Scenario: Clicking the Library Reference link
    Given I am on Python Website
    When I click on "Library Reference" link
    Then I close window
