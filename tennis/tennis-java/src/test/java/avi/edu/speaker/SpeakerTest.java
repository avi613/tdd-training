package avi.edu.speaker;

import avi.edu.player.Player;
import avi.edu.player.score.Score;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SpeakerTest {
    private Speaker speaker = new Speaker();

    private Player player1 = new Player("player_1", new Score(0, 0, 0));
    private Player player2 = new Player("player_2", new Score(0, 0, 0));

    @Test
    public void should_say_score() {
        // given
        player1.setScore(new Score(1, 15, 3));
        player2.setScore(new Score(0, 0, 4));

        // then
        assertThat(speaker.sayScore(player1, player2))
                .isEqualTo("player_1: Games won: 3 - Current game: 15 v.s. player_2: Games won: 4 - Current game: 0");
    }

    @Test
    @Parameters({
            "4, 44, 0, 3, 40, 0, player_1",
            "3, 40, 0, 4, 44, 0, player_2"
    })
    public void should_say_advantage(int points1, int current1, int gamesWon1,
                                      int points2, int current2, int gamesWon2,
                                      String advantageTo) {
        // given
        player1.setScore(new Score(points1, current1, gamesWon1));
        player2.setScore(new Score(points2, current2, gamesWon2));

        // then
        assertThat(speaker.sayScore(player1, player2)).isEqualTo("ADVANTAGE: " + advantageTo);
    }

    @Test
    @Parameters({
            "3, 40, 0",
            "4, 44, 0",
            "5, 45, 0"
    })
    public void should_say_deuce(int points, int current, int gamesWon) {
        // given
        player1.setScore(new Score(points, current, gamesWon));
        player2.setScore(new Score(points, current, gamesWon));

        // then
        assertThat(speaker.sayScore(player1, player2)).isEqualTo("DEUCE!!");
    }

    @Test
    @Parameters({
            "0, 0, 6, 0, 0, 6, TIE BREAK!! player_1: Games won: 6 - Current game: 0 v.s. player_2: Games won: 6 - Current game: 0",
            "3, 40, 6, 3, 40, 6, TIE BREAK!! DEUCE!!",
            "4, 44, 6, 3, 40, 6, TIE BREAK!! ADVANTAGE: player_1"
    })
    public void should_say_tie_break(int points1, int current1, int gamesWon1,
                                     int points2, int current2, int gamesWon2, String display) {
        // given
        player1.setScore(new Score(points1, current1, gamesWon1));
        player2.setScore(new Score(points2, current2, gamesWon2));

        // then
        assertThat(speaker.sayScore(player1, player2)).isEqualTo(display);
    }

    @Test
    public void should_declare_winner() {
        // given
        player1.setScore(new Score(0, 0, 4));
        player2.setScore(new Score(0, 0, 6));

        // then
        assertThat(speaker.andTheWinnerIs(player1, player2)).isEqualTo("AND THE WINNER IS: PLAYER_2!!");
    }
}
