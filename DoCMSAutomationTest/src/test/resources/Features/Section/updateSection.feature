#Author: M Azhar Alauddin
#Date: 10 April 2023
#Description: Update Section Automation Testing
@SmokeScenario
Feature: feature to test update section functionality
	
	@SmokeTest
  Scenario: Update Section is successful with Valid Input
    Given browser is open
    And user is on login page
    When user enters mfauzirh and fauzicakepgituloh
    And user clicks on login button
    And user is on section page
		And user clicks on first edit section button
		When user fills section title NewSectionTitle 
		When user fills section alias NewSection
		When user fills section content ThisIsNewSection
		
	@SmokeTest
  Scenario: Update Section is successful with Valid Input
    Given browser is open
    And user is on login page
    When user enters mfauzirh and fauzicakepgituloh
    And user clicks on login button
    And user is on section page
		And user clicks on first edit section button
		When user fills section alias NewSection
		When user fills section content ThisIsNewSection
			
	@SmokeTest
  Scenario: Update Section is successful with Valid Input
    Given browser is open
    And user is on login page
    When user enters mfauzirh and fauzicakepgituloh
    And user clicks on login button
    And user is on section page
		And user clicks on first edit section button
		When user fills section title NewSectionTitle 
		When user fills section content ThisIsNewSection
		
	@SmokeTest
  Scenario: Update Section is successful with Valid Input
    Given browser is open
    And user is on login page
    When user enters mfauzirh and fauzicakepgituloh
    And user clicks on login button
    And user is on section page
		And user clicks on first edit section button
		When user fills section title NewSectionTitle 
		When user fills section alias NewSection