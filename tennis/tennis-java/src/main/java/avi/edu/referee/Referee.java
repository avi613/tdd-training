package avi.edu.referee;

import avi.edu.player.Player;
import avi.edu.speaker.WeirdTennisPoints;
import avi.edu.player.score.Score;

public class Referee {
    // And God created brms...
    public void establishScore(Player winner, Player looser) {
        if (winner.getScore().getTrackPoints() < 3)
            // scores 15, 30 or 40
            winner.setScore(new Score(
                    winner.getScore().getTrackPoints() + 1,
                    WeirdTennisPoints.get(winner.getScore().getTrackPoints() + 1),
                    winner.getScore().getNumberOfGamesWon()));
        else if ((winner.getScore().getTrackPoints() == 3 && looser.getScore().getTrackPoints() < 3)
                || (winner.getScore().getTrackPoints() > 3 && looser.getScore().getTrackPoints() > 3 && winner.getScore().getTrackPoints() > looser.getScore().getTrackPoints())) {
            // game won
            winner.setScore(new Score(
                    0,
                    0,
                    winner.getScore().getNumberOfGamesWon() + 1));
            looser.setScore(new Score(
                    0,
                    0,
                    looser.getScore().getNumberOfGamesWon()));
        } else if (winner.getScore().getTrackPoints() >= 3 && winner.getScore().getTrackPoints() == looser.getScore().getTrackPoints())
            // advantage
            winner.setScore(new Score(
                    winner.getScore().getTrackPoints() + 1,
                    WeirdTennisPoints.get(winner.getScore().getTrackPoints() + 1),
                    winner.getScore().getNumberOfGamesWon()));
        else if (winner.getScore().getTrackPoints() >= 3 && looser.getScore().getTrackPoints() >= 3 && winner.getScore().getTrackPoints() + 1 == looser.getScore().getTrackPoints())
            // DEUCE
            winner.setScore(new Score(
                    winner.getScore().getTrackPoints() + 1,
                    WeirdTennisPoints.get(winner.getScore().getTrackPoints() + 1),
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
}
