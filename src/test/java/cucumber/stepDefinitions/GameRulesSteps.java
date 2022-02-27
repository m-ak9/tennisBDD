package cucumber.stepDefinitions;

import application.TennisGame;
import domain.Player;
import domain.PlayerBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class GameRulesSteps {
    private TennisGame game;
    private Player player;
    private Player opponent;

    // ------------------------
    //          GIVEN
    // ------------------------

    @Given("The player had {int}")
    public void the_player_had(Integer playerScore) {
        player = PlayerBuilder.create().withName("player").withScore(playerScore).build();
    }

    @Given("The opponent had {int}")
    public void the_opponent_had(Integer opponentScore) {
        opponent = PlayerBuilder.create().withName("opponent").withScore(opponentScore).build();
    }

    @Given("Players are in deus")
    public void players_are_in_deus() {
        player = PlayerBuilder.create().withName("player").withScore(3).build();
        opponent = PlayerBuilder.create().withName("opponent").withScore(3).build();
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

    @Then("The player should have {int}")
    public void the_player_should_have(Integer afterScoring) {
        Assertions.assertEquals(afterScoring, game.getMatch().getPlayerOneScore());
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
