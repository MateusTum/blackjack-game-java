package cardgame;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Integer getTotalCardsValue() {
        int total = 0;
        for (Card card : cards) {
            total += card.value;
        }
        return total;
    }

}
