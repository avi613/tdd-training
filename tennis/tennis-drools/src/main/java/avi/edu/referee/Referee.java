package avi.edu.referee;

import avi.edu.player.Player;
import avi.edu.player.score.PossiblePoints;
import avi.edu.player.score.Score;

public class Referee {
    public void establishScore(Player winner, Player looser) {
        winner.setScore(new Score(
                winner.getScore().getTrackPoints() + 1,
                PossiblePoints.get(winner.getScore().getTrackPoints() + 1),
                winner.getScore().getNumberOfGamesWon(),
                false));
    }
}
