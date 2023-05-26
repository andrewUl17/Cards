package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private JPanel cardDesk, opponentsDesk, leftDesk, boardPanel, rightDesk;
    private ArrayList<PlayingCard> cardsArr;

    public GamePanel(ActionListener actionListener) {
        cardDesk = new JPanel();
        opponentsDesk = new JPanel();
        leftDesk = new LeftDesk(actionListener); // the card deck should lay on it & actionListener won't be needed is only to initialize th button
        boardPanel = new BoardPanel(actionListener); // cards should be laid here
        rightDesk = new RightDesk(actionListener); // discard pile and command buttons should be here
        cardsArr = new ArrayList<>();

        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        cardDesk.setBackground(new Color(187, 129, 65));
        cardDesk.setPreferredSize(new Dimension(100,150));
        cardDesk.setLayout(new FlowLayout());
        for (int i = 0; i < 10; i++) {
            cardsArr.add(new PlayingCard("♣", "Q", actionListener));
            cardDesk.add(cardsArr.get(i));
        }

        opponentsDesk.setBackground(new Color(0xBB8141));
        opponentsDesk.setPreferredSize(new Dimension(100, 150));
        opponentsDesk.setLayout(new FlowLayout());
        opponentsDesk.add(new Opponent("Jack"));
        opponentsDesk.add(new Opponent("Bruce"));
        opponentsDesk.add(new Opponent("Victor"));
        opponentsDesk.add(new Opponent("Ivan"));
        opponentsDesk.add(new Opponent("Juan"));
        opponentsDesk.add(new Opponent("Luigi"));

        add(cardDesk, BorderLayout.SOUTH);
        add(opponentsDesk, BorderLayout.NORTH);
        add(leftDesk, BorderLayout.WEST);
        add(boardPanel, BorderLayout.CENTER);
        add(rightDesk, BorderLayout.EAST);
    }

    private class Opponent extends JTextPane {

        private int amountOfCards;
        private String name, statement;

        public Opponent(String name) {
            this.name = name;
            amountOfCards = 6;
            statement = null;

            setText(name + "\nCards: " + amountOfCards + "\nSays:\n" + statement);
            setEditable(false);
            setPreferredSize(new Dimension(170, 140));
            setFont(new Font("Georgia", Font.BOLD, 25));
            setBackground(Color.WHITE);
        }

        public void onTurn(boolean bool) {
            if (bool) {
                setBackground(Color.PINK);
                return;
            }
            setBackground(Color.WHITE);
        }
    }

    private class CardHolder extends JLayeredPane {

        private PlayingCard firstCard, secondCard;

        public CardHolder(ActionListener actionListener) {
            firstCard = new PlayingCard("♦", "3", actionListener);
            secondCard = new PlayingCard("♠", "10", actionListener);

            setPreferredSize(new Dimension(PlayingCard.WIDTH + 25, PlayingCard.HEIGHT + 45));
            firstCard.setBounds(25,0, PlayingCard.WIDTH, PlayingCard.HEIGHT);
            secondCard.setBounds(0,45, PlayingCard.WIDTH, PlayingCard.HEIGHT);
            //firstCard.setVisible(false);
            //secondCard.setVisible(false);
            firstCard.addRankToTopSuitLabel(); // [for test]
            add(firstCard, Integer.valueOf(0));
            add(secondCard, Integer.valueOf(1));
        }

        public void putFirstCard(String suit, String rank) {
            this.firstCard.reset(suit, rank);
            this.firstCard.setVisible(true);
        }

        public void putFirstCard(PlayingCard firstCard) {
            putFirstCard(firstCard.getSuit(), firstCard.getRank());
        }

        public void putSecondCard(String suit, String rank) {
            this.secondCard.reset(suit, rank);
            this.secondCard.setVisible(true);
            firstCard.addRankToTopSuitLabel();
        }

        public void putSecondCard(PlayingCard secondCard) {
            putSecondCard(secondCard.getSuit(), secondCard.getRank());
        }
    }

    private class BoardPanel extends JPanel {
        //private CardHolder ch1, ch2, ch3, ch4, ch5, ch6;
        private ArrayList<CardHolder> cardHolders;
        private JPanel centerPanel; // is used for cardHolders to remain in the center

        public BoardPanel(ActionListener actionListener) {
            /*ch1 = new CardHolder(actionListener);
            ch2 = new CardHolder(actionListener);
            ch3 = new CardHolder(actionListener);
            ch4 = new CardHolder(actionListener);
            ch5 = new CardHolder(actionListener);
            ch6 = new CardHolder(actionListener);*/
            cardHolders = new ArrayList<>();
            centerPanel = new JPanel();
            setPreferredSize(new Dimension(300,300));
            setBackground(new Color(53, 101, 77));
            setLayout(new GridBagLayout());
            centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15,0));
            centerPanel.setOpaque(false);
            //makes centerPanel remain in the center
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;

            for (int i = 0; i < 6; i++) {
                cardHolders.add(new CardHolder(actionListener));
                centerPanel.add(cardHolders.get(i));
            }
            add(centerPanel, gbc);
        }

    }

    private class LeftDesk extends JPanel {

        private JLayeredPane deckContainer;
        private PlayingCard deckCardFaceUp;
        private JLabel deckFaceDown;

        public LeftDesk(ActionListener actionListener) {
            setBackground(new Color(0xEAD2AC));
            setPreferredSize(new Dimension(160, 160));
            setLayout(new GridBagLayout());

            // is needed to place the deckContainer in the center of the left desk
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;

            deckContainer = new JLayeredPane();
            deckContainer.setPreferredSize(new Dimension(PlayingCard.HEIGHT, PlayingCard.HEIGHT + 50));
            //deckContainer.setBackground(Color.BLACK); // is used to test the deckContainer
            //deckContainer.setOpaque(true); //*

            deckCardFaceUp = new PlayingCard("♥", "A", actionListener);
            deckCardFaceUp.enableButton(false);
            deckCardFaceUp.setBounds(0,0, PlayingCard.WIDTH, PlayingCard.HEIGHT);

            deckFaceDown = new JLabel();
            deckFaceDown.setBackground(Color.BLUE);
            deckFaceDown.setBounds(0,100,PlayingCard.HEIGHT, PlayingCard.WIDTH);
            deckFaceDown.setOpaque(true);

            deckContainer.add(deckFaceDown);
            deckContainer.add(deckCardFaceUp);
            add(deckContainer, gbc);

        }

    }

    private class RightDesk extends JPanel {

        private JPanel manualPanel, centerPanel, discardPile; // center panel is used to place the discardPile in the center
        private JButton abandonDefence;
        private JLabel turnSign;

        public RightDesk(ActionListener actionListener) {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;

            manualPanel = new JPanel();
            centerPanel = new JPanel();
            abandonDefence = new JButton();
            discardPile = new JPanel();
            turnSign = new JLabel();

            setBackground(new Color(0xEAD2AC));
            setPreferredSize(new Dimension(160, 160));
            setLayout(new BorderLayout());

            manualPanel.setPreferredSize(new Dimension(getWidth(), 150));
            manualPanel.setBackground(Color.LIGHT_GRAY);
            manualPanel.setLayout(new BorderLayout());

            turnSign.setText("Jack's Turn");
            turnSign.setOpaque(false);
            turnSign.setFont(new Font("Georgia", Font.BOLD, 20));
            turnSign.setHorizontalAlignment(JLabel.CENTER);

            abandonDefence.setPreferredSize(new Dimension(20,50));
            abandonDefence.setText("Abandon the defence");
            abandonDefence.addActionListener(actionListener);
            abandonDefence.setFont(new Font("Georgia", Font.BOLD, 11));

            centerPanel.setOpaque(false);
            centerPanel.setPreferredSize(new Dimension(100,100));
            centerPanel.setLayout(new GridBagLayout());

            discardPile.setPreferredSize(new Dimension(PlayingCard.WIDTH, PlayingCard.HEIGHT));
            discardPile.setBackground(Color.BLUE);

            centerPanel.add(discardPile, gbc);
            manualPanel.add(abandonDefence, BorderLayout.SOUTH);
            manualPanel.add(turnSign, BorderLayout.NORTH);
            add(centerPanel, BorderLayout.CENTER);
            add(manualPanel, BorderLayout.SOUTH);

        }
    }

}
