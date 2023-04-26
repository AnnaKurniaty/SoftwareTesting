#Author
#Date
#Description
@RegisterScenario
Feature: feature to test register funcionality
  
  @InvalidTest
  Scenario: check register unsuccess because firstname unfill
    Given browser is openn 
    And user is on login pagee
    And click create account
    When user enters "<firstname>" and "<lastname>" and "<email>" and "<username>" and "<password>"
    And clicks on create button
    Then message required firstname

    Examples: 
      |firstname| lastname | email | username  |  | password  |
      | [blank] | AAAA     | AAAA  | AAAA      |  | AAAAAAAA  |   
      
  @InvalidTest
  Scenario: check register unsuccess because lastname unfill
    Given browser is openn 
    And user is on login pagee
    And click create account
    When user enters "<firstname>" and "<lastname>" and "<email>" and "<username>" and "<password>"
    And clicks on create button
    Then message required lastname

    Examples: 
      |firstname| lastname | email | username  |  | password  |
      | AAAA    | [blank]  | AAAA  | AAAA      |  | AAAAAAAA  |   
      
  @InvalidTest
  Scenario: check register unsuccess because email unfill
    Given browser is openn 
    And user is on login pagee
    And click create account
    When user enters "<firstname>" and "<lastname>" and "<email>" and "<username>" and "<password>"
    And clicks on create button
    Then message required email

    Examples: 
      |firstname| lastname | email    | username  |  | password  |
      | AAAA    | AAAA     | [blank]  | AAAA      |  | AAAAAAAA  |   
 
  @InvalidTest
  Scenario: check register unsuccess because username unfill
    Given browser is openn 
    And user is on login pagee
    And click create account
    When user enters "<firstname>" and "<lastname>" and "<email>" and "<username>" and "<password>"
    And clicks on create button
    Then message required username

    Examples: 
      |firstname| lastname | email | username  |  | password  |
      | AAAA    | AAAA     | AAAA  | [blank]   |  | AAAAAAAA  |   

  @InvalidTest
  Scenario: check register unsuccess because password unfill
    Given browser is openn 
    And user is on login pagee
    And click create account
    When user enters "<firstname>" and "<lastname>" and "<email>" and "<username>" and "<password>"
    And clicks on create button
    Then message required password

    Examples: 
      |firstname| lastname | email | username  |  | password  |
      | AAAA    | AAAA     | AAAA  | AAAA      |  | [blank]   |   