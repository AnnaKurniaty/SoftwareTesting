#Author
#Date
#Description
@SmokeScenario
Feature: feature to test login funcionality

  @SmokeTest
  Scenario: check login is successful with valid credentials
    Given browser is open gogrids
    And user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page

  @SmokeTest
  Scenario Outline: check login is successful with valid credentials
    Given browser is open gogrids
    And user is on login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then user is navigated to the home page

    Examples:
      | username   |  | password   |
      | Annakrnt_  |  | Annakrnt25 |
      | Annakrnt_  |  | <blank>    |
      | <blank>    |  | <blank>    |
      | away       |  | <blank>    |
      | <blank>    |  | tes123     |