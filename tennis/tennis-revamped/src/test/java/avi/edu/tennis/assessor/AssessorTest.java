package avi.edu.tennis.assessor;

import avi.edu.tennis.player.Player;
import avi.edu.tennis.player.Score;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AssessorTest {
    private Assessor assessor = new Assessor();
    private Player player1 = new Player("player_1", new Score(0, 0));
    private Player player2 = new Player("player_2", new Score(0, 0));

    @Test
    @Parameters({
            "0, 0",
            "1, 0",
            "2, 1",
            "2, 3"
    })
    public void should_assess_game_not_won(int current1, int current2) {
        // given
        player1 = new Player("player_1", new Score(current1, 0));
        player2 = new Player("player_2", new Score(current2, 0));

        // then
        assertThat(assessor.assessGameWon(player1, player2)).isFalse();
    }

    @Test
    @Parameters({
            "4, 2",
            "5, 3",
            "0, 4",
            "4, 6"
    })
    public void should_assess_game_won(int current1, int current2) {
        // given
        player1 = new Player("player_1", new Score(current1, 0));
        player2 = new Player("player_2", new Score(current2, 0));

        // then
        assertThat(assessor.assessGameWon(player1, player2)).isTrue();
    }

    @Test
    @Parameters({
            "0, 0",
            "1, 0",
            "1, 2"
    })
    public void should_assess_set_not_won(int games1, int games2) {
        // given
        player1 = new Player("player_1", new Score(0, games1));
        player2 = new Player("player_2", new Score(0, games2));

        // then
        assertThat(assessor.assessSetWon(player1, player2)).isFalse();
    }

    @Test
    @Parameters({
            "6, 3",
            "3, 6",
            "6, 4",
            "4, 6",
            "7, 5",
            "5, 7",
            "7, 6",
            "6, 7"
    })
    public void should_assess_set_won(int games1, int games2) {
        // given
        player1 = new Player("player_1", new Score(0, games1));
        player2 = new Player("player_2", new Score(0, games2));

        // then
        assertThat(assessor.assessSetWon(player1, player2)).isTrue();
    }

    @Test
    public void should_assess_tie_break() {
        // given
        player1 = new Player("player_1", new Score(0, 6));
        player2 = new Player("player_2", new Score(0, 6));

        // then
        assertThat(assessor.assessTieBreak(player1, player2)).isTrue();
    }
}
