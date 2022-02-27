package application;

import domain.Match;
import domain.Player;

public class TennisGame {

    private Match match;

    public TennisGame(Match match) {
        this.match = match;
    }

    public String getScore() {
        if (hasAWinner()) {
            return encodeWinnerScore();
        }
        if (isEqualScore()) {
            return encodeEqualScore();
        }
        if (hasAdvantage()) {
            return encodeAdvantageScore();
        }
        return encodeSimpleScores();
    }

    private boolean hasAWinner() {
        return playerOneWon() || playerTwoWon();
    }

    private boolean playerOneWon() {
        return playerOneAtLeastFourWins() && playerOneAheadWithTwoWins();
    }

    private boolean playerOneAtLeastThreeWins() {
        return playerOne.getScore() > 2;
    }


    private boolean playerOneAtLeastFourWins() {
        return playerOne.getScore() > 3;
    }

    private boolean playerOneAheadWithTwoWins() {
        return playerOne.getScore() - playerTwo.getScore() >= 2;
    }

    private boolean playerTwoWon() {
        return playerTwoAtLeastFourWins() && playerTwoAheadWithTwoWins();
    }

    private boolean playerTwoAtLeastThreeWins() {
        return playerTwo.getScore() > 2;
    }

    private boolean playerTwoAtLeastFourWins() {
        return playerTwo.getScore() > 3;
    }

    private boolean playerTwoAheadWithTwoWins() {
        return playerTwo.getScore() - playerOne.getScore() >= 2;
    }

    private String encodeWinnerScore() {
        return playerOneWon() ? playerOne.getName() + " wins" : playerTwo.getName() + " wins";
    }

    private boolean isEqualScore() {
        return playerOne.getScore() == playerTwo.getScore();
    }

    private String encodeEqualScore() {
        if (isDeuce()) {
            return "Deuce";
        }
        return encodeSimpleScore1() + " all";
    }

    private boolean isDeuce() {
        return playerOneAtLeastThreeWins() && playerTwoAtLeastThreeWins() && haveEqualWins();
    }

    private boolean hasAdvantage() {
        return playerOneHasAdvantage() || PlayerTwoHasAdvantage();
    }

    private boolean playerOneHasAdvantage() {
        return playerOneAtLeastFourWins() && !haveEqualWins();
    }

    private boolean PlayerTwoHasAdvantage() {
        return playerTwoAtLeastFourWins() && !haveEqualWins();
    }

    private boolean haveEqualWins() {
        return playerOne.getScore() == playerTwo.getScore();
    }

    private String encodeAdvantageScore() {
        if (playerOne.getScore() > playerTwo.getScore()) {
            return "Advantage " + playerOne.getName();
        }
        return "Advantage " + playerTwo.getName();
    }

    private String encodeSimpleScores() {
        return encodeSimpleScore1() + "," + encodeSimpleScore2();
    }

    private String encodeSimpleScore1() {
        return getSimpleScore(playerOne.getScore());
    }

    private String encodeSimpleScore2() {
        return getSimpleScore(playerTwo.getScore());
    }

    private static String getSimpleScore(int wins) {
        switch (wins) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Fourty";
            default:
                return "Love";
        }
    }

    public void playerOneWinBall() {
        match.addOneWinBallToPlayerOne();
    }

    public void playerTwoWinBall() {
        match.addOneWinBallToPlayerTwo();
    }

    public Match getMatch() {
        return match;
    }
}