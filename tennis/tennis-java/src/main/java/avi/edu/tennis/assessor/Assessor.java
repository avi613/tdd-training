package avi.edu.tennis.assessor;

import avi.edu.tennis.player.Player;

public class Assessor {
    public boolean assessGameWon(Player player1, Player player2) {
        Player winner = player1.getCurrentGameScore() > player2.getCurrentGameScore() ? player1 : player2;
        Player looser = getLooser(winner, player1, player2);

        return ((winner.getCurrentGameScore() == 4 && looser.getCurrentGameScore() < 3)
                || (winner.getCurrentGameScore() > 3 && winner.getCurrentGameScore() - looser.getScore().getCurrentGameScore() == 2));
    }

    public boolean assessSetWon(Player player1, Player player2) {
        Player winner = player1.getNumberOfGamesWon() > player2.getNumberOfGamesWon() ? player1 : player2;
        Player looser = getLooser(winner, player1, player2);

        return ((winner.getNumberOfGamesWon() == 6 && looser.getNumberOfGamesWon() <= 4)
                || (winner.getNumberOfGamesWon() == 7 && looser.getNumberOfGamesWon() == 5)
                || (winner.getNumberOfGamesWon() == 7 && looser.getNumberOfGamesWon() == 6));
    }

    public boolean assessTieBreak(Player player1, Player player2) {
        return player1.getNumberOfGamesWon() == 6 && player2.getNumberOfGamesWon() == 6;
    }

    private Player getLooser(Player winner, Player player1, Player player2) {
        return winner.equals(player1) ? player2 : player1;
    }
}
