package gui;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(500, 450);

    BoardPanel() {
        super(new GridLayout(8, 8));
        addTileToBoard();
        setPreferredSize(BOARD_PANEL_DIMENSION);
        setVisible(true);
        validate();
    }

    private void addTileToBoard() {
        for (int row = 0; row < Board.ROWS_NUMBER; row++) {
            for (int tileId = 0; tileId < Board.ROW_LENGTH; tileId++) {
                TilePanel tilePanel = new TilePanel(row, tileId);
                add(tilePanel);
            }
        }
    }
}
