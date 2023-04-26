#Author: M Azhar Alauddin
#Date: 10 April 2023
#Description: Register DoCMS Automation Testing
@SmokeScenario
Feature: feature to test register functionality

  @SmokeTest
  Scenario: check regsiter is successful with valid credentials
    Given browser is opened
    And user is on register page
    When user enters azhar3, alauddin3, zharmedia3@gmail.com, zharmedia3 and zharmedia123
    And user clicks on register button

  @SmokeTest
  Scenario: check regsiter is un-successful with registered account
    Given browser is opened
    And user is on register page
    When user enters fauzi, hamdalah, fauzi@gmail.com, mfauzirh and fauzicakepgituloh
    And user clicks on register button
