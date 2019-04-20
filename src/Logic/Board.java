package Logic;

import com.chess.engine.classic.pieces.Knight;

public class Board {

    // matricata
    //tile
    //pieceType string
    Tile boardMatrix [][] = new Tile[8][8];
    String stringmatrix [][] = new String [8][8];

    public Board() {
        for (int i = 0; i < 8; i++) {
            if(i == 0 || i == 7){
                new Tile.occupiedTile(i, 0, new Rook(true, 8 * i + 0));
                new Tile.occupiedTile(i, 0, new Rook(true, 8 * i + 7));
                new Tile.occupiedTile(i, 0, new Knight(true, 8 * i + 7));
                new Tile.occupiedTile(i, 0, new Rook(true, 8 * i + 7));
                new Tile.occupiedTile(i, 0, new Rook(true, 8 * i + 7));
                new Tile.occupiedTile(i, 0, new Rook(true, 8 * i + 7));
                new Tile.occupiedTile(i, 0, new Rook(true, 8 * i + 7));
                new Tile.occupiedTile(i, 0, new Rook(true, 8 * i + 7));
            }
        }
    }

    public boolean isValidTileCoordinate(){

    }

    public String[][] reArangeStringMatrix (Tile[][] boardMatrix, String[][] stringMatrix){
        for (int i = 0; i < ; i++) {
            //White_Queen
        }
        return stringmatrix[][];
    }
}
