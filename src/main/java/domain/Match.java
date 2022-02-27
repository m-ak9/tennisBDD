package domain;

public interface Match {

    Player getPlayerOne();
    Player getPlayerTwo();
    Integer getPlayerOneScore();
    Integer getPlayerTwoScore();
    void addOneWinBallToPlayerOne();
    void addOneWinBallToPlayerTwo();
}
