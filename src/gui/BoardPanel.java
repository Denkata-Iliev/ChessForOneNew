package gui;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(500, 450);
    private TilePanel tilePanel;

    BoardPanel() {
        super(new GridLayout(8, 8));
        addTileAndAssignTileColor();
        setPreferredSize(BOARD_PANEL_DIMENSION);
        setVisible(true);
        validate();
    }

    private void addTileAndAssignTileColor() {
        for (int row = 0; row < Board.ROWS_NUMBER; row++) {
            for (int tileId = 0; tileId < Board.ROW_LENGTH; tileId++) {
                tilePanel = new TilePanel(row, tileId);
                add(tilePanel);
            }
        }
    }
}
