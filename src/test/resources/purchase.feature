Feature: Purchase Flow on Demoblaze

  Background:
    Given User navigate to Demoblaze website to login
    When user click on Login button
    And user enter username "Salma2025"
    And user enter Password "4555555"
    And User click Login button

  @smoke
  Scenario: Verify that Two Products Are Purchased Successfully
    And user choose and open products page
    And user can choose first product
    And user can add first product to the cart
    And user can go back
    And user can Click Home
    And user can choose second product
    And user can add second product to the cart
    And user can open cart page
    Then user can check first product name "Sony vaio i5"
    Then user can check Second product name "Nexus 6"
    Then user can check Total "1440"
