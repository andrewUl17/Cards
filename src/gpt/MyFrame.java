package gpt;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private JPanel menuPanel;
    private JPanel programPanel;
    private JPanel switchPanel;
    private JButton switchButton;

    public MyFrame() {
        setTitle("My Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the menu panel
        menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBackground(Color.RED); // Set the background color to red
        menuPanel.add(new JLabel("Menu Screen"), BorderLayout.CENTER);

        // create the program panel
        programPanel = new JPanel(new BorderLayout());
        programPanel.setBackground(Color.GREEN); // Set the background color to green
        programPanel.add(new JLabel("Program Screen"), BorderLayout.CENTER);

        // create the switch panel as a placeholder for switching between the menu and program panels
        switchPanel = new JPanel(new BorderLayout());
        switchPanel.add(menuPanel, BorderLayout.CENTER);

        // create the switch button to toggle between the menu and program panels
        switchButton = new JButton("Switch Panels");
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (switchPanel.getComponent(0) == menuPanel) {
                    switchPanel.removeAll();
                    switchPanel.add(programPanel, BorderLayout.CENTER);
                } else {
                    switchPanel.removeAll();
                    switchPanel.add(menuPanel, BorderLayout.CENTER);
                }
                switchPanel.revalidate();
                switchPanel.repaint();
            }
        });

        // add the switch button to the content pane
        getContentPane().add(switchButton, BorderLayout.NORTH);

        // add the switch panel to the content pane
        getContentPane().add(switchPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}
