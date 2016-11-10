package avi.edu.tennis.referee;

import avi.edu.tennis.player.Player;
import avi.edu.tennis.assessor.Assessor;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class Referee {
    private Voice voice;
    private Assessor assessor;

    private List<String> refereePoints = ImmutableList.of(
            "love", "fifteen", "thirty", "forty"
    );

    public Referee(Voice voice, Assessor assessor) {
        this.voice = voice;
        this.assessor = assessor;
    }

    public void stateScore(Player player1, Player player2) {
        voice.say(scoreStatement(player1, player2));
    }

    public void stateTieBreak(Player player1, Player player2) {
        if (assessor.assessTieBreak(player1, player2) && player1.getCurrentGameScore() == 0 && player2.getCurrentGameScore() == 0)
            voice.say("TIE BREAK!");
    }

    public void resetScoreOnGameWon(Player player1, Player player2) {
        if (assessor.assessGameWon(player1, player2)) {
            Player winner = (player1.getCurrentGameScore() > player2.getCurrentGameScore()) ? player1 : player2;
            Player looser = (winner.equals(player1) ? player2 : player1);
            winner.winsGame();
            looser.loosesGame();
        }
    }

    public boolean isSetWon(Player player1, Player player2) {
        return assessor.assessSetWon(player1, player2);
    }

    private String scoreStatement(Player player1, Player player2) {
        if (assessor.assessSetWon(player1, player2))
            return "game, set " + (player1.getNumberOfGamesWon() > player2.getNumberOfGamesWon() ? player1.getName() : player2.getName());

        if (player1.getCurrentGameScore() >= 3 && player1.getCurrentGameScore() == player2.getCurrentGameScore())
            return "DEUCE!";

        if (player1.getCurrentGameScore() == player2.getCurrentGameScore()) {
            return refereePoints.get(player1.getCurrentGameScore()) + " all";
        }

        if (assessor.assessGameWon(player1, player2))
            return "game " + (player1.getCurrentGameScore() > player2.getCurrentGameScore() ? player1.getName() : player2.getName());

        if (player1.getCurrentGameScore() >= 3 && player2.getCurrentGameScore() >= 3) {
            return "ADVANTAGE: " + (player1.getCurrentGameScore() > player2.getCurrentGameScore() ? player1.getName() : player2.getName());
        }

        return refereePoints.get(player1.getCurrentGameScore()) + ", " + refereePoints.get(player2.getCurrentGameScore());
    }
}
