Feature: Account Creation
  As a user of the web page
  Need to create an account
  To receive the offers and discounts

Scenario Outline:
  Given The user is in the main page
  When The user create the account
    | Email          | firstName | lastName | password | address         | city     | state        | country       | postalCode | mobilePhone | alias     |
    | test17@TAS.com | Charlie   | Brown    | 123456   | AV siempre viva | Ambridge | Pennsylvania | United States | 15003      | 123456789   | Rocketman |
  Then The user can watch his <firstName> in the main bar
  Examples:
  | firstName     |
  | Charlie Brown |