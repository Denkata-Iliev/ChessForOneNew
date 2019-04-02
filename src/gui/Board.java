package gui;

import javax.swing.*;
import java.awt.*;

public class Board {
    private static final Dimension FRAME_DIMENSION = new Dimension(600,600);
    private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);
    private static final Color LIGHT_TILE_COLOR = Color.decode("#FFFACD");
    private static final Color DARK_TILE_COLOR = Color.decode("#593E1A");

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
            super(new GridLayout(8,8));
            addTileAndAssignTileColor();
            setPreferredSize(BOARD_PANEL_DIMENSION);
        }

        void addTileAndAssignTileColor() {
            TilePanel tilePanel;
            for (int row = 1; row <= BoardUtils.ROWS_NUMBER; row++) {
                for (int tileId = 1; tileId <= BoardUtils.ROW_LENGTH; tileId++) {
                    tilePanel = new TilePanel();
                    paintTile(row, tilePanel, tileId);
                    add(tilePanel);
                }
            }
        }

        private void paintTile(int row, TilePanel tilePanel, int tileId) {
            if (row % 2 != 0) {
                tilePanel.setBackground(tileId % 2 != 0 ? LIGHT_TILE_COLOR : DARK_TILE_COLOR);
            } else {
                tilePanel.setBackground(tileId % 2 != 0 ? DARK_TILE_COLOR : LIGHT_TILE_COLOR);
            }
        }
    }
}