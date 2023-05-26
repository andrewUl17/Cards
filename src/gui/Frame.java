package gui;

import javax.swing.*;

public class Frame extends JFrame {

    private JPanel mainPanel;

    public Frame() {
        setTitle("Card Desk");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new MainPanel();

        getContentPane().add(mainPanel);

        // add your components to the panel here
        // e.g. panel.add(new JButton("Click me!"), BorderLayout.CENTER);

        setVisible(true);
    }
}