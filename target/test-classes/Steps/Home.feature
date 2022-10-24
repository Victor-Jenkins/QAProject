Feature: Check the HomePage


  Scenario: user can search Shopery

    Given an open browser with google.com
    When a keyword "Shoperyy" is entered in input field
    Then at least top 1 matches should be shown
    Then the first one should contain "shopery.com"
    Then CLICK THE FIRST option
