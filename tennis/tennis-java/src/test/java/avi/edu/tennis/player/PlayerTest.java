package avi.edu.tennis.player;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    public void should_win_point() {
        // given
        Player player = new Player("", new Score(42, 0));

        // when
        player.winsPoint();

        // then
        assertThat(player.getCurrentGameScore()).isEqualTo(43);
        assertThat(player.getNumberOfGamesWon()).isEqualTo(0);
    }

    @Test
    public void should_win_game() {
        // given
        Player player = new Player("", new Score(42, 0));

        // when
        player.winsGame();

        // then
        assertThat(player.getNumberOfGamesWon()).isEqualTo(1);
        assertThat(player.getCurrentGameScore()).isEqualTo(0);
    }

    @Test
    public void should_loose_game() {
        // given
        Player player = new Player("", new Score(42, 0));

        // when
        player.loosesGame();

        // then
        assertThat(player.getNumberOfGamesWon()).isEqualTo(0);
        assertThat(player.getCurrentGameScore()).isEqualTo(0);
    }
}
