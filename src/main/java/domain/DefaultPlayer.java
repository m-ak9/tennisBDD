package domain;

public class DefaultPlayer implements Player {
    private final String  name;
    private       Integer score;

    public DefaultPlayer(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
    

    public static DefaultPlayer of(String name, Integer score) {
        return new DefaultPlayer(name, score);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getScore() {
        return this.score;
    }

    @Override
    public void addOneWinBall() {
        this.score++;
    }
}
