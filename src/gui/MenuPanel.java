package gui;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    public JSlider slider;
    private JLabel sliderTextLabel;
    private GameButton foolButton, button2, button3, button4, button5;

    public MenuPanel(ActionListener actionListener, ChangeListener changeListener) {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        // create the buttons
        foolButton = new GameButton("Fool");
        button2 = new GameButton("Deberc");
        button3 = new GameButton("Asshole");
        button4 = new GameButton("Black Jack");
        button5 = new GameButton("Poker");

        foolButton.addActionListener(actionListener);

        // Slider
        slider = new JSlider(2, 6, 3);
        slider.setPreferredSize(new Dimension(200,50));
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.addChangeListener(changeListener);
        //slider.setLocation(300,20);
        sliderTextLabel = new JLabel("Amount of players");
        sliderTextLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        sliderTextLabel.setForeground(Color.black);

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
        add(slider, gbc);
        add(sliderTextLabel, gbc);
    }

    public GameButton getFoolButton() {
        return foolButton;
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