package Logic;

import java.util.List;

public abstract class Piece {

    boolean isWhite;
    final int piecePosition;


    Piece(boolean isWhite,
          int piecePosition) {
        this.piecePosition = piecePosition
        this.isWhite = isWhite;
    }

    public boolean getPieceAllegiance(){

    }

    public boolean isWhite() {
        return isWhite;
    }

    public int getPiecePosition() {
        return piecePosition;
    }

    public abstract List<Move> calculateLegalMoves(final Board board);
}