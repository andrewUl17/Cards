package logic;

import java.util.*;

public class FoolGame {

    //private Card[] deck36;
    //private Map<String, Integer> rankDict;
    //private Map<Integer, Character> suitDict;
    private Deck deck;
    private Stack<Card> discardPile, remainingDeck;
    private final char TRUMP_SUIT;
    private Card deckTrumpCard;
    private final int amountOfPlayers;
    private ArrayList<Player> players;
    private ArrayList<Integer> dispensedNames;

    public FoolGame(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
        //rankDict = new HashMap<>();
        //suitDict = new HashMap<>();
        //initializeMaps(); // separate method for the initialization
        //deck36 = new Card[36];
        //fillDeck36(deck36);
        //shuffleDeck(deck36);
        //printDesk(deck36);
        deck = new Deck(Deck._36);
        dispensedNames = new ArrayList();
        players = new ArrayList<>();
        for (int i = 0; i < amountOfPlayers; i++) {
            players.add(new Player(generateName()));
        }
        remainingDeck = new Stack<>(); // gets its all elements in the dealCardsMethod
        dealCards();
        deckTrumpCard = remainingDeck.pop(); // takes form the remainingDeck and turns it into trumpDeckCard
        TRUMP_SUIT = deckTrumpCard.getSuit(); // defines the trump suit

        discardPile = new Stack<>();

    }
    /*
    private void fillDeck36(Card[] deck36) {
        int rank;
        char suit;
        int i = 0;

        for (int s = 0; s < 4; s++) {
            suit = suitDict.get(s);

            for (int r = 6; r <= 14; r++) {
                rank = r;
                deck36[i] = new Card(rank, suit);
                i++;
            }
        }
    }

    private void shuffleDeck(Card[] deck) {
        List<Card> list = Arrays.asList(deck);
        Collections.shuffle(list);
        list.toArray(deck);
    }
    */

    // [for test]
    private void printDesk(Card[] desk) {
        for (Card card : desk) {
            System.out.println(card.toString());
        }
    }

    private String generateName() {
        String[] possibleNames = {"Jack", "Juan", "Ivan", "Victor", "Mario", "Roger"};
        int index = new Random().nextInt(0,6);
        if (dispensedNames.contains(index)) {
            generateName();
        }
        dispensedNames.add(index);
        return possibleNames[index];
    }

    // each player receives one card after another
    private void dealCards() {
        // initializes remainingDeck
        for (Card c : deck.get()) {
            remainingDeck.push(c);
        }

        for (int i = 0; i < 6; i++) {
            for (Player p : players) {
                p.receiveCard(remainingDeck.pop());
            }
        }
    }

    /*private void initializeMaps() {
        rankDict.put("J", 11);
        rankDict.put("Q", 12);
        rankDict.put("K", 13);
        rankDict.put("A", 14);

        suitDict.put(0,'♦');
        suitDict.put(1,'♠');
        suitDict.put(2,'♣');
        suitDict.put(3,'♥');
    } */

    private Player defineWhoTurnsFirst() {
        int lowestRank = 20;
        Player player = new Player("Undefined");
        int temp;
        for (Player p : players) {
            temp = p.findLowestRankedTrump(TRUMP_SUIT);
            if (temp < lowestRank) {
                lowestRank = temp;
                player = p;
            }
        }
        return player;
    }

}
