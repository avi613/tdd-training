Feature: Referee's statements

  Scenario: Players score
    Given The following players
      | Name    |
      | Sarah   |
      | Bernard |
    When Players' score is
      | Points |
      | 0, 1   |
      | 1, 0   |
      | 1, 1   |
      | 0, 2   |
      | 2, 0   |
      | 1, 2   |
      | 2, 1   |
      | 2, 2   |
      | 0, 3   |
      | 3, 0   |
      | 1, 3   |
      | 3, 1   |
      | 2, 3   |
      | 3, 2   |
      | 3, 3   |
    Then Referee states
      | love, fifteen   |
      | fifteen, love   |
      | fifteen all     |
      | love, thirty    |
      | thirty, love    |
      | fifteen, thirty |
      | thirty, fifteen |
      | thirty all      |
      | love, forty     |
      | forty, love     |
      | fifteen, forty  |
      | forty, fifteen  |
      | thirty, forty   |
      | forty, thirty   |
      | Deuce           |

  Scenario Outline: Deuce & Advantage
    Given The player 1 is <player1> having <score1> and player 2 is <player2> having <score2>
    When <player> scores
    Then Referee states <statement>
    Examples:
      | player1 | player2 | score1 | score2 | player | statement        |
      | Sarah   | Bernard | 3      | 3      | Sarah  | Advantage: Sarah |

  Scenario Outline: Game is won
    Given The player 1 is <player1> having <score1> and player 2 is <player2> having <score2>
    When <player> scores
    Then Referee states <statement>
    Examples:
      | player1 | player2 | score1 | score2 | player | statement   |
      | Sarah   | Bernard | 3      | 2      | Sarah  | Game: Sarah |

  // TODO: the following feature is not good

  @wip
  Scenario Outline: Set is won
    Given The player 1 is <player1> having <score1> and player 2 is <player2> having <score2>
    When <player> scores
    Then Referee states <statement>
    Examples:
      | player1 | player2 | score1 | score2 | player | statement           |
      | Sarah   | Bernard | 3      | 2      | Sarah  | Game and Set: Sarah |