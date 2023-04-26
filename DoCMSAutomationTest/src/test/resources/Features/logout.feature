#Author
#Date
#Description
@LogoutScenario
Feature: feature to test logout funcionality

  @ValidTest
  Scenario: check logout is successful 
    Given user in homepage
    And clicks on profile
    And clicks on logout
    Then navigate login page

    Examples: 
      | username  |  | password  |
      | victornat |  | Victor123 |
      