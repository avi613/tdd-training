package avi.edu.player.score;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Score {
    private int trackPoints;
    private int currentGame;
    private int numberOfGameWon;
    // TODO: refactor - should be stateless
    private boolean isAdvantage;

    public String display() {
        if (isAdvantage == false)
            return "Games won: " + numberOfGameWon + ", Current game: " + currentGame;
        else
            return "Games won: " + numberOfGameWon + ", Current game: advantage!!";
    }
}
