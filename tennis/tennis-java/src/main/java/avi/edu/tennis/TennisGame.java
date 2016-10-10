package avi.edu.tennis;

import avi.edu.player.Player;
import avi.edu.player.score.Score;
import avi.edu.referee.Referee;
import avi.edu.speaker.Speaker;

import java.util.Random;

public class TennisGame {
    public void play(Player player1, Player player2, Referee referee, Speaker speaker) {
        Random random = new Random();

        while (!referee.finalScore(player1, player2)) {
            int winPoint = random.nextInt(2);
            if (winPoint == 0)
                referee.establishScore(player1, player2);
            if (winPoint == 1)
                referee.establishScore(player2, player1);
            System.out.println(speaker.tellScore(player1, player2));
        }

        System.out.println(speaker.andTheWinnerIs(player1, player2));
    }

    public static void main(String[] args) {
        Player sarah = new Player("Sarah", new Score(0, 0, 0));
        Player bernard = new Player("Bernard", new Score(0, 0, 0));
        Referee george = new Referee();
        Speaker albert = new Speaker();
        TennisGame tennisGame = new TennisGame();

        tennisGame.play(sarah, bernard, george, albert);
    }
}
