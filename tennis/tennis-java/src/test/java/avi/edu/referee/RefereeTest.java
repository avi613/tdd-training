package avi.edu.referee;

import avi.edu.player.Player;
import avi.edu.player.score.Score;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RefereeTest {
    private Referee referee = new Referee();

    private Player player1 = new Player("player_1", new Score(0, 0));
    private Player player2 = new Player("player_2", new Score(0, 0));

    @Test
    @Parameters({
            "0, 0, 1, 0, 0, 0",
            "1, 0, 2, 0, 0, 0",
            "2, 0, 3, 0, 0, 0",
            "3, 0, 0, 1, 0, 0"
    })
    public void should_establish_score(int points, int gamesWon,
                                       int points1, int gamesWon1,
                                       int points2, int gamesWon2) {
        // given
        player1.setScore(new Score(points, gamesWon));

        // when
        referee.establishScore(player1, player2);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(points1, gamesWon1));
        assertThat(player2.getScore()).isEqualTo(new Score(points2, gamesWon2));
    }

    @Test
    @Parameters({
            "3, 0, 2, 0, 3, 0",
            "4, 0, 3, 0, 4, 0",
            "5, 0, 4, 0, 5, 0"
    })
    public void should_establish_deuce(int points1, int gamesWon1,
                                       int points2, int gamesWon2,
                                       int rPoint, int rGamesWon) {
        // given
        player1.setScore(new Score(points1, gamesWon1));
        player2.setScore(new Score(points2, gamesWon2));

        // when
        referee.establishScore(player2, player1);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(rPoint, rGamesWon));
        assertThat(player2.getScore()).isEqualTo(new Score(rPoint, rGamesWon));
    }

    @Test
    @Parameters({
            "3, 0, 4, 0",
            "4, 0, 5, 0"
    })
    public void should_establish_advantage(int points, int gamesWon,
                                           int points1, int gamesWon1) {
        // given
        player1.setScore(new Score(points, gamesWon));
        player2.setScore(new Score(points, gamesWon));

        // when
        referee.establishScore(player1, player2);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(points1, gamesWon1));
        assertThat(player2.getScore()).isEqualTo(new Score(points, gamesWon));
    }

    @Test
    public void should_grant_game_on_advantage() {
        // given
        player1.setScore(new Score(5, 0));
        player2.setScore(new Score(4, 0));

        // when
        referee.establishScore(player1, player2);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(0, 1));
        assertThat(player2.getScore()).isEqualTo(new Score(0, 0));
    }

    @Test
    @Parameters({
            // player 1 leads
            "0, 1, 0, 0",
            "0, 2, 0, 1",
            "0, 3, 0, 2",
            "0, 4, 0, 3",
            "0, 5, 0, 4",
            "0, 6, 0, 5",
            // tie but not break
            "0, 5, 0, 5",
            // player 2 leads
            "0, 0, 0, 1",
            "0, 1, 0, 2",
            "0, 2, 0, 3",
            "0, 3, 0, 4",
            "0, 4, 0, 5",
            "0, 5, 0, 6"
    })
    public void should_not_end_set(int points1, int gamesWon1,
                                   int points2, int gamesWon2) {
        // given
        player1.setScore(new Score(points1, gamesWon1));
        player2.setScore(new Score(points2, gamesWon2));

        // then
        assertThat(referee.finalScore(player1, player2)).isFalse();
    }

    @Test
    @Parameters({
            // player 1 wins
            "0, 6, 0, 0",
            "0, 6, 0, 1",
            "0, 6, 0, 2",
            "0, 6, 0, 3",
            "0, 6, 0, 4",
            "0, 7, 0, 5",
            // player 2 wins
            "0, 0, 0, 6",
            "0, 1, 0, 6",
            "0, 2, 0, 6",
            "0, 3, 0, 6",
            "0, 4, 0, 6",
            "0, 5, 0, 7"
    })
    public void should_end_set(int points1, int gamesWon1,
                               int points2, int gamesWon2) {
        // given
        player1.setScore(new Score(points1, gamesWon1));
        player2.setScore(new Score(points2, gamesWon2));

        // then
        assertThat(referee.finalScore(player1, player2)).isTrue();
    }

    @Test
    public void should_establish_tie_break() {
        // given
        player1.setScore(new Score(0, 6));
        player2.setScore(new Score(0, 6));

        // then
        assertThat(referee.finalScore(player1, player2)).isFalse();
    }
}
