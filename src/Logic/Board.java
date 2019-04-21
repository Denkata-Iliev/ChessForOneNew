package Logic;

import java.util.List;

public class Board {

    // matricata
    //tile
    //pieceType string
    public Tile boardMatrix[][] = new Tile[8][8];
    String stringmatrix[][] = new String[8][8];
    public Piece[] deadPieces = new Piece[32];

    public Board() {
        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                new Tile.occupiedTile(i, 0, new Rook(true, 8 * i + 0));
                new Tile.occupiedTile(i, 7, new Rook(true, 8 * i + 7));
                new Tile.occupiedTile(i, 1, new Knight(true, 8 * i + 1));
                new Tile.occupiedTile(i, 6, new Knight(true, 8 * i + 6));
                new Tile.occupiedTile(i, 2, new Bishop(true, 8 * i + 2));
                new Tile.occupiedTile(i, 5, new Bishop(true, 8 * i + 5));
                new Tile.occupiedTile(i, 3, new Queen(true, 8 * i + 3));
                new Tile.occupiedTile(i, 4, new King(true, 8 * i + 4));
            } else {
                if (i == 7) {
                    new Tile.occupiedTile(i, 0, new Rook(false, 8 * i + 0));
                    new Tile.occupiedTile(i, 7, new Rook(false, 8 * i + 7));
                    new Tile.occupiedTile(i, 1, new Knight(false, 8 * i + 1));
                    new Tile.occupiedTile(i, 6, new Knight(false, 8 * i + 6));
                    new Tile.occupiedTile(i, 2, new Bishop(false, 8 * i + 2));
                    new Tile.occupiedTile(i, 5, new Bishop(false, 8 * i + 5));
                    new Tile.occupiedTile(i, 3, new King(false, 8 * i + 3));
                    new Tile.occupiedTile(i, 4, new Queen(false, 8 * i + 4));
                } else {
                    if (i == 1) {
                        for (int j = 0; j < 8; j++) {
                            new Tile.occupiedTile(i, j, new Pawn(true, 8 * i + j));
                        }
                    } else {
                        if (i == 6) {
                            for (int j = 0; j < 8; j++) {
                                new Tile.occupiedTile(i, j, new Pawn(false, 8 * i + j));
                            }
                        } else {
                            for (int j = 0; j < 8; j++) {
                                new Tile.EmptyTile(i, j);
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isValidTileCoordinate(int coordinate) {
        if (coordinate >= 0 && coordinate < 64){
            return true;
        }else return false;
    }

    public Piece getPiece(int coordinates) {
        return boardMatrix[coordinates / 8 + 1][coordinates - (coordinates / 8 - 1)].getPiece();
    }

    /*public String[][] reArangeStringMatrix(Tile[][] boardMatrix, String[][] stringMatrix) {
        for (int i = 0; i <; i++) {
            //White_Queen
        }
        return stringmatrix[][];
    }
    */
}
