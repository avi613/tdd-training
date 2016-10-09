package avi.edu.referee;

import avi.edu.player.Player;
import avi.edu.player.score.PossiblePoints;
import avi.edu.player.score.Score;

public class Referee {
    private boolean setWon;

    public boolean isSetWon() {
        return setWon;
    }

    public void startSet() {
        setWon = false;
    }

    // TODO: move advantage telling here
    public String tellScore(Player player1, Player player2) {
        if (player1.getScore().getTrackPoints() >= 3 && player1.getScore().getTrackPoints() == player2.getScore().getTrackPoints())
            return "DEUCE!!";
        else if (player1.getScore().getNumberOfGamesWon() == 6 && player2.getScore().getNumberOfGamesWon() == 6)
            return "TIE BREAK!! " + player1.getName() + ": " + player1.getScore().display() + " v.s. " +
                    player2.getName() + ": " + player2.getScore().display();
        else {
            return "Current Score: " + player1.getName() + ": " + player1.getScore().display() + " v.s. " +
                    player2.getName() + ": " + player2.getScore().display();
        }
    }

    public void establishScore(Player winner, Player looser) {
        grantPoint(winner, looser);
        finalScore(winner, looser);
    }

    // TODO: And God created brms...
    private void grantPoint(Player winner, Player looser) {
        if (winner.getScore().getTrackPoints() < 3)
            // scores 15, 30 or 40
            winner.setScore(new Score(
                    winner.getScore().getTrackPoints() + 1,
                    PossiblePoints.get(winner.getScore().getTrackPoints() + 1),
                    winner.getScore().getNumberOfGamesWon(),
                    false));
        else if ((winner.getScore().getTrackPoints() == 3 && looser.getScore().getTrackPoints() < 3)
                || (winner.getScore().getTrackPoints() > 3 && looser.getScore().getTrackPoints() > 3 && winner.getScore().getTrackPoints() > looser.getScore().getTrackPoints())) {
            // game won
            winner.setScore(new Score(
                    0,
                    0,
                    winner.getScore().getNumberOfGamesWon() + 1,
                    false));
            looser.setScore(new Score(
                    0,
                    0,
                    looser.getScore().getNumberOfGamesWon(),
                    false));
        } else if (winner.getScore().getTrackPoints() >= 3 && winner.getScore().getTrackPoints() == looser.getScore().getTrackPoints())
            // advantage
            winner.setScore(new Score(
                    winner.getScore().getTrackPoints() + 1,
                    PossiblePoints.get(winner.getScore().getTrackPoints() + 1),
                    winner.getScore().getNumberOfGamesWon(),
                    true));
        else if (winner.getScore().getTrackPoints() >= 3 && looser.getScore().getTrackPoints() >= 3 && winner.getScore().getTrackPoints() + 1 == looser.getScore().getTrackPoints())
            // DEUCE
            winner.setScore(new Score(
                    winner.getScore().getTrackPoints() + 1,
                    PossiblePoints.get(winner.getScore().getTrackPoints() + 1),
                    winner.getScore().getNumberOfGamesWon(),
                    false
            ));
    }

    protected void finalScore(Player player1, Player player2) {
        if ((player1.getScore().getNumberOfGamesWon() == 6 && player2.getScore().getNumberOfGamesWon() <= 4)
                || (player1.getScore().getNumberOfGamesWon() <= 4 && player2.getScore().getNumberOfGamesWon() == 6))
            setWon = true;
        if ((player1.getScore().getNumberOfGamesWon() == 7 && player2.getScore().getNumberOfGamesWon() == 5)
                || (player1.getScore().getNumberOfGamesWon() == 5 && player2.getScore().getNumberOfGamesWon() == 7))
            setWon = true;
        if ((player1.getScore().getNumberOfGamesWon() == 7 && player2.getScore().getNumberOfGamesWon() == 6)
                || (player1.getScore().getNumberOfGamesWon() == 6 && player2.getScore().getNumberOfGamesWon() == 7))
            setWon = true;
    }

    public String andTheWinnerIs(Player player1, Player player2) {
        if (player1.getScore().getNumberOfGamesWon() > player2.getScore().getNumberOfGamesWon())
            return "AND THE WINNER IS: " + player1.getName().toUpperCase() + "!!";
        else
            return "AND THE WINNER IS: " + player2.getName().toUpperCase() + "!!";
    }
}