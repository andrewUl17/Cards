package gpt;

import javax.swing.*;
import java.awt.*;

public class PlayingCard1 extends JPanel {
    private final String suit;
    private final String name;

    private JLabel nameLabel, suitLabel, suitLabel2;

    public PlayingCard1(String suit, String name) {
        this.suit = suit;
        this.name = name;
        setPreferredSize(new Dimension(100, 150));
        setLayout(new BorderLayout());

        // Top left suit label
        suitLabel = new JLabel(suit);
        suitLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        suitLabel.setHorizontalAlignment(JLabel.CENTER);

        // Center name label
        nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 50));
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        // Bottom right suit label
        suitLabel2 = new JLabel(suit);
        suitLabel2.setFont(new Font("Arial", Font.PLAIN, 20));
        suitLabel2.setHorizontalAlignment(JLabel.CENTER);

        defineRightColor(suit);
        add(suitLabel, BorderLayout.NORTH);
        add(nameLabel, BorderLayout.CENTER);
        add(suitLabel2, BorderLayout.SOUTH);
    }

    private void defineRightColor(String suit) {
        Color color = Color.BLACK;
        if (suit.equals("♦") || suit.equals("♥")) {
            color = Color.RED;
        }
        suitLabel.setForeground(color);
        suitLabel2.setForeground(color);
        nameLabel.setForeground(color);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Playing Card Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PlayingCard1 card = new PlayingCard1("♥", "A");
        frame.getContentPane().add(card);

        frame.pack();
        frame.setVisible(true);
    }
}
