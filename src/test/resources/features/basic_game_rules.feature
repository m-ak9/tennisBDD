Feature: Game rules

  Scenario Outline: The player score a point in a game
    Given The player had <score>
    When The player scores a point
    Then The player should have <afterScoring>
    Examples:
      | score | afterScoring |
      | 0     | 1            |
      | 1     | 2            |
      | 2     | 3            |


  Scenario Outline: The player win a game only if he had 2 or more points than his oppoenent
    Given The player had 3
    And The opponent had <score>
    When The player scores a point
    Then The result should be "player wins"

    Examples:
      | score |
      | 0     |
      | 1     |
      | 2     |


  Scenario: The players are deuce
    Given The player had 2
    And The opponent had 3
    When The player scores a point
    Then The players are "Deuce"


  Scenario: The player get the advantage
    Given Players are in deus
    When The player scores a point
    Then The player should get the "Advantage player"


  Scenario: The player with the advantage win the point
    Given The player had 4
    And The opponent had 3
    When The player scores a point
    Then The result should be "player wins"


  Scenario: The player with the advantage doesn't win the point
    Given The player had 4
    And The opponent had 3
    When The opponent scores a point
    Then The players are "Deuce"