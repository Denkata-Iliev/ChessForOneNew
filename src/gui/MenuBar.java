package gui;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        populateMenuBar(this);
        setVisible(true);
    }

    private void populateMenuBar(JMenuBar menuBar) {
        menuBar.add(gameMenu());
        menuBar.add(optionsMenu());
        menuBar.add(helpMenu());
    }

    private JMenu gameMenu() {
        JMenu gameMenu = new JMenu("Game");
        gameMenu.add(startNewGame());
        gameMenu.add(exitGame());
        return gameMenu;
    }

    private JMenuItem exitGame() {
        JMenuItem exitGameItem = new JMenuItem("Exit");
        exitGameItem.addActionListener(e -> System.exit(0));
        return exitGameItem;
    }

    private JMenuItem startNewGame() {
        JMenuItem startNewGame = new JMenuItem("Start New Game");
        startNewGame.addActionListener(e -> {
            //TODO
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
        String aboutMessage = "Създадено от:\nБожидар\nДенислав";
        aboutMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(null, aboutMessage, "About", JOptionPane.PLAIN_MESSAGE));
        return aboutMenuItem;
    }
}