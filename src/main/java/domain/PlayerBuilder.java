package domain;

import java.util.Objects;

public class PlayerBuilder {
    private String  name = "unnamed";
    private Integer score = 0;

private PlayerBuilder(){}

    public static PlayerBuilder create() {
        return new PlayerBuilder();
    }

    public PlayerBuilder withName(String name) {
        PlayerBuilder builder = new PlayerBuilder();
        builder.name = Objects.requireNonNull(name);
        builder.score = score;
        return builder;
    }

    public PlayerBuilder withScore(Integer score) {
        PlayerBuilder builder = new PlayerBuilder();
        builder.name = name;
        builder.score = Objects.requireNonNull(score);
        return builder;
    }

    public Player build() {
        return DefaultPlayer.of(this.name, this.score);
    }
}
