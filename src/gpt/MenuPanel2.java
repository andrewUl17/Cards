package gpt;

import javax.swing.*;
import java.awt.*;

public class MenuPanel2 extends JPanel {

    private JSlider slider;
    private JLabel sliderTextLabel;

    private JButton foolButton, button2, button3, button4, button5;

    public MenuPanel2() {

        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        // create the buttons
        foolButton = new GameButton("Fool");
        button2 = new GameButton("Deberc");
        button3 = new GameButton("Asshole");
        button4 = new GameButton("Black Jack");
        button5 = new GameButton("Poker");

        // Slider
        slider = new JSlider(2, 6, 3);
        slider.setPreferredSize(new Dimension(200,50));
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        sliderTextLabel = new JLabel("Amount of players");
        sliderTextLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        sliderTextLabel.setForeground(Color.BLACK);

        // create a GridBagConstraints object to center the buttons
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // add the buttons to the panel
        add(foolButton, gbc);
        add(button2, gbc);
        add(button3, gbc);
        add(button4, gbc);
        add(button5, gbc);

        // add the slider and label to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(sliderTextLabel, gbc);
        gbc.gridy = 1;
        add(slider, gbc);
    }

    private class GameButton extends JButton{

        public GameButton(String text) {
            super(text);
            setPreferredSize(new Dimension(200,50));
            setForeground(Color.BLACK);
            setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 30));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Playing Card Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuPanel2 menuPanel2 = new MenuPanel2();
        frame.getContentPane().add(menuPanel2);

        frame.pack();
        frame.setVisible(true);
    }
}

