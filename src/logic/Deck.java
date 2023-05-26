package logic;

import com.sun.tools.javac.Main;


import java.util.*;

public class Deck {

    public static final int _36 = 36;
    public static final int _52 = 52;
    private int size;
    private Card[] deck;

    public Deck(int size) {
        this.size = size;
        deck = new Card[size];
        fill();
        shuffle();
    }

    public void fill() {
        int rank;
        char suit;
        int i = 0;
        int smallestRank;

        if (size == 36) {
            smallestRank = 6;
        }
        else {
            smallestRank = 2;
        }

        for (int s = 0; s < 4; s++) {
            suit = Module.getSuitAsChar(s);

            for (int r = smallestRank; r <= 14; r++) {
                rank = r;
                deck[i] = new Card(rank, suit);
                i++;
            }
        }
    }

    public void shuffle() {
        List<Card> list = Arrays.asList(deck);
        Collections.shuffle(list);
        list.toArray(deck);
    }

    public Card[] get() {
        return deck;
    }

    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card.toString());
        }
    }

}
