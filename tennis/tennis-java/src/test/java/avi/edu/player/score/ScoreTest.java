package avi.edu.player.score;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ScoreTest {
    @Test
    @Parameters({
            "0, 0, 0,  Games won: 0, Current game: 0",
            "1, 15, 0, Games won: 0, Current game: 15",
            "2, 30, 0, Games won: 0, Current game: 30",
            "3, 40, 0, Games won: 0, Current game: 40",
            "0, 0, 1, Games won: 1, Current game: 0"
    })
    public void should_display_all_scores(int points, int current, int gamesWon, String wonDisplay, String currentDisplay) {
        Score score = new Score(points, current, gamesWon);
        assertThat(score.display()).isEqualTo(wonDisplay + ", " + currentDisplay);
    }
}
