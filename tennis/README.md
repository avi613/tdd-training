# Tennis Game Scoring Kata

This kata focuses on how tennis points are voiced by the referee and displayed on the scoring board.

If you want to have fun, don't hesitate to run TennisGame class that stages the kata.

## Rules

### Initial score
 - Each player start with an initial score equal to 0 point and 0 game won.

### Scoring sequence
 - When a player scores from 1 to 3 points, scores are counted as 0 => 15 => 30 => 40.
 - If a player's score is 40 and scores again, he wins the game, unless the other player's score is also 40 (see Deuce & Advantage section below).

### Deuce & Advantage
 - If both players score 40, we say there is **Deuce**.
 - From then, the player that scores has **Advantage**.
 - If the other player scores back, there is **Deuce** again, and so on.
 - If a player scores two points in a row he wins the game.

### End of Set
 - The first player to win 6 games wins the set, the other player having less than or equal to 4 games won.
 - If the number of games won by both players is 5/6 or 6/5, an extra game is played.
     - If the player having 6 games won wins the next game, he wins the set
     - If both players win 6 games each, there is **Tie Break**.
     - On **Tie Break**, a final game is played. The winner wins the set.

The possible final scores of a set are 6/>=4, >=4/6, 7/5, 5/7, 7/6 or 6/7.

### Referee's statements
 - We assume that player1 and player2 are known by everyone and never switch.
 - When a player scores, referee states the score of both players without saying their names.
 - When there is Deuce, the referee simply states "Deuce"
 - When a player has the advantage, the referee states "Advantage: " and the name of the player.
 - When a player wins a game, the referee states: "Game: " and the name of the winner.
 - When a player wins the set, the referee states: "Game and Set: " and the name of the winner.