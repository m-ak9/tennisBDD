package cucumber.stepDefinitions;

import domain.DefaultMatch;
import domain.Match;
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

    public static Match getDefaultMatch() {
        return DefaultMatch.of(getPlayerOne(),getPlayerTwo());
    }

    public static Match getDeuceMatch() {
        Match match = DefaultMatch.of(getPlayerOne(),getPlayerTwo());

        for (int i = 0; i<3; i++){
            match.addOneWinBallToPlayerOne();
        }
        for (int i = 0; i<3; i++){
            match.addOneWinBallToPlayerTwo();
        }

        return match;
    }

}
