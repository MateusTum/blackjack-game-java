package cardgame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Card> cards;
    private int totalCardsValue;

    public Player() {
        cards = new ArrayList<>();
        totalCardsValue = 0;
    }

    public void addCard(Card card) {
        cards.add(card);
        totalCardsValue += card.getValue();
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getTotalCardsValue() {
        return totalCardsValue;
    }
}
