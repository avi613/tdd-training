package avi.edu.tennis.referee;

import avi.edu.tennis.assessor.Assessor;
import avi.edu.tennis.player.Player;
import avi.edu.tennis.player.Score;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class RefereeTest {
    private Voice voice = mock(Voice.class);
    private Assessor assessor = mock(Assessor.class);
    private Referee referee = new Referee(voice, assessor);

    private Player player1 = new Player("player1", new Score(0, 0));
    private Player player2 = new Player("player2", new Score(0, 0));

    @Test
    @Parameters({
            "1, 0, fifteen\\, love",
            "0, 1, love\\, fifteen",
            "1, 1, fifteen all"
    })
    public void should_state_score(int current1, int current2, String refereeStatement) {
        // given
        player1.setScore(new Score(current1, 0));
        player2.setScore(new Score(current2, 0));

        // when
        referee.stateScore(player1, player2);

        // then
        verify(voice, times(1)).say(refereeStatement);
    }

    @Test
    @Parameters({
            "5, 4, ADVANTAGE: player1",
            "4, 5, ADVANTAGE: player2"
    })
    public void should_state_advantage(int current1, int current2, String refereeStatement) {
        // given
        player1.setScore(new Score(current1, 0));
        player2.setScore(new Score(current2, 0));

        // when
        referee.stateScore(player1, player2);

        // then
        verify(voice, times(1)).say(refereeStatement);
    }

    @Test
    @Parameters({"3", "4", "5"})
    public void should_state_deuce(int current) {
        // given
        player1.setScore(new Score(current, 0));
        player2.setScore(new Score(current, 0));

        // when
        referee.stateScore(player1, player2);

        // then
        verify(voice, times(1)).say("DEUCE!");
    }

    @Test
    @Parameters({
            "1, 0, game player1",
            "0, 1, game player2"
    })
    public void should_state_game_on_game_won(int current1, int current2, String refereeStatement) {
        // given
        player1.setScore(new Score(current1, 0));
        player2.setScore(new Score(current2, 0));

        when(assessor.assessGameWon(player1, player2)).thenReturn(true);

        // when
        referee.stateScore(player1, player2);

        // then
        verify(voice, times(1)).say(refereeStatement);
    }

    @Test
    @Parameters({
            "4, 1, 2, 0",
            "2, 0, 4, 1",
            "6, 1, 4, 0",
            "4, 0, 6, 1"
    })
    public void should_reset_score_on_game_won(int current1, int games1, int current2, int games2) {
        // given
        player1.setScore(new Score(current1, 0));
        player2.setScore(new Score(current2, 0));

        when(assessor.assessGameWon(player1, player2)).thenReturn(true);

        // when
        referee.resetScoreOnGameWon(player1, player2);

        // then
        assertThat(player1.getNumberOfGamesWon()).isEqualTo(games1);
        assertThat(player2.getNumberOfGamesWon()).isEqualTo(games2);
    }

    @Test
    public void should_state_tie_break() {
        // given
        player1.setScore(new Score(0, anyInt()));
        player2.setScore(new Score(0, anyInt()));
        when(assessor.assessTieBreak(player1, player2)).thenReturn(true);

        // when
        referee.stateTieBreak(player1, player2);

        // then
        verify(voice, times(1)).say("TIE BREAK!");
    }

    @Test
    public void should_not_state_tie_break() {
        // given
        player1.setScore(new Score(3, anyInt()));
        player2.setScore(new Score(0, anyInt()));
        when(assessor.assessTieBreak(player1, player2)).thenReturn(true);

        // when
        referee.stateTieBreak(player1, player2);

        // then
        verify(voice, never()).say("TIE BREAK!");
    }

    @Test
    @Parameters({
            "1, 0, game\\, set player1",
            "0, 1, game\\, set player2"
    })
    public void should_state_game_set(int games1, int games2, String refereeStatement) {
        // given
        player1.setScore(new Score(0, games1));
        player2.setScore(new Score(0, games2));
        when(assessor.assessSetWon(player1, player2)).thenReturn(true);

        // when
        referee.stateScore(player1, player2);

        // then
        verify(voice, times(1)).say(refereeStatement);
    }
}
