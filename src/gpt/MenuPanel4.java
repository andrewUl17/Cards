package gpt;

import javax.swing.*;
import java.awt.*;

public class MenuPanel4 extends JPanel {

    private JSlider slider;
    private JLabel sliderTextLabel;

    private JButton foolButton, button2, button3, button4, button5;

    public MenuPanel4() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
        sliderTextLabel.setForeground(Color.black);

        // create a panel for the slider and its label
        JPanel sliderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        sliderPanel.add(sliderTextLabel);
        sliderPanel.add(slider);

        // add the components to the panel
        add(foolButton);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(Box.createVerticalGlue()); // add some space between the buttons and the slider panel
        add(sliderPanel);
    }

    private class GameButton extends JButton{

        public GameButton(String text) {
            super(text);
            setPreferredSize(new Dimension(200,50));
            setForeground(Color.BLACK);
            setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 30));
        }
    }
}

