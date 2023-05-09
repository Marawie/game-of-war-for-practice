package game.java;

import java.util.*;

public class Deck {
    String[] ranks = {"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};
    int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    String[] suites = {"DIAMOND", "SPADE", "HEART", "CLUB"};

    List<Card> deck = new ArrayList<>();


    public String[] getRanks() {
        return ranks;
    }

    public int[] getValues() {
        return values;
    }

    public String[] getSuites() {
        return suites;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public Card draw() {
        Card card = deck.get(0);
        deck.remove(card);
        return card;
    }



    public void createDeck() {
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suites.length; j++) {
                int value = values[i];
                deck.add(new Card(ranks[i], suites[j], value));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck, new Random());
        System.out.println(deck);
    }


    @Override
    public String toString() {
        return " " + this.deck;
    }
}



