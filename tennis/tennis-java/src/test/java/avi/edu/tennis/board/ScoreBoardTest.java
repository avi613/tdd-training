package avi.edu.tennis.board;

import avi.edu.tennis.player.Player;
import avi.edu.tennis.player.Score;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnitParamsRunner.class)
public class ScoreBoardTest {
    private Board board = mock(Board.class);
    private ScoreBoard scoreBoard = new ScoreBoard(board);

    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new Player("player1", new Score(0, 0));
        player2 = new Player("player2", new Score(0, 0));
    }

    @Test
    @Parameters({
            "0, 0, 0, 0",
            "1, 0, 15, 0",
            "1, 2, 15, 30",
            "3, 2, 40, 30",
            "5, 4, 40, 40"
    })
    public void should_display_current_score(int points1, int points2, int current1, int current2) {
        // given
        player1.setScore(new Score(points1, 0));
        player2.setScore(new Score(points2, 0));

        // when
        scoreBoard.displayScore(player1, player2);

        // then
        verify(board).display("Player | Game Won | Current Score");
        verify(board).display("player1 | 0 | " + current1);
        verify(board).display("player2 | 0 | " + current2);
    }
}
