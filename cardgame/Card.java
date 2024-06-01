package cardgame;

public class Card {
    private final int value;

    public Card(int value) {
        this.value = value;
    }

    public int getValue() {
        if (value > 10) {
            return 10;
        } else {
            return value;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
