package Logic;

import java.util.List;

public abstract class Piece {

    boolean isWhite;
    final int piecePosition;


    Piece(boolean isWhite,
          int piecePositionX, int piecePositionY) {
        this.piecePosition = piecePositionY * 8 + piecePositionX;
        this.isWhite = isWhite;
    }

    public abstract List<Move> calculateLegalMoves(final Board board);
}