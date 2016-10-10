package avi.edu.referee;

import avi.edu.player.Player;

public class Speaker {
    public String tellScore(Player player1, Player player2) {
        String tieBreak = (player1.getScore().getNumberOfGamesWon() == 6 && player2.getScore().getNumberOfGamesWon() == 6) ? "TIE BREAK!! " : "";
        if (player1.getScore().getTrackPoints() >= 3 && player1.getScore().getTrackPoints() == player2.getScore().getTrackPoints())
            return tieBreak + "DEUCE!!";
        /*else if (player1.getScore().getNumberOfGamesWon() == 6 && player2.getScore().getNumberOfGamesWon() == 6)
            return "TIE BREAK!! " + player1.getName() + ": " + player1.getScore().display() + " v.s. " +
                    player2.getName() + ": " + player2.getScore().display();*/
        else if (player1.getScore().getTrackPoints() >= 3 && player2.getScore().getTrackPoints() >= 3 && player1.getScore().getTrackPoints() > player2.getScore().getTrackPoints())
            return tieBreak + "ADVANTAGE: " + player1.getName().toUpperCase();
        else if (player1.getScore().getTrackPoints() >= 3 && player2.getScore().getTrackPoints() >= 3 && player2.getScore().getTrackPoints() > player1.getScore().getTrackPoints())
            return tieBreak + "ADVANTAGE: " + player2.getName().toUpperCase();
        else {
            return tieBreak + "Current Score: " + player1.getName() + ": " + player1.getScore().display() + " v.s. " +
                    player2.getName() + ": " + player2.getScore().display();
        }
    }

    public String andTheWinnerIs(Player player1, Player player2) {
        Player winner = player1.getScore().getNumberOfGamesWon() > player2.getScore().getNumberOfGamesWon() ? player1 : player2;
        return "AND THE WINNER IS: " + winner.getName().toUpperCase() + "!!";
    }
}
