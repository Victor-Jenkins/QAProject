Feature: Check the HomePage


  Scenario: user can search Blizzard Games

    Given an open browser with google.com
    When a keyword "blizzard" is entered in input field
    Then at least top 1 matches should be shown
    Then the first one should contain "blizzard.com"
    Then CLICK THE FIRST option
    Then Swipe the different elements on slider
    Then check the titles and images