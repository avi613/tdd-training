Feature: Referee's statements
  As a Referee,
  In order to let audience follow the game
  I should be able to state the score

  Scenario: Referee states the score
    Given Players John and Coltrane
    And Their score is 0 and 0
    When John scores
    Then Referee should state fifteen, love

  Scenario Outline: Referee states the score
    Given Players <name1> and <name2>
    When Their score is <current1> and <current2>
    Then Referee should state <statement>
    Examples:
      | name1  | name2    | current1 | current2 | statement       |
      | John   | Coltrane | 0        | 1        | love, fifteen   |
      | Robert | Plant    | 1        | 1        | fifteen all     |
      | Mick   | Jagger   | 3        | 3        | DEUCE!          |
      | Kate   | Bush     | 4        | 3        | ADVANTAGE: Kate |
      | George | Clinton  | 3        | 5        | game Clinton    |

  Scenario: Referee states tie break
    Given Players David and Gilmour
    When They both won 6 games
    Then Referee should say TIE BREAK