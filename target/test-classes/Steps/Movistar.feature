Feature: Check the Movistar.com
  @Telefonica2


  Scenario: user can navigate and search results on Movistar.com

    Given an open browser with Movistar.com
    When Complete input with "Hola Carlos :)." and check cookies
    Then Complete input with " Como estas?"
    Then Check Title and click play video
    Then Check the navigation and add Zipcode "08223"
    Then Check previous Steps for contracting
    Then Check previous Steps for contracting1
    Then Finish Shopping "Sudo"

