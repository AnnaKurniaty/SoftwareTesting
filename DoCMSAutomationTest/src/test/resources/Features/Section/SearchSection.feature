#Author
#Date
#Description
@SearchSectionScenario
Feature: feature to test search section funcionality 

  @ValidTest
  Scenario: check search section is successful with keyword available in database
    Given user is in homepage
    And click on section button
    When user enters "<keyword>"


    Examples: 
      | keyword    |
      | Countdown  |
      
  @InvalidTest
  Scenario: check search section is unsuccessful with keyword not available in database
    Given user is in homepage
    And click on section button
    When user enters "<keyword>"


    Examples: 
      | keyword    |
      | Video      |
      
  @InvalidTest
  Scenario: check search section is unsuccessful with name author as keyword 
    Given user is in homepage
    And click on section button
    When user enters "<keyword>"


    Examples: 
      | keyword    |
      | mfauzirh   |