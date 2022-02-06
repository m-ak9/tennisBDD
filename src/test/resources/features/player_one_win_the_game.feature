Feature: Player one win the game ?
  Player one should win the game !

  Scenario: Player one scores four balls in a row
    Given A new game begins
    When Player one scores four balls in a row
    Then I should be told "player one wins"

