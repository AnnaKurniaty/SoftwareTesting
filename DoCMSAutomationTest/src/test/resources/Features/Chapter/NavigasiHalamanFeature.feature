#Author: Rangga Yudha Yudistira
#Date: 14 April 2023
#Description: Navigasi halaman feature

@ChapterNavigasiHalamanFeature
Feature: feature to test navigation page functionality

  @ValidScenario
  Scenario: Display next page with next button
    Given browser terbuka
    Given user berada di home page dengan username rangyuds dan password ranggayudha
    When membuka sidebar
    Then sidebar terbuka
    When klik tombol chapter
    And klik tombol next page
    Then sistem menampilkan halaman dua dari chapter
    
  @ValidScenario
  Scenario: Display previous page with previous button
    Given browser terbuka
    Given user berada di home page dengan username rangyuds dan password ranggayudha
    When membuka sidebar
    Then sidebar terbuka
    When klik tombol chapter
    And klik tombol next page
    Then sistem menampilkan halaman dua dari chapter
    When klik tombol previous page
    Then sistem menampilkan halaman satu dari chapter
    
  @ValidScenario
  Scenario: Display target page by clicking targeted number page
    Given browser terbuka
    Given user berada di home page dengan username rangyuds dan password ranggayudha
    When membuka sidebar
    Then sidebar terbuka
    When klik tombol chapter
    And klik tombol page 2
    Then sistem menampilkan halaman dua dari chapter
    
  @InvalidScenario
  Scenario: Check availability next button while on last page
    Given browser terbuka
    Given user berada di home page dengan username rangyuds dan password ranggayudha
    When membuka sidebar
    Then sidebar terbuka
    When klik tombol chapter
    And klik tombol page terakhir
    Then sistem menampilkan halaman terakhir dari chapter
    And tombol next page tidak dapat ditekan

	@InvalidScenario
  Scenario: Check availability previous button while on first page
    Given browser terbuka
    Given user berada di home page dengan username rangyuds dan password ranggayudha
    When membuka sidebar
    Then sidebar terbuka
    When klik tombol chapter
    Then tombol previous page tidak dapat ditekan