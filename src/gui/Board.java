package gui;

import javax.swing.*;
import java.awt.*;

public class Board {
    private static final Dimension FRAME_DIMENSION = new Dimension(700, 700);
    static final int ROW_LENGTH = 8;
    static final int ROWS_NUMBER = 8;

    private JFrame gameFrame = new JFrame("Chess");
    private MenuBar menuBar = new MenuBar();

    public Board() {
        showFrame();
    }

    private void showFrame() {
        gameFrame.setSize(FRAME_DIMENSION);
        gameFrame.setJMenuBar(menuBar);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        drawBoard();
        gameFrame.setVisible(true);
    }

    private void drawBoard() {
        BoardPanel boardPanel = new BoardPanel();
        gameFrame.add(boardPanel);
    }
}