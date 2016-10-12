package avi.edu.referee;

import avi.edu.player.Player;
import avi.edu.player.score.Score;

public class Referee {
    public void establishScore(Player winner, Player looser) {
        if (isGameWon(winner, looser)) {
            winner.setScore(new Score(
                    0,
                    winner.getScore().getNumberOfGamesWon() + 1));
            looser.setScore(new Score(
                    0,
                    looser.getScore().getNumberOfGamesWon()));
        }
        else
            winner.setScore(new Score(
                    winner.getScore().getTrackPoints() + 1,
                    winner.getScore().getNumberOfGamesWon()));
    }

    public boolean finalScore(Player player1, Player player2) {
        if ((player1.getScore().getNumberOfGamesWon() == 6 && player2.getScore().getNumberOfGamesWon() <= 4)
                || (player1.getScore().getNumberOfGamesWon() <= 4 && player2.getScore().getNumberOfGamesWon() == 6))
            return true;
        if ((player1.getScore().getNumberOfGamesWon() == 7 && player2.getScore().getNumberOfGamesWon() == 5)
                || (player1.getScore().getNumberOfGamesWon() == 5 && player2.getScore().getNumberOfGamesWon() == 7))
            return true;
        if ((player1.getScore().getNumberOfGamesWon() == 7 && player2.getScore().getNumberOfGamesWon() == 6)
                || (player1.getScore().getNumberOfGamesWon() == 6 && player2.getScore().getNumberOfGamesWon() == 7))
            return true;
        return false;
    }

    private boolean isGameWon(Player winner, Player looser) {
        return (winner.getScore().getTrackPoints() == 3 && looser.getScore().getTrackPoints() < 3)
                || (winner.getScore().getTrackPoints() > 3 && looser.getScore().getTrackPoints() >= 3 && winner.getScore().getTrackPoints() > looser.getScore().getTrackPoints());
    }
}
