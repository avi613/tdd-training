package avi.edu.tennis;

import avi.edu.tennis.assessor.Assessor;
import avi.edu.tennis.board.Board;
import avi.edu.tennis.board.ScoreBoard;
import avi.edu.tennis.player.Player;
import avi.edu.tennis.player.Score;
import avi.edu.tennis.referee.Referee;
import avi.edu.tennis.referee.Voice;

import java.util.Random;

public class TennisGame {
    private Board board = new Board();
    private ScoreBoard scoreBoard = new ScoreBoard(board);

    public void play(Referee referee, Player player1, Player player2) {
        Random random = new Random();

        while (!referee.isSetWon(player1, player2)) {
            int wins = random.nextInt(2);
            if (wins == 0)
                player1.winsPoint();
            else
                player2.winsPoint();

            referee.stateScore(player1, player2);
            referee.resetScoreOnGameWon(player1, player2);
            referee.stateTieBreak(player1, player2);
            scoreBoard.displayScore(player1, player2);
        }
        referee.stateScore(player1, player2);
    }

    public static void main(String[] args) {
        Player sarah = new Player("Sarah", new Score(0, 0));
        Player bernard = new Player("Bernard", new Score(0, 0));

        Voice voice = new Voice();
        Assessor assessor = new Assessor();
        Referee george = new Referee(voice, assessor);

        TennisGame tennisGame = new TennisGame();

        tennisGame.play(george, sarah, bernard);
    }
}
