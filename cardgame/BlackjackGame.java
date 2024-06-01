package cardgame;

import java.util.Scanner;

public class BlackjackGame {

    public Player player;
    public Player dealer;
    public Deck deck;

    public void play(Scanner reader) {
        player = new Player();
        dealer = new Player();
        deck = new Deck();
        deck.shuffleCards(deck.cards);
        boolean playing = true;

        player.addCard(deck.cards.remove(0));
        dealer.addCard(deck.cards.remove(0));
        player.addCard(deck.cards.remove(0));
        dealer.addCard(deck.cards.remove(0));

        while (playing) {
            System.out.println("Player's cards: " + player.getCards() + " You currently have a total value of " + player.getTotalCardsValue() + " points.");
            System.out.println("Dealer's cards: " + dealer.getCards().get(0) + " [hidden]");

            while (!isBusted(player.getTotalCardsValue()) && playing) {
                System.out.println("Would you like to hit or stand?");
                String choice = reader.next();
                if (choice.equalsIgnoreCase("hit")) {
                    player.addCard(deck.cards.remove(0));
                    System.out.println("Player's cards: " + player.getCards() + " You currently have a total value of " + player.getTotalCardsValue() + " points.");
                    if (player.getTotalCardsValue() == 21) {
                        System.out.println("Blackjack!");
                        break;
                    }
                } else {
                    playing = false;
                }
            }
            playing = false;
        }

        boolean calculatingResults = true;

        if (isBusted(player.getTotalCardsValue())) {
            System.out.println("Player is busted");
            System.out.println("Player's cards: " + player.getCards() + " with a total value of " + player.getTotalCardsValue() + " points.");
            calculatingResults = false;
        }

        while (calculatingResults) {
            System.out.println("Dealer's cards: " + dealer.getCards() + " Dealer's total value: " + dealer.getTotalCardsValue() + " points.");
            if (dealer.getTotalCardsValue() < 17) {
                dealer.addCard(deck.cards.remove(0));
                System.out.println("Dealer hits. Dealer's cards: " + dealer.getCards() + " Dealer's total value: " + dealer.getTotalCardsValue() + " points.");
            } else if (isBusted(dealer.getTotalCardsValue())) {
                System.out.println("Dealer is busted");
                System.out.println("Dealer's cards: " + dealer.getCards() + " with a total value of " + dealer.getTotalCardsValue() + " points.");
                break;
            } else {
                if (dealer.getTotalCardsValue() == player.getTotalCardsValue()) {
                    System.out.println("It's a tie");
                } else if (dealer.getTotalCardsValue() > player.getTotalCardsValue()) {
                    System.out.println("Dealer wins");
                } else {
                    System.out.println("Player wins");
                }
                System.out.println("Dealer's cards: " + dealer.getCards() + " with a total value of " + dealer.getTotalCardsValue() + " points.");
                System.out.println("Player's cards: " + player.getCards() + " with a total value of " + player.getTotalCardsValue() + " points.");
                break;
            }
        }
    }

    public static boolean isBusted(int playerScore) {
        return playerScore > 21;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");
        try (Scanner reader = new Scanner(System.in)) {
            System.out.println("Would you like to play a blackjack game? (yes/no)");
            String s = reader.next();

            if (s.equalsIgnoreCase("no")) {
                System.out.println("Goodbye!");
            } else {
                boolean playing = true;
                while (playing) {
                    BlackjackGame game = new BlackjackGame();
                    game.play(reader);
                    System.out.println("Would you like to play another blackjack game? (yes/no)");
                    String choice = reader.next();
                    if (choice.equalsIgnoreCase("no")) {
                        playing = false;
                        System.out.println("Goodbye!");
                    }
                }
            }
        }
    }
}
