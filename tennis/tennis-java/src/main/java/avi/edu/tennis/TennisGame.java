package avi.edu.tennis;

import avi.edu.player.Player;
import avi.edu.player.score.Score;
import avi.edu.referee.Referee;

import java.util.Random;

public class TennisGame {
    public void play(Player player1, Player player2, Referee referee) {
        Random random = new Random();

        referee.startSet();

        while (referee.isSetWon() == false) {
            int winPoint = random.nextInt(2);
            if (winPoint == 0)
                referee.establishScore(player1, player2);
            else if (winPoint == 1)
                referee.establishScore(player2, player1);
            System.out.println(referee.tellScore(player1, player2));
        }

        System.out.println(referee.andTheWinnerIs(player1, player2));
    }

    public static void main(String[] args) {
        Player sarah = new Player("Sarah", new Score(0, 0, 0, false));
        Player bernard = new Player("Bernard", new Score(0, 0, 0, false));
        Referee george = new Referee();
        TennisGame tennisGame = new TennisGame();

        tennisGame.play(sarah, bernard, george);
    }
}
