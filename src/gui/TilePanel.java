package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
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
        assignPieceIcon(x ,y);
        paintTile(x, y);
        setPreferredSize(TILE_PANEL_DIMENSION);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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

    private void assignPieceIcon(int row, int tileId) {
        String[][] nameMatrix = new String[8][8];
        switch (nameMatrix[row][tileId]) {
            case "White_Queen":
                putPieceIcon(nameMatrix[row][tileId]);
                break;
            case "Black_Rook":
                putPieceIcon(nameMatrix[row][tileId]);
                break;
            case "Black_Queen":
                putPieceIcon(nameMatrix[row][tileId]);
                break;
            case "Black_King":
                putPieceIcon(nameMatrix[row][tileId]);
                break;
            case "White_Bishop":
                putPieceIcon(nameMatrix[row][tileId]);
                break;
            case "White_Knight":
                putPieceIcon(nameMatrix[row][tileId]);
                break;
            case "White_Rook":
                putPieceIcon(nameMatrix[row][tileId]);
                break;
            case "White_Pawn":
                putPieceIcon(nameMatrix[row][tileId]);
            case "White_King":
                putPieceIcon(nameMatrix[row][tileId]);
                break;
            case "Black_Pawn":
                putPieceIcon(nameMatrix[row][tileId]);
                break;
            case "Black_Bishop":
                putPieceIcon(nameMatrix[row][tileId]);
                break;
            case "Black_Knight":
                putPieceIcon(nameMatrix[row][tileId]);
                break;
            default:
                System.out.println("Shouldn't come here!");
        }
    }

    private void putPieceIcon(String nameOfPiece) {
        try {
            BufferedImage pieceIcon = ImageIO.read(new File("pieces/" + nameOfPiece + ".gif"));
            add(new JLabel(new ImageIcon(pieceIcon)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}