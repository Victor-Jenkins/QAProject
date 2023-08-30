Feature: Check the HomePage


  Scenario: user can search Shopery

    Given open browser with google.com
    When the keyword "Shoperyy" is entered in input field
    Then at a least top 1 matches should be shown
    Then a first one should contain "shopery.com"
    Then CLICK1 THE FIRST option
