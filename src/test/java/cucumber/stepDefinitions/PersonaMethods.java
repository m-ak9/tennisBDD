package cucumber.stepDefinitions;

import domain.Player;
import domain.PlayerBuilder;

public class PersonaMethods {
    public static Player getPlayerOne() {
        return PlayerBuilder.create().withName("player one").build();
    }

    public static Player getPlayerTwo() {
        return PlayerBuilder.create().withName("player two").build();
    }

    public static Player getNadal() {
        return PlayerBuilder.create().withName("Nadal").withScore(3).build();
    }

    public static Player getJohn() {
        return PlayerBuilder.create().withName("John").withScore(1).build();
    }
}
