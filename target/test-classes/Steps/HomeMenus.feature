Feature: Check the HomePage


  Scenario: user can search XBOX

    Given open browser with xbox.com
    When Navigate to Menu1
    Then Click on accessories1
    Then Close popup and check Title1
    Then Check the first image1
    Then looking "fallout 76"
    Then navigate to games and swipe element
    Then search the name "fallout"
    Then search the game "Good Job"
    
