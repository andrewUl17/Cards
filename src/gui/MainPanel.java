package gui;

import logic.FoolGame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener, ChangeListener {

    private JPanel  gamePanel, menuPanel2, menuPanel3;
    private MenuPanel menuPanel;
    private int amountOfPlayers = 3;
    private FoolGame foolGame;

    public MainPanel() {
        setLayout(new BorderLayout());

        menuPanel = new MenuPanel(this,this);
        add(menuPanel);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == menuPanel.getFoolButton()) {
           removeAll(); // removes the menuPanel

           foolGame = new FoolGame(amountOfPlayers);
           gamePanel = new GamePanel(this);
           add(gamePanel);
           revalidate();
           repaint();
       }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        amountOfPlayers = menuPanel.slider.getValue();
    }
}
