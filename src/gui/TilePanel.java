package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TilePanel extends JPanel {
    private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);
    private static final Color LIGHT_TILE_COLOR = Color.decode("#FFFACD");
    private static final Color DARK_TILE_COLOR = Color.decode("#593E1A");

    public TilePanel() {
        super(new GridBagLayout());
        setPreferredSize(TILE_PANEL_DIMENSION);
        setVisible(true);
    }

    public void paintTile(int row, int tileId) {
        if (row % 2 != 0) {
            this.setBackground(tileId % 2 != 0 ? LIGHT_TILE_COLOR : DARK_TILE_COLOR);
        } else {
            this.setBackground(tileId % 2 != 0 ? DARK_TILE_COLOR : LIGHT_TILE_COLOR);
        }
    }

    public void assignPieceIcon() {
        try {
            BufferedImage image = ImageIO.read(new File("pieces/" + "BB.gif"));
            add(new JLabel(new ImageIcon(image)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}