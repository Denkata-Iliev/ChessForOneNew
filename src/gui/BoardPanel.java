package gui;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(500, 450);
    private Logic.Board chessBoard;
    private TilePanel tilePanel;

    BoardPanel() {
        super(new GridLayout(8, 8));
        addTileAndAssignTileColor();
        setPreferredSize(BOARD_PANEL_DIMENSION);
        this.chessBoard = tilePanel.getChessBoard();
        setVisible(true);
        validate();
    }

    private void addTileAndAssignTileColor() {
        TilePanel[][] tileMatrix = new TilePanel[Board.ROWS_NUMBER][Board.ROW_LENGTH];
        TilePanel tilePanel;
        for (int row = 0; row < Board.ROWS_NUMBER; row++) {
            for (int tileId = 0; tileId < Board.ROW_LENGTH; tileId++) {
                tilePanel = new TilePanel(row, tileId);
                add(tilePanel);
                tileMatrix[row][tileId] = tilePanel;
            }
        }
    }
}
