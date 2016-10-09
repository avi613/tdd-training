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
    private Player player1 = new Player("player_1", new Score(0, 0, 0, false));
    private Player player2 = new Player("player_2", new Score(0, 0, 0, false));
    private Referee referee = new Referee();

    @Before
    public void setUp() {
        referee.startSet();
    }

    @Test
    @Parameters({
            "0, 0, 0, 1, 15, 0, 0, 0, 0",
            "1, 15, 0, 2, 30, 0, 0, 0, 0",
            "2, 30, 0, 3, 40, 0, 0, 0, 0",
            "3, 40, 0, 0, 0, 1, 0, 0, 0"
    })
    public void should_establish_score(int points, int current, int gamesWon,
                                       int points1, int current1, int gamesWon1,
                                       int points2, int current2, int gamesWon2) {
        // given
        player1.setScore(new Score(points, current, gamesWon, false));

        // when
        referee.establishScore(player1, player2);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(points1, current1, gamesWon1, false));
        assertThat(player2.getScore()).isEqualTo(new Score(points2, current2, gamesWon2, false));
    }

    @Test
    @Parameters({
            "3, 40, 0, 2, 30, 0, 3, 40, 0",
            "4, 44, 0, 3, 40, 0, 4, 44, 0",
            "5, 45, 0, 4, 44, 0, 5, 45, 0"
    })
    public void should_establish_deuce(int points1, int current1, int gamesWon1,
                                       int points2, int current2, int gamesWon2,
                                       int rPoint, int rCurrent, int rGamesWon) {
        // given
        player1.setScore(new Score(points1, current1, gamesWon1, false));
        player2.setScore(new Score(points2, current2, gamesWon2, false));

        // when
        referee.establishScore(player2, player1);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(rPoint, rCurrent, rGamesWon, false));
        assertThat(player2.getScore()).isEqualTo(new Score(rPoint, rCurrent, rGamesWon, false));

        assertThat(referee.tellScore(player1, player2)).isEqualTo("DEUCE!!");
    }

    @Test
    @Parameters({
            "3, 40, 0, 4, 44, 0",
            "4, 44, 0, 5, 45, 0"
    })
    public void should_establish_advantage(int points, int current, int gamesWon,
                                           int points1, int current1, int gamesWon1) {
        // given
        player1.setScore(new Score(points, current, gamesWon, false));
        player2.setScore(new Score(points, current, gamesWon, false));

        // when
        referee.establishScore(player1, player2);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(points1, current1, gamesWon1, true));
        assertThat(player2.getScore()).isEqualTo(new Score(points, current, gamesWon, false));
    }

    // TODO: add advantage telling test

    @Test
    public void should_grant_game_on_advantage() {
        // given
        player1.setScore(new Score(5, 45, 0, true));
        player2.setScore(new Score(4, 44, 0, false));

        // when
        referee.establishScore(player1, player2);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(0, 0, 1, false));
        assertThat(player2.getScore()).isEqualTo(new Score(0, 0, 0, false));
    }

    @Test
    public void should_tell_score() {
        // given
        player1.setScore(new Score(1, 15, 3, false));
        player2.setScore(new Score(0, 0, 4, false));

        // then
        assertThat(referee.tellScore(player1, player2))
                .isEqualTo("Current Score: player_1: Games won: 3, Current game: 15 v.s. player_2: Games won: 4, Current game: 0");
    }

    @Test
    @Parameters({
            // player 1 leads
            "0, 0, 1, 0, 0, 0",
            "0, 0, 2, 0, 0, 1",
            "0, 0, 3, 0, 0, 2",
            "0, 0, 4, 0, 0, 3",
            "0, 0, 5, 0, 0, 4",
            "0, 0, 6, 0, 0, 5",
            // tie but not break
            "0, 0, 5, 0, 0, 5",
            // player 2 leads
            "0, 0, 0, 0, 0, 1",
            "0, 0, 1, 0, 0, 2",
            "0, 0, 2, 0, 0, 3",
            "0, 0, 3, 0, 0, 4",
            "0, 0, 4, 0, 0, 5",
            "0, 0, 5, 0, 0, 6"
    })
    public void should_not_end_set(int points1, int current1, int gamesWon1,
                                   int points2, int current2, int gamesWon2) {
        // given
        player1.setScore(new Score(points1, current1, gamesWon1, false));
        player2.setScore(new Score(points2, current2, gamesWon2, false));

        // when
        referee.finalScore(player1, player2);

        // then
        assertThat(referee.isSetWon()).isFalse();
    }

    @Test
    @Parameters({
            // player 1 wins
            "0, 0, 6, 0, 0, 0",
            "0, 0, 6, 0, 0, 1",
            "0, 0, 6, 0, 0, 2",
            "0, 0, 6, 0, 0, 3",
            "0, 0, 6, 0, 0, 4",
            "0, 0, 7, 0, 0, 5",
            // player 2 wins
            "0, 0, 0, 0, 0, 6",
            "0, 0, 1, 0, 0, 6",
            "0, 0, 2, 0, 0, 6",
            "0, 0, 3, 0, 0, 6",
            "0, 0, 4, 0, 0, 6",
            "0, 0, 5, 0, 0, 7"
    })
    public void should_end_set(int points1, int current1, int gamesWon1,
                               int points2, int current2, int gamesWon2) {
        // given
        player1.setScore(new Score(points1, current1, gamesWon1, false));
        player2.setScore(new Score(points2, current2, gamesWon2, false));

        // when
        referee.finalScore(player1, player2);

        // then
        assertThat(referee.isSetWon()).isTrue();
    }

    @Test
    public void should_establish_tie_break() {
        // given
        player1.setScore(new Score(0, 0, 6, false));
        player2.setScore(new Score(0, 0, 6, false));

        // when
        referee.finalScore(player1, player2);

        // then
        assertThat(referee.isSetWon()).isFalse();
        assertThat(referee.tellScore(player1, player2))
                .isEqualTo("TIE BREAK!! player_1: Games won: 6, Current game: 0 v.s. player_2: Games won: 6, Current game: 0");

    }

    @Test
    public void should_declare_winner() {
        // given
        player1.setScore(new Score(0, 0, 4, false));
        player2.setScore(new Score(0, 0, 6, false));

        // then
        assertThat(referee.andTheWinnerIs(player1, player2)).isEqualTo("AND THE WINNER IS: PLAYER_2!!");
    }
}
