package avi.edu.referee;

import avi.edu.player.Player;
import avi.edu.player.score.Score;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;

// TODO: parametrize tests
public class RefereeTest {
    private Player player1;
    private Player player2;
    private Referee referee = new Referee();

    @Before
    public void setUp() {
        player1 = new Player("player_1", new Score(0, 0, 0, false));
        player2 = new Player("player_2", new Score(0, 0, 0, false));
    }

    @Test
    public void should_establish_score_to_fifteen_love_for_player_1() {
        // when
        referee.establishScore(player1, player2, player1);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(1, 15, 0, false));
        assertThat(player2.getScore()).isEqualTo(new Score(0, 0, 0, false));
        assertThat(player1.getScore().display()).isEqualTo("Sets: 0, Current game: 15");
        assertThat(player2.getScore().display()).isEqualTo("Sets: 0, Current game: 0");
    }

    @Test
    public void should_establish_score_to_thirty_love_for_player_1() {
        // given
        player1.setScore(new Score(1, 15, 0, false));

        // when
        referee.establishScore(player1, player2, player1);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(2, 30, 0, false));
        assertThat(player2.getScore()).isEqualTo(new Score(0, 0, 0, false));
        assertThat(player1.getScore().display()).isEqualTo("Sets: 0, Current game: 30");
        assertThat(player2.getScore().display()).isEqualTo("Sets: 0, Current game: 0");
    }

    @Test
    public void should_grant_one_game_to_player_1() {
        // given
        player1.setScore(new Score(3, 40, 0, false));

        // when
        referee.establishScore(player1, player2, player1);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(0, 0, 1, false));
        assertThat(player1.getScore().display()).isEqualTo("Sets: 1, Current game: 0");
    }

    @Test
    public void should_establish_score_for_second_set() {
        // given
        player1.setScore(new Score(1, anyInt(), 2, false));

        // when
        referee.establishScore(player1, player2, player1);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(2, 30, 2, false));
        assertThat(player1.getScore().display()).isEqualTo("Sets: 2, Current game: 30");
    }

    @Test
    public void should_grant_two_sets_to_player_2() {
        // given
        player1.setScore(new Score(2, 30, 1, false));
        player2.setScore(new Score(3, 40, 1, false));

        // when
        referee.establishScore(player1, player2, player2);

        // then
        assertThat(player2.getScore()).isEqualTo(new Score(0, 0, 2, false));
        assertThat(player1.getScore()).isEqualTo(new Score(0, 0, 1, false));
        assertThat(player2.getScore().display()).isEqualTo("Sets: 2, Current game: 0");
        assertThat(player1.getScore().display()).isEqualTo("Sets: 1, Current game: 0");
    }

    @Test
    public void should_grant_point_to_player_2() {
        // given
        player1.setScore(new Score(0, 0, 1, false));

        // when
        referee.establishScore(player1, player2, player2);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(0, 0, 1, false));
        assertThat(player2.getScore()).isEqualTo(new Score(1, 15, 0, false));
        assertThat(player1.getScore().display()).isEqualTo("Sets: 1, Current game: 0");
        assertThat(player2.getScore().display()).isEqualTo("Sets: 0, Current game: 15");
    }

    @Test
    public void should_establish_deuce() {
        // given
        player1.setScore(new Score(3, 40, 0, false));
        player2.setScore(new Score(2, anyInt(), 0, false));

        // when
        referee.establishScore(player1, player2, player2);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(3, 40, 0, false));
        assertThat(player2.getScore()).isEqualTo(new Score(3, 40, 0, false));
        assertThat(player1.getScore().display()).isEqualTo("Sets: 0, Current game: 40");
        assertThat(player2.getScore().display()).isEqualTo("Sets: 0, Current game: 40");
    }

    @Test
    public void should_establish_advantage_to_player_1() {
        // given
        player1.setScore(new Score(3, 40, 0, false));
        player2.setScore(new Score(3, 40, 0, false));

        // when
        referee.establishScore(player1, player2, player1);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(4, 41, 0, true));
        assertThat(player2.getScore()).isEqualTo(new Score(3, 40, 0, false));
        assertThat(player1.getScore().display()).isEqualTo("Sets: 0, Current game: advantage!!");
        assertThat(player2.getScore().display()).isEqualTo("Sets: 0, Current game: 40");
    }

    @Test
    public void should_establish_deuce_after_player_2_scored_back() {
        // given
        player1.setScore(new Score(4, 41, 0, true));
        player2.setScore(new Score(3, 40, 0, false));

        // when
        referee.establishScore(player1, player2, player2);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(4, 41, 0, false));
        assertThat(player2.getScore()).isEqualTo(new Score(4, 41, 0, false));
        assertThat(player1.getScore().display()).isEqualTo("Sets: 0, Current game: 41");
        assertThat(player2.getScore().display()).isEqualTo("Sets: 0, Current game: 41");
    }

    @Test
    public void player1_is_back_on_top_again() {
        // given
        player1.setScore(new Score(4, 41, 0, true));
        player2.setScore(new Score(4, 41, 0, false));

        // when
        referee.establishScore(player1, player2, player1);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(5, 42, 0, true));
        assertThat(player2.getScore()).isEqualTo(new Score(4, 41, 0, false));
        assertThat(player1.getScore().display()).isEqualTo("Sets: 0, Current game: advantage!!");
        assertThat(player2.getScore().display()).isEqualTo("Sets: 0, Current game: 41");
    }

    @Test
    public void player1_eventually_wins_the_game() {
        // given
        player1.setScore(new Score(5, 42, 0, true));
        player2.setScore(new Score(4, 41, 0, false));

        // when
        referee.establishScore(player1, player2, player1);

        // then
        assertThat(player1.getScore()).isEqualTo(new Score(0, 0, 1, false));
        assertThat(player2.getScore()).isEqualTo(new Score(0, 0, 0, false));
        assertThat(player1.getScore().display()).isEqualTo("Sets: 1, Current game: 0");
        assertThat(player2.getScore().display()).isEqualTo("Sets: 0, Current game: 0");
    }

    @Test
    public void should_tell_score() {
        // given
        player1.setScore(new Score(1, 15, 3, false));
        player2.setScore(new Score(0, 0, 4, false));

        // then
        assertThat(referee.tellScore(player1, player2)).isEqualTo("Current Score: player_1: Sets: 3, Current game: 15 v.s. player_2: Sets: 4, Current game: 0");
    }

    @Test
    public void should_tell_score_advantage_to_player_1() {
        // given
        player1.setScore(new Score(5, 42, 0, true));
        player2.setScore(new Score(4, 41, 0, false));

        // then
        assertThat(referee.tellScore(player1, player2)).isEqualTo("Current Score: player_1: Sets: 0, Current game: advantage!! v.s. player_2: Sets: 0, Current game: 41");
    }

    @Test
    public void should_tell_score_DEUCE() {
        // given
        player1.setScore(new Score(3, 40, 0, true));
        player2.setScore(new Score(3, 40, 0, false));

        // then
        assertThat(referee.tellScore(player1, player2)).isEqualTo("DEUCE!");

        // given
        player1.setScore(new Score(4, 41, 0, true));
        player2.setScore(new Score(4, 41, 0, false));

        // then
        assertThat(referee.tellScore(player1, player2)).isEqualTo("DEUCE!");
    }

    @Test
    public void should_not_end_set() {
        // given
        player1.setScore(new Score(0, 0, 4, false));
        player2.setScore(new Score(0, 0, 3, false));

        // when
        referee.finalScore(player1, player2);

        // then
        assertThat(referee.isSetWon()).isFalse();
    }

    @Test
    public void should_end_set() {
        // given
        player1.setScore(new Score(0, 0, 4, false));
        player2.setScore(new Score(0, 0, 12, false));

        // when
        referee.finalScore(player1, player2);

        // then
        assertThat(referee.isSetWon()).isTrue();
    }

    @Test
    public void should_declare_winner() {
        // given
        player1.setScore(new Score(0, 0, 4, false));
        player2.setScore(new Score(0, 0, 12, false));

        // then
        assertThat(referee.andTheWinnerIs(player1, player2)).isEqualTo("AND THE WINNER IS: PLAYER_2!!");
    }
}
