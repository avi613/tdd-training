package avi.edu.referee;

import avi.edu.player.Player;
import avi.edu.player.score.PossiblePoints;
import avi.edu.player.score.Score;

public class Referee {
    // TODO: move tie break telling outside of method
    public String tellScore(Player player1, Player player2) {
        if (player1.getScore().getTrackPoints() >= 3 && player1.getScore().getTrackPoints() == player2.getScore().getTrackPoints())
            return "DEUCE!!";
        else if (player1.getScore().getNumberOfGamesWon() == 6 && player2.getScore().getNumberOfGamesWon() == 6)
            return "TIE BREAK!! " + player1.getName() + ": " + player1.getScore().display() + " v.s. " +
                    player2.getName() + ": " + player2.getScore().display();
        else if (player1.getScore().getTrackPoints() >= 3 && player2.getScore().getTrackPoints() >= 3 && player1.getScore().getTrackPoints() > player2.getScore().getTrackPoints())
            return "ADVANTAGE: " + player1.getName().toUpperCase();
        else if (player1.getScore().getTrackPoints() >= 3 && player2.getScore().getTrackPoints() >= 3 && player2.getScore().getTrackPoints() > player1.getScore().getTrackPoints())
            return "ADVANTAGE: " + player2.getName().toUpperCase();
        else {
            return "Current Score: " + player1.getName() + ": " + player1.getScore().display() + " v.s. " +
                    player2.getName() + ": " + player2.getScore().display();
        }
    }

    public void establishScore(Player winner, Player looser) {
        grantPoint(winner, looser);
        finalScore(winner, looser);
    }

    // And God created brms...
    private void grantPoint(Player winner, Player looser) {
        if (winner.getScore().getTrackPoints() < 3)
            // scores 15, 30 or 40
            winner.setScore(new Score(
                    winner.getScore().getTrackPoints() + 1,
                    PossiblePoints.get(winner.getScore().getTrackPoints() + 1),
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
                    PossiblePoints.get(winner.getScore().getTrackPoints() + 1),
                    winner.getScore().getNumberOfGamesWon()));
        else if (winner.getScore().getTrackPoints() >= 3 && looser.getScore().getTrackPoints() >= 3 && winner.getScore().getTrackPoints() + 1 == looser.getScore().getTrackPoints())
            // DEUCE
            winner.setScore(new Score(
                    winner.getScore().getTrackPoints() + 1,
                    PossiblePoints.get(winner.getScore().getTrackPoints() + 1),
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

    public String andTheWinnerIs(Player player1, Player player2) {
        Player winner = player1.getScore().getNumberOfGamesWon() > player2.getScore().getNumberOfGamesWon() ? player1 : player2;
        return "AND THE WINNER IS: " + winner.getName().toUpperCase() + "!!";
    }
}
