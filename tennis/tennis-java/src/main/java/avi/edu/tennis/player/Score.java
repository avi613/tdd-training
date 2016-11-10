package avi.edu.tennis.player;

import lombok.Value;

@Value
public class Score {
    private int currentGameScore;
    private int numberOfGamesWon;
}
