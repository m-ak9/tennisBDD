package domain;

public enum Points {

    love(0),
    fifteen(1),
    thirty(2),
    forty(3),
    advantage(4);
    private final int value;


    private Points(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
