package cucumber.stepDefinitions;

import application.TennisGame;
import domain.Player;
import domain.PlayerBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStepDefinitions {
    private TennisGame game;
    private Player     player;
    private Player     opponent;

    @Given("A new game begins")
    public void aNewGameBegins() {
        this.game = new TennisGame(PersonaMethods.getPlayerOne(), PersonaMethods.getPlayerTwo());
    }

    @When("Player one scores four balls in a row")
    public void playerOneScoresFourBallsInARow() {
        for (int i = 0; i < 4; i++) {
            game.playerOneWinBall();
        }
    }

    @Then("I should be told {string}")
    public void theWinnerShouldBePlayerOne(String expectedAnswer) {
        game.getScore();
        assertEquals(expectedAnswer, game.getScore());
    }

    @Given("The player name was {string}")
    public void thePlayerNameIs(String name) {
        player = PlayerBuilder.create().withName(name).build();
    }

    @When("John participate to a new game")
    public void johnParticipateToANewGame() {
        game = new TennisGame(player, PersonaMethods.getPlayerTwo());
    }

    @Then("John should be named {string} in the game")
    public void johnShouldBeNamedInTheGame(String expectedName) {
        assertEquals(expectedName, game.getPlayerOne().getName());
    }
}
