package Arrays.Assignment_02.Level_03;

import java.util.Scanner;

public class CardDeckDistributor {
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int n = suits.length * ranks.length;
        String[] deck = new String[n];

        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    public static String[][] distributeDeck(String[] deck, int players, int cardsPerPlayer) {
        if (players * cardsPerPlayer > deck.length) {
            System.out.println("Not enough cards to distribute!");
            return new String[0][0];
        }

        String[][] distributed = new String[players][cardsPerPlayer];
        int cardIndex = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                distributed[i][j] = deck[cardIndex++];
            }
        }
        return distributed;
    }

    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (int j = 0; j < players[i].length; j++) {
                System.out.print("[" + players[i][j] + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = scanner.nextInt();

        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);

        String[][] players = distributeDeck(deck, numPlayers, cardsPerPlayer);
        if (players.length > 0) {
            printPlayers(players);
        }
        scanner.close();
    }
}
