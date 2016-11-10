package avi.edu.tennis.referee;

import avi.edu.tennis.assessor.Assessor;
import avi.edu.tennis.player.Player;
import avi.edu.tennis.player.Score;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RefereeStepsDefinitions {
    private Voice voice = mock(Voice.class);
    private Assessor assessor = new Assessor();
    private Referee referee = new Referee(voice, assessor);

    private Player player1 = new Player("", new Score(0, 0));
    private Player player2 = new Player("", new Score(0, 0));

    @Given("^Players (.*) and (.*)$")
    public void initialize_players_names(String name1, String name2) {
        player1.setName(name1);
        player2.setName(name2);
    }

    @And("^Their score is (.*) and (.*)$")
    public void initialize_players_scores(int current1, int current2) {
        player1.setScore(new Score(current1, 0));
        player2.setScore(new Score(current2, 0));
    }

    @When("^(.*) scores$")
    public void player_scores(String name) {
        if (name.equals(player1.getName()))
            player1.winsPoint();
        else
            player2.winsPoint();
    }

    @Then("^Referee should state (.*)$")
    public void referee_should_state(String statement) {
        referee.stateScore(player1, player2);
        verify(voice).say(statement);
    }

    @When("^They both won 6 games$")
    public void both_players_won_six_games() {
        player1.setScore(new Score(0, 6));
        player2.setScore(new Score(0, 6));
    }

    @Then("^Referee should say TIE BREAK$")
    public void referee_should_state_tie_break() {
        referee.stateTieBreak(player1, player2);
        verify(voice).say("TIE BREAK!");
    }
}
