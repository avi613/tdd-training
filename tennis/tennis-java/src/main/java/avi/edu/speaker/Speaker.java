package avi.edu.speaker;

import avi.edu.player.Player;
import avi.edu.player.score.Score;

public class Speaker {
    public String tellScore(Player player1, Player player2) {
        String tieBreak = (player1.getScore().getNumberOfGamesWon() == 6 && player2.getScore().getNumberOfGamesWon() == 6) ? "TIE BREAK!! " : "";
        if (player1.getScore().getTrackPoints() >= 3 && player1.getScore().getTrackPoints() == player2.getScore().getTrackPoints())
            return tieBreak + "DEUCE!!";
        else if (player1.getScore().getTrackPoints() >= 3 && player2.getScore().getTrackPoints() >= 3 && player1.getScore().getTrackPoints() > player2.getScore().getTrackPoints())
            return tieBreak + "ADVANTAGE: " + player1.getName().toUpperCase();
        else if (player1.getScore().getTrackPoints() >= 3 && player2.getScore().getTrackPoints() >= 3 && player2.getScore().getTrackPoints() > player1.getScore().getTrackPoints())
            return tieBreak + "ADVANTAGE: " + player2.getName().toUpperCase();
        else {
            return tieBreak + player1.getName() + ": " + sayScore(player1.getScore()) + " v.s. " +
                    player2.getName() + ": " + sayScore(player2.getScore());
        }
    }

    public String andTheWinnerIs(Player player1, Player player2) {
        Player winner = player1.getScore().getNumberOfGamesWon() > player2.getScore().getNumberOfGamesWon() ? player1 : player2;
        return "AND THE WINNER IS: " + winner.getName().toUpperCase() + "!!";
    }

    private String sayScore(Score score) {
        return "Games won: " + score.getNumberOfGamesWon() + " - Current game: " + score.getCurrentGame();
    }
}
