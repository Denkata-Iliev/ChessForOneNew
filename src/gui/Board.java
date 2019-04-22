package gui;

import javax.swing.*;
import java.awt.*;

public class Board {
    private static final Dimension FRAME_DIMENSION = new Dimension(700, 700);
    private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(500, 450);
    private static final int ROW_LENGTH = 8;
    private static final int ROWS_NUMBER = 8;

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

    private class BoardPanel extends JPanel {

        BoardPanel() {
            super(new GridLayout(8, 8));
            addTileAndAssignTileColor();
            setPreferredSize(BOARD_PANEL_DIMENSION);
            setVisible(true);
            validate();
        }

        private void addTileAndAssignTileColor() {
            TilePanel tilePanel;
            for (int row = 1; row <= ROWS_NUMBER; row++) {
                for (int tileId = 1; tileId <= ROW_LENGTH; tileId++) {
                    tilePanel = new TilePanel(row, tileId);
                    add(tilePanel);
                }
            }
        }
    }
}