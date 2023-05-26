package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PlayingCard extends JPanel {
    private String suit;
    private String rank;
    private Color suitColor;
    private Font cornerLabelFont, rankFont;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 150;

    private JPanel topSuitPanel, bottomSuitPanel;
    private JLabel topSuitLabel, bottomSuitLabel, rankLabel;
    private JButton button;

    public PlayingCard(String suit, String rank, ActionListener actionListener) {
        this.suit = suit;
        this.rank = rank;
        cornerLabelFont = new Font("Arial", Font.PLAIN, 35);
        rankFont = new Font("Arial", Font.BOLD, 50);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // Top suit panel
        topSuitPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topSuitLabel = new JLabel(suit);
        topSuitLabel.setFont(cornerLabelFont);
        topSuitPanel.add(topSuitLabel);
        topSuitPanel.setBackground(Color.WHITE);

        // Center rank label (is used when the button gets disabled)
        rankLabel = new JLabel(rank);
        rankLabel.setFont(rankFont);
        rankLabel.setHorizontalAlignment(JLabel.CENTER);
        rankLabel.setVisible(true);
        //add(nameLabel, BorderLayout.CENTER);

        // implementing button, so the card is actually clickable
        button = new JButton();
        button.setPreferredSize(this.getPreferredSize());
        button.setOpaque(false);
        button.setContentAreaFilled(false); // makes the button invisible
        button.setBorderPainted(false);

        // Disable the button focus and highlight effects
        button.setFocusPainted(false);
        button.setFocusable(false);

        // implement card's rank on the button, because on the rankLabel it isn't visible
        button.setText(rank);
        button.setFont(rankFont);
        button.addActionListener(actionListener);

        // Bottom suit panel
        bottomSuitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomSuitLabel = new JLabel(suit);
        bottomSuitLabel.setFont(cornerLabelFont);
        bottomSuitPanel.add(bottomSuitLabel);
        bottomSuitPanel.setBackground(Color.WHITE);

        add(button);
        add(rankLabel, BorderLayout.CENTER);
        add(bottomSuitPanel, BorderLayout.SOUTH);
        add(topSuitPanel, BorderLayout.NORTH);
        defineRightColor(this.suit);
    }

    private void defineRightColor(String suit) {
        suitColor = Color.BLACK;
        if (suit.equals("♦") || suit.equals("♥")) {
            suitColor = Color.RED;
        }
        topSuitLabel.setForeground(suitColor);
        bottomSuitLabel.setForeground(suitColor);
        button.setForeground(suitColor);
        rankLabel.setForeground(suitColor);
    }

    public void enableButton(boolean bool) {
        button.setEnabled(bool);
        button.setVisible(bool);
        rankLabel.setVisible(!bool);
        repaint();
        revalidate();
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public void reset(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        button.setText(rank);
        defineRightColor(suit);
        topSuitLabel.setText(suit);
        bottomSuitLabel.setText(suit);
        topSuitLabel.setFont(cornerLabelFont);
        repaint();
        revalidate();
    }

    // during the game, when a card is being laid on another card, another card's rank should be still recognizable
    public void addRankToTopSuitLabel() {
        topSuitLabel.setText(suit + "     " + rank);
        topSuitLabel.setFont(new Font("Arial", Font.BOLD, 35));
    }

    /* public static void main(String[] args) {
        JFrame frame = new JFrame("Playing Card Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PlayingCard card = new PlayingCard("♥", "A");

        // Add a button over the card panel



// Add the button over the card panel
        card.add(button);

        frame.getContentPane().add(card);

        frame.pack();
        frame.setVisible(true);

        // Make the button clickable
        button.addActionListener(e -> {
            System.out.println("Card clicked");
        });
    }*/

}
