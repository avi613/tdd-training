package avi.edu.player.score;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
public class Score {
    private int trackPoints;
    private int currentGame;
    private int numberOfGamesWon;
    // TODO: remove
    private boolean isAdvantage;

    public String display() {
        return "Games won: " + numberOfGamesWon + ", Current game: " + (isAdvantage == false ? currentGame : "advantage!!");
    }
}
