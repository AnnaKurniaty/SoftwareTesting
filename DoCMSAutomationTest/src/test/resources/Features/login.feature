#Author
#Date
#Description
@LoginScenario
Feature: feature to test login funcionality 

  @ValidTest
  Scenario: check login is successful with valid credentials
    Given browser is open 
    And user is on login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username    |  | password  |
      | victornat   |  | Victor123 |
      
 	@InvalidTest
 	Scenario Outline: check login is un-successful with invalid credentials
    Given browser is open 
    And user is on login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then user got error message

    Examples: 
      | username      |  | password  |
      | indra         |  | Victor123 |
      | victornat     |  | tes123!!  |

 	@BlankTest
 	Scenario Outline: check login is un-successful with username and password unfill
    Given browser is open 
    And user is on login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then username blank
    And password blank

    Examples: 
      |username  |  | password |
      | [blank]  |  | [blank]  |
      
  @BlankTest
 	Scenario Outline: check login is un-successful with username unfill
    Given browser is open 
    And user is on login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then username blank

    Examples: 
      |username  |  | password |
      | [blank]  |  | Victor123  |
      
  @BlankTest
 	Scenario Outline: check login is un-successful with password unfill
    Given browser is open 
    And user is on login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then password blank

    Examples: 
      |username  |  | password |
      | victornat  |  | [blank]  |
      
      