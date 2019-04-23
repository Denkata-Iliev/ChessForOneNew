package gui;

import Logic.Board;
import Logic.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

public class TilePanel extends JPanel {
    private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 50);
    private static final Color LIGHT_TILE_COLOR = Color.decode("#FFFACD");
    private static final Color DARK_TILE_COLOR = Color.decode("#593E1A");
    public static final Color HIGHLIGHTED_TILE = Color.decode("#0000FF");

    private int coordinateX;
    private int coordinateY;
    private Board chessBoard;

    public TilePanel(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
        chessBoard = new Board();
        assignPieceIcon(x, y, chessBoard);
        paintTile(x, y);
        setPreferredSize(TILE_PANEL_DIMENSION);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isRightMouseButton(e)) {
                    unSelectTile();
                }
                if (isLeftMouseButton(e)) {
                    Piece[][] piecesMatrix = chessBoard.getBoardPieceMatrix();
                    if (piecesMatrix[x][y] != null) {
                        highlightSelectedTile();
                        validate();
                    }
                }
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

    public Board getChessBoard() {
        return chessBoard;
    }

    private void highlightSelectedTile() {
        this.setBorder(BorderFactory.createLineBorder(HIGHLIGHTED_TILE, 4));
    }

    private void unSelectTile() {
        this.setBorder(null);
    }

    private void paintTile(int row, int tileId) {
        if (row % 2 != 0) {
            this.setBackground(tileId % 2 != 0 ? LIGHT_TILE_COLOR : DARK_TILE_COLOR);
        } else {
            this.setBackground(tileId % 2 != 0 ? DARK_TILE_COLOR : LIGHT_TILE_COLOR);
        }
    }

    private void assignPieceIcon(int row, int tileId, Board chessBoard) {
        String[][] nameMatrix = chessBoard.getBoardStringMatrix();
        if (nameMatrix[row][tileId] != null) {
            putPieceIcon(nameMatrix[row][tileId]);
        }
    }

    private void putPieceIcon(String nameOfPiece) {
        try {
            add(new JLabel(new ImageIcon(ImageIO.read(new File("pieces/" + nameOfPiece + ".gif")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}