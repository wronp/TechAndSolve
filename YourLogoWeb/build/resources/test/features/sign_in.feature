Feature: Sign In into the account
  As a user of the web page
  Need to login into my account
  To receive the offers and discounts

  Scenario Outline:
    Given The user is in the main page
    When The user add his credentials
      | Email          | firstName | lastName | password |
      | test16@TAS.com | Charlie   | Brown    | 123456   |
    Then The user can watch his <firstName> in the main bar
    Examples:
      | firstName     |
      | Charlie Brown |