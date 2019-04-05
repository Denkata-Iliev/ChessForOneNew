package gui;

import javax.swing.*;
import java.awt.*;

public class Board {
    private static final Dimension FRAME_DIMENSION = new Dimension(800, 800);
    private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);

    private JFrame gameFrame = new JFrame("Chess");
    private MenuBar menuBar = new MenuBar();

    public Board() {
        showFrame();
    }

    private void showFrame() {
        gameFrame.setSize(FRAME_DIMENSION);
        gameFrame.setJMenuBar(menuBar);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        drawBoard();
    }

    private void drawBoard() {
        BoardPanel boardPanel = new BoardPanel();
        gameFrame.add(boardPanel);
    }

    private class BoardPanel extends JPanel {

        BoardPanel() {
            super(new GridLayout(8, 8));
            setVisible(true);
            addTileAndAssignTileColor();
            setPreferredSize(BOARD_PANEL_DIMENSION);
        }

        private void addTileAndAssignTileColor() {
            TilePanel tilePanel;
            for (int row = 0; row < BoardUtils.ROWS_NUMBER; row++) {
                for (int tileId = 0; tileId < BoardUtils.ROW_LENGTH; tileId++) {
                    tilePanel = new TilePanel();
                    tilePanel.paintTile(row, tileId);
                    tilePanel.assignPieceIcon();
                    add(tilePanel);
                }
            }
        }
    }
}