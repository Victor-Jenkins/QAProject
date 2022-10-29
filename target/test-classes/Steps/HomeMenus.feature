Feature: Check the HomePage


  Scenario: user can search Accessories on XBOX Page

    Given an open browser with xbox.com
    When Navigate to Menu
    Then Click on accessories
    Then Close popup and check Title
    Then Check the first image
    Then looking "Series X "
    Then navigate to games and swipe element
    Then search the game "fallout"



