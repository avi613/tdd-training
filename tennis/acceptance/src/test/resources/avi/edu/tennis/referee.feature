Feature: Referee's statements
  As a Referee,
  In order to let audience follow the game
  I should be able to state the score

  Scenario: Referee states the score
    Given Players John and Coltrane
    And Their scores being 0 and 0
    When John scores
    Then Referee should state fifteen, love