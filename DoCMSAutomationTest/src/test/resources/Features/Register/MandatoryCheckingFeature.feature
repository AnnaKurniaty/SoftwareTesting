#Author: Rangga Yudha Yudistira
#Date: 14 April 2023
#Description: Mandatory checking feature

@RegisterMandatoryCheckingFeature
Feature: feature to test mandatory fields on register page functionality

  @InvalidScenario
  Scenario: Check register is un-successful with invalid data. One field is empty
    Given browser terbuka
    Given user berada di register page
    When user memasukkan <firstName>, <lastName>, <email>, <username>, dan <password>
    And klik tombol register
    Then sistem menampilkan error pada lokasi <location>
    
    Examples: 
      | firstName |  | lastName |  | email        |  | username |  | password       |  | location                                                              |
      | [blank]   |  | yudha    |  | ry@gmail.com |  | rangyuds |  | ranggayudha123 |  | "//*[@id=\"register-form\"]/div[1]/div[1]/div/div/div[2]/div/div/div" |
      | rangga    |  | [blank]  |  | ry@gmail.com |  | rangyuds |  | ranggayudha123 |  | "//*[@id=\"register-form\"]/div[1]/div[2]/div/div/div[2]/div/div/div" |
      | rangga    |  | yudha    |  | [blank]      |  | rangyuds |  | ranggayudha123 |  | "//*[@id=\"register-form\"]/div[2]/div/div[2]/div/div/div"            |
      | rangga    |  | yudha    |  | ry@gmail.com |  | [blank]  |  | ranggayudha123 |  | "//*[@id=\"register-form\"]/div[3]/div/div[2]/div/div/div"            |
      | rangga    |  | yudha    |  | ry@gmail.com |  | rangyuds |  | [blank]        |  | "//*[@id=\"register-form\"]/div[4]/div/div[2]/div/div/div"            |