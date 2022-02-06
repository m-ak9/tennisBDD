package unitTests;

import application.TennisGame;
import domain.Player;
import domain.PlayerBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisTest {
    private TennisGame game;

    @BeforeEach
    void setUp() {
        Player playerOne = PlayerBuilder.create().withName("jean").build();
        Player playerTwo = PlayerBuilder.create().withName("paul").build();

        game = new TennisGame(playerOne, playerTwo);
    }

    @Test
    public void Then_Score_Is_Love_All()
    {
        assertEquals("Love all", game.getScore());
    }


}