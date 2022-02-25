package cucumber.stepDefinitions;

import application.TennisGame;
import domain.Player;
import domain.PlayerBuilder;
import domain.Points;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class GameRulesStepDefinitions {
    private TennisGame game;
    private Player player;
    private Player opponent;

//-------------------------------------
// ----------- TEST ------------------
//-------------------------------------

    @Given("test The player had {string}")
    public void test_the_player_had(String playerScore) {
        player = PlayerBuilder.create().withName("player").withScore(Points.valueOf(playerScore).getValue()).build();
    }
    @When("test The player scores a point")
    public void test_the_player_scores_a_point() {
        game = new TennisGame(player, opponent);
        game.playerOneWinBall();
    }
    @Then("test The player should have {string}")
    public void test_the_player_should_have(String afterScoring) {
        Assertions.assertEquals(Points.valueOf(afterScoring).getValue(), game.getPlayerOne().getScore());
    }


//-------------------------------------
// ----------- TEST ------------------
//-------------------------------------


    // ------------------------
    //          GIVEN
    // ------------------------

    @Given("The player had {string}")
    public void the_player_had(String playerScore) {
        player = PlayerBuilder.create().withName("player").withScore(Points.valueOf(playerScore).getValue()).build();
    }

    @Given("The opponent had {string}")
    public void the_opponent_had(String opponentScore) {
        opponent = PlayerBuilder.create().withName("opponent").withScore(Points.valueOf(opponentScore).getValue()).build();
    }

    @Given("Players are in deus")
    public void players_are_in_deus() {
        player = PlayerBuilder.create().withName("player").withScore(Points.forty.getValue()).build();
        opponent = PlayerBuilder.create().withName("opponent").withScore(Points.forty.getValue()).build();
    }
    // ------------------------
    //          WHEN
    // ------------------------


    @When("The player scores a point")
    public void the_player_scores_a_point() {
        game = new TennisGame(player, opponent);
        game.playerOneWinBall();

    }

    @When("The opponent scores a point")
    public void the_opponent_scores_a_point() {
        game = new TennisGame(player, opponent);
        game.playerTwoWinBall();
    }


    // ------------------------
    //          THEN
    // ------------------------

    @Then("The player should have {string}")
    public void the_player_should_have(String afterScoring) {
        Assertions.assertEquals(Points.valueOf(afterScoring).getValue(), game.getPlayerOne().getScore());
    }

    @Then("The players are {string}")
    public void the_players_are(String expectedString) {
        Assertions.assertEquals(expectedString, game.getScore());
    }

    @Then("The result should be {string}")
    public void the_player_should_have_his_game_score_increased_by(String excpectedString) {
        Assertions.assertEquals(excpectedString, game.getScore());
    }

    @Then("The player should get the {string}")
    public void the_player_should_get_the_advantage(String expectedString) {
        Assertions.assertEquals(expectedString, game.getScore());
    }
}
