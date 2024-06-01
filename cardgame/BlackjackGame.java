package cardgame;

import java.util.Scanner;

public class BlackjackGame {

    public Player player;
    public Player dealer;
    public Deck deck;

    public BlackjackGame() {
        player = new Player();
        dealer = new Player();
        deck = new Deck();
        deck.shuffleCards(deck.cards);
        Boolean playing = true;

        player.addCard(deck.cards.remove(0));
        dealer.addCard(deck.cards.remove(0));

        Scanner reader = new Scanner(System.in);

        System.out.println("Would you like to play a blackjack game? (yes/no)");
        String s = reader.next();
        if (s.equals("no")) {
            System.out.println("Goodbye!");
            reader.close();
            return;
        }
        while (playing) {
            System.out.println("Player's cards: " + player.getCards() + " " + "Yoooou currently have a total value of " + player.getTotalCardsValue() + " points.");
            System.out.println("Dealer's cards: " + dealer.getCards());
            while (!isBusted(player.getTotalCardsValue()) && playing) {
                System.out.println("Would you like to hit or stand?");
                String choice = reader.next();
                if (choice.equals("hit")) {
                    player.addCard(deck.cards.remove(0));
                    System.out.println("Player's cards: " + player.getCards() + " " + "You currently have a total value of " + player.getTotalCardsValue() + " points.");
                    if (player.getTotalCardsValue() == 21) {
                        System.out.println("Blackjack!");
                        break;
                    }
                } else {
                    playing = false;
                }
            }
            playing = false;
            reader.close();
        }

        Boolean calculatingResults = true;

        if (isBusted(player.getTotalCardsValue())) {
            System.out.println("Player is busted");
            System.out.println("Player's cards: " + player.getCards() + " " + "with a total value of " + player.getTotalCardsValue() + " points.");
            calculatingResults = false;
        }

        while (calculatingResults) {
            dealer.addCard(deck.cards.remove(0));
            if (isBusted(dealer.getTotalCardsValue())) {
                System.out.println("Dealer is busted");
                System.out.println("Dealer's cards: " + dealer.getCards() + " " + "with a total value of " + dealer.getTotalCardsValue() + " points.");
                break;
            }
            if (dealer.getTotalCardsValue() == 21 && player.getTotalCardsValue() == 21) {
                System.out.println("Its a tie");
                System.out.println("Dealer's cards: " + dealer.getCards() + " " + "with a total value of " + dealer.getTotalCardsValue() + " points.");
                System.out.println("Player's cards: " + player.getCards() + " " + "with a total value of " + player.getTotalCardsValue() + " points.");
                break;
            }
            if (dealer.getTotalCardsValue() > player.getTotalCardsValue()) {
                System.out.println("Dealer wins");
                System.out.println("Dealer's cards: " + dealer.getCards() + " " + "with a total value of " + dealer.getTotalCardsValue() + " points.");
                break;
            }
        }
    }

    public static Boolean isBusted(Integer playerScore) {
        return playerScore > 21;
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
    }

}
