package cardgame;

public class Card {
    public String suit;
    public int value;
    
    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Card card = new Card("test", 6);
        System.out.println(card.suit + " " + card.value);
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }
}
