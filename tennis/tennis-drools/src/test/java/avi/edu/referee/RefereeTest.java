package avi.edu.referee;

import avi.edu.player.Player;
import avi.edu.player.score.Score;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RefereeTest {
    private Player player1 = new Player("player_1", new Score(0, 0, 0, false));
    private Player player2 = new Player("player_2", new Score(0, 0, 0, false));
    private Referee referee = new Referee();

    @Test
    @Parameters({
            "0, 0, 0, 1, 15, 0, 0, 0, 0"
    })
    public void should_establish_score_player_1_wins(int points, int current, int gamesWon,
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
}
