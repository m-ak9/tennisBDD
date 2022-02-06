package unitTests;

import application.TennisGame;
import domain.Player;
import domain.PlayerBuilder;
import io.cucumber.messages.types.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisGameTest extends TestCase {


    Player playerOne = PlayerBuilder.create().withName("Boris Becker").build();
    Player playerTwo = PlayerBuilder.create().withName("Bjørn Borg").build();

    TennisGame game = new TennisGame(playerOne, playerTwo);

    @Test
    public void testNewGameShouldReturnLoveAll()
    {
        String score = game.getScore();

        assertEquals("Love all", score);
    }

    @Test
    public void testPlayerOneWinsFirstBall()
    {
        game.playerOneWinBall();
        String score = game.getScore();

        assertEquals("Fifteen,Love", score);
    }

    @Test
    public void testFifteenAll(){
        game.playerOneWinBall();
        game.playerTwoWinBall();

        String score = game.getScore();
        assertEquals("Fifteen all", score);
    }

    @Test
    public void testPlayerTwoWinsFirstTwoBalls() {
        createScore(0, 2);

        String score = game.getScore();
        assertEquals("Love,Thirty", score);
    }

    @Test
    public void testPlayerOneWinsFirstThreeBalls(){
        createScore(3, 0);
        String score = game.getScore();
        assertEquals("Fourty,Love", score);
    }

    @Test
    public void testPlayersAreDeuce() {
        createScore(3, 3);

        String score = game.getScore();
        assertEquals("Deuce", score);
    }

    @Test
    public void testPlayerOneWinsGame()
    {
        createScore(4, 0);

        String score = game.getScore();
        assertEquals("Boris Becker wins", score);
    }

    @Test
    public void testPlayerTwoWinsGame(){
        createScore(1,4);

        String score = game.getScore();
        assertEquals("Bjørn Borg wins", score);
    }

    @Test
    public void testPlayersAreDuce4() {
        createScore(4, 4);
        String score = game.getScore();
        assertEquals("Deuce", score);
    }

    @Test
    public void testPlayerTwoAdvantage(){
        createScore(4, 5);

        String score = game.getScore();
        assertEquals("Advantage Bjørn Borg", score);
    }

    @Test
    public void testPlayerOneAdvantage(){
        createScore(5, 4);

        String score = game.getScore();
        assertEquals("Advantage Boris Becker", score);
    }

    @Test
    public void testPlayerTwoWins(){
        createScore(2, 4);
        String score = game.getScore();
        assertEquals("Bjørn Borg wins", score);
    }

    @Test
    public void testPlayerTwoWinsAfterAdvantage() {
        createScore(6, 8);
        String score = game.getScore();
        assertEquals("Bjørn Borg wins", score);
    }


    @Test
    public void testPlayerOneWinsAfterAdvantage() {
        createScore(8, 6);
        String score = game.getScore();
        assertEquals("Boris Becker wins", score);
    }

    @Test
    private void createScore(int playerOneBalls, int playerTwoBalls ) {
        for (int i = 0; i < playerOneBalls; i++) {
            game.playerOneWinBall();
        }
        for (int i = 0; i < playerTwoBalls; i++) {
            game.playerTwoWinBall();
        }
    }

}