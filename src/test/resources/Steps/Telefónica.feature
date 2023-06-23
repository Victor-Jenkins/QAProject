Feature: Check the www.telefonica.com
@Telefonica

  Scenario: user can navigate and search results in responsive mobile mode on www.telefonica.com

    Given an open browser with www.telefonica.com
    When Check titles and accept cookies
    Then Check main navigation and select Services
    Then Check main navigation and select Particulars
    Then Check the Navigation and scrolling page
    Then Check the contact button
    Then Click on logo and navigate to stock
