package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        setVisible(true);
        populateMenuBar(this);
    }

    private void populateMenuBar(JMenuBar menuBar) {
        menuBar.add(gameMenu());
        menuBar.add(optionsMenu());
        menuBar.add(helpMenu());
    }

    private JMenu gameMenu() {
        JMenu gameMenu = new JMenu("Game");
        gameMenu.add(startNewGame());
        return gameMenu;
    }

    private JMenuItem startNewGame() {
        JMenuItem startNewGame = new JMenuItem("Start New Game");
        startNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        return startNewGame;
    }

    private JMenu optionsMenu() {
        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.add(new JMenuItem("Select difficulty"));
        return optionsMenu;
        //TODO
    }

    private JMenu helpMenu() {
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(aboutMenuItem());
        return helpMenu;
    }

    private JMenuItem aboutMenuItem() {
        JMenuItem aboutMenuItem = new JMenuItem("About");
        String aboutMessage = "Създадено от Денислав и Божидар!";
        aboutMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(null, aboutMessage, "About", JOptionPane.PLAIN_MESSAGE));
        return aboutMenuItem;
    }
}