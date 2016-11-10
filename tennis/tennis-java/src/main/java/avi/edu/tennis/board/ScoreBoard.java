package avi.edu.tennis.board;

import avi.edu.tennis.player.Player;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class ScoreBoard {
    private Board board;

    private List<String> boardPoints = ImmutableList.of(
            "0", "15", "30", "40"
    );

    public ScoreBoard(Board board) {
        this.board = board;
    }

    public void displayScore(Player player1, Player player2) {
        board.display("Player | Game Won | Current Score");
        board.display(player1.getName() + " | " + player1.getNumberOfGamesWon() + " | " + getBoardPoints(player1));
        board.display(player2.getName() + " | " + player2.getNumberOfGamesWon() + " | " + getBoardPoints(player2));
    }

    private String getBoardPoints(Player player) {
        return player.getCurrentGameScore() <= 3 ? boardPoints.get(player.getCurrentGameScore()) : "40";
    }
}
