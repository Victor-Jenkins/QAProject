
Feature: Check the HomePage

  Scenario: user can search XBOX

    Given an open browser with google.com
    When a keyword "xbox" is entered in input field
    Then at least top 1 matches should be shown
    Then the first one should contain "xbox.com"
    Then CLICK THE FIRST option
