package domain;

public class DefaultMatch implements Match {

    private Player playerOne;
    private Player playerTwo;
    private Integer playerOneScore;
    private Integer playerTwoScore;

    private DefaultMatch(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
    }

    public static DefaultMatch of(Player playerOne, Player playerTwo) {
        return new DefaultMatch(playerOne, playerTwo);
    }

    @Override
    public Player getPlayerOne() {
        return playerOne;
    }

    @Override
    public Player getPlayerTwo() {
        return playerTwo;
    }

    @Override
    public Integer getPlayerOneScore() {
        return playerOneScore;
    }

    @Override
    public Integer getPlayerTwoScore() {
        return playerTwoScore;
    }

    @Override
    public void addOneWinBallToPlayerOne() {
        playerOneScore++;
    }

    @Override
    public void addOneWinBallToPlayerTwo() {
        playerTwoScore++;
    }

}
