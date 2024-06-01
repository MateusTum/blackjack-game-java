package cardgame;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private final List<String> suits;
    private final List<Integer> values;
    public final ArrayList<Card> cards;

    public Deck() {
        suits = new ArrayList<>();
        suits.addAll(List.of("Hearts", "Diamonds", "Clubs", "Spades"));

        values = new ArrayList<>();
        values.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13));

        cards = new ArrayList<>();
        for (int i = 0; i < suits.size(); i++) {
            for (int j = 0; j < values.size(); j++) {
                cards.add(new Card(suits.get(i), values.get(j)));
            }
        }
    }

    public void shuffleCards(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            int randomIndex = (int) (Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, temp);
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffleCards(deck.cards);
        System.out.println(deck.cards);
    }

    @Override
    public String toString() {
        return "Deck{" + "cards=" + cards + '}';
    }
}
