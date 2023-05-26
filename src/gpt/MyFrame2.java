package gpt;

import gui.MenuPanel;

import javax.swing.*;
import java.awt.BorderLayout;

public class MyFrame2 extends JFrame {

    public MyFrame2() {
        setTitle("My Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the menu panel
        //JPanel menuPanel = new MenuPanel();

        // add the menu panel to the content pane
        //etContentPane().add(menuPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame2());
    }
}

