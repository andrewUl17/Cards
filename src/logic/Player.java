package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private String name, statement;
    private ArrayList<Card> playersDeck;
    private boolean isOnTurn;

    public Player(String name) {
        this.name = name;
        playersDeck = new ArrayList<>();
    }

    public void receiveCard(Card card) {
        playersDeck.add(card);
    }

    public void playCard(Card card) {
        playersDeck.remove(card);
    }

    public int findLowestRankedTrump(char trumpSuit) {
        int lowestRank = 20;
        for (Card c : playersDeck) {
            if (c.getSuit() == trumpSuit && c.getRank() < lowestRank) {
                lowestRank = c.getRank();
            }
        }
        return lowestRank;
    }

}
