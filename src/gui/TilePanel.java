package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TilePanel extends JPanel {
    private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 50);
    private static final Color LIGHT_TILE_COLOR = Color.decode("#FFFACD");
    private static final Color DARK_TILE_COLOR = Color.decode("#593E1A");

    private int coordinateX;
    private int coordinateY;

    public TilePanel(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
        assignPieceIcon();
        paintTile(x, y);
        setPreferredSize(TILE_PANEL_DIMENSION);
        setVisible(true);
        validate();
    }

    private void paintTile(int row, int tileId) {
        if (row % 2 != 0) {
            this.setBackground(tileId % 2 != 0 ? LIGHT_TILE_COLOR : DARK_TILE_COLOR);
        } else {
            this.setBackground(tileId % 2 != 0 ? DARK_TILE_COLOR : LIGHT_TILE_COLOR);
        }
    }

    private void assignPieceIcon() {
        assignWhitePiecesIcons(coordinateX, coordinateY);
        assignBlackPiecesIcons(coordinateX, coordinateY);
    }

    private void assignBlackPiecesIcons(int row, int tileId) {
        if (row == 1) {
            try {
                BufferedImage image = ImageIO.read(new File("pieces/R" + row + "T" + tileId + ".gif"));
                add(new JLabel(new ImageIcon(image)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (row == 2) {
            try {
                BufferedImage image = ImageIO.read(new File("pieces/BP.gif"));
                add(new JLabel(new ImageIcon(image)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void assignWhitePiecesIcons(int row, int tileId) {
        if (row == 7) {
            try {
                BufferedImage image = ImageIO.read(new File("pieces/WP.gif"));
                add(new JLabel(new ImageIcon(image)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (row == 8) {
            try {
                BufferedImage image = ImageIO.read(new File("pieces/R" + row + "T" + tileId + ".gif"));
                add(new JLabel(new ImageIcon(image)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}