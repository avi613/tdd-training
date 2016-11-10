package avi.edu.tennis.player;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private Score score;

    public void winsPoint() {
        score = new Score(score.getCurrentGameScore() + 1, score.getNumberOfGamesWon());
    }

    public void winsGame() {
        score = new Score(0, score.getNumberOfGamesWon() + 1);
    }

    public void loosesGame() {
        score = new Score(0, score.getNumberOfGamesWon());
    }

    public int getCurrentGameScore() {
        return score.getCurrentGameScore();
    }

    public int getNumberOfGamesWon() {
        return score.getNumberOfGamesWon();
    }
}
