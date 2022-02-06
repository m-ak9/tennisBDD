Feature: Player rules
  Player need to have correct name and score

  Scenario Outline: The name of the player should be correct
    Given The player name was <name>
    When John participate to a new game
    Then John should be named <name> in the game
    Examples:
      | name       |
      | "John"     |
      | "Pierre"   |
      | "Paul"     |
      | "Ahme"     |