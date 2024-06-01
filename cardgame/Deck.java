package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    public List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            cards.add(new Card(i));
        }
        for (int i = 1; i <= 13; i++) {
            cards.add(new Card(i));
        }
        for (int i = 1; i <= 13; i++) {
            cards.add(new Card(i));
        }
        for (int i = 1; i <= 13; i++) {
            cards.add(new Card(i));
        }
    }

    public void shuffleCards(List<Card> cards) {
        Collections.shuffle(cards);
    }
}
