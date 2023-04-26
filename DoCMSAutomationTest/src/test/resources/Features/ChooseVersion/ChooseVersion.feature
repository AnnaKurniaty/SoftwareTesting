#Author : Dhiya Fakhar Nafi
#Date : 11 April 2023
#Description : Memilih versi dokumentasi
@SmokeScenario
Feature: Menguji pemilihan versi dokumentasi

  @SmokeTest
  Scenario: check login is successful with valid credentials
    Given browser is open 
    Given user is on portal page
    When user click version
    And user choose another version

    # Skenario kedua:
    # And user choose same version

  Scenario Outline: check login is successful with valid credentials
    Given browser is open 
    Given user is on portal page
    When user click version
    And user choose another version
    
    # Skenario kedua:
    # And user choose same version
