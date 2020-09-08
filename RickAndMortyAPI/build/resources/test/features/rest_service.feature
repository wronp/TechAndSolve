Feature: Searching characters through api
  As a user of the API Rest
  Need to find a specific character
  To have all the character information

  Scenario Outline: Search a character
    Given The user add the url of the end point
    When The user provide the name of the character to get all the data about him
    | id  | name    |  status   |  species   | gender   |
    | <id> | <name> | <status>  |  <species> | <gender> |
    Then The user verify that name character was in the get method
    Examples:
      | id | name         | status | species | gender |
      | 1  | Rick Sanchez | Alive  | Human   | Male   |
  