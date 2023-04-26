#Author : Dhiya Fakhar Nafi
#Date : 11 April 2023
#Description : Pengujian section
@SmokeScenario
Feature: Menguji fitur section pada portal

  @SmokeTest
  Scenario: check login is successful with valid credentials
    Given browser is open 
    Given user is on portal page
    When user find section
    
    # Skenario kedua:
    # When user find no one section

  Scenario Outline: check login is successful with valid credentials
    Given browser is open 
    Given user is on portal page
    When user find section

    # Skenario kedua:
    # When user find no one section
