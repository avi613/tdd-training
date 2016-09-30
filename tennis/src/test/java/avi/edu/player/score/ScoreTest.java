package avi.edu.player.score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {
    @Test
    public void should_display_initial_score() {
        Score score = new Score(0, 0, 0, false);
        assertThat(score.display()).isEqualTo("Sets: 0, Current game: 0");
    }

    @Test
    public void should_display_advantage() {
        Score score = new Score(0, 0, 0, true);
        assertThat(score.display()).isEqualTo("Sets: 0, Current game: advantage!!");
    }
}
