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

    public String tellScore(Player player1, Player player2) {
        if (player1.getScore().getTrackPoints() >= 3 && player1.getScore().getTrackPoints() == player2.getScore().getTrackPoints())
            return "DEUCE!";
        else {
            return "Current Score: " + player1.getName() + ": " + player1.getScore().display() + " v.s. " +
                    player2.getName() + ": " + player2.getScore().display();
        }
    }

    public void establishScore(Player player1, Player player2, Player winner) {
        setAdvantage(player1, player2, winner);
        if (winner.equals(player1))
            grantPointTo(player1, player2);
        else
            grantPointTo(player2, player1);
        finalScore(player1, player2);
    }

    private void grantPointTo(Player winner, Player looser) {
        if (winner.getScore().getTrackPoints() < 3)
            winner.setScore(new Score(
                    winner.getScore().getTrackPoints() + 1,
                    PossiblePoints.get(winner.getScore().getTrackPoints() + 1),
                    winner.getScore().getNumberOfGameWon(),
                    false));
        else if (winner.getScore().getTrackPoints() == 3) {
            winner.setScore(new Score(
                    0,
                    0,
                    winner.getScore().getNumberOfGameWon() + 1,
                    false));
            looser.setScore(new Score(
                    0,
                    0,
                    looser.getScore().getNumberOfGameWon(),
                    false));
        } else if (winner.getScore().getTrackPoints() > 3)
            winner.setScore(new Score(
                    winner.getScore().getTrackPoints(),
                    winner.getScore().getCurrentGame() + 1,
                    winner.getScore().getNumberOfGameWon(),
                    winner.getScore().isAdvantage()));
    }

    // TODO: And God created brms...
    private void setAdvantage(Player player1, Player player2, Player winner) {
        if (player1.getScore().getTrackPoints() >= 3 && player1.getScore().getTrackPoints() == player2.getScore().getTrackPoints()) {
            if (winner.equals(player1))
                player1.getScore().setTrackPoints(player1.getScore().getTrackPoints() + 1).setAdvantage(true);
            else
                player2.getScore().setTrackPoints(player2.getScore().getTrackPoints() + 1).setAdvantage(true);
        } else if (player1.getScore().getTrackPoints() >= 3 && player2.getScore().getTrackPoints() >= 3 && player1.getScore().getTrackPoints() != player2.getScore().getTrackPoints()) {
            player1.getScore().setAdvantage(false);
            player2.getScore().setAdvantage(false);
            if (winner.equals(player1)) {
                if (player1.getScore().getTrackPoints() + 1 == player2.getScore().getTrackPoints())
                    player1.getScore().setTrackPoints(player1.getScore().getTrackPoints() + 1);
                else
                    // TODO: refactor - should be stateless
                    player1.getScore().setTrackPoints(3);
            } else {
                if (player2.getScore().getTrackPoints() + 1 == player1.getScore().getTrackPoints())
                    player2.getScore().setTrackPoints(player2.getScore().getTrackPoints() + 1);
                else
                    // TODO: refactor - should be stateless
                    player2.getScore().setTrackPoints(3);
            }
        }
    }

    protected void finalScore(Player player1, Player player2) {
        if (player1.getScore().getNumberOfGameWon() == 12 || player2.getScore().getNumberOfGameWon() == 12) {
            setWon = true;
        }
    }

    public String andTheWinnerIs(Player player1, Player player2) {
        if (player1.getScore().getNumberOfGameWon() > player2.getScore().getNumberOfGameWon())
            return "AND THE WINNER IS: " + player1.getName().toUpperCase() + "!!";
        else
            return "AND THE WINNER IS: " + player2.getName().toUpperCase() + "!!";
    }
}
