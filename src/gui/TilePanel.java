package gui;

import javax.swing.*;
import java.awt.*;

public class TilePanel extends JPanel {
    private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);

    public TilePanel() {
        setPreferredSize(TILE_PANEL_DIMENSION);
        setVisible(true);
    }
}