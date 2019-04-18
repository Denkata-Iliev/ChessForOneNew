package Logic;

import java.util.List;

public abstract class Piece {

    boolean isWhite;
    final int piecePosition;

    Piece(boolean isWhite,
          final int piecePosition) {
        this.piecePosition = piecePosition;
        this.isWhite = isWhite;
    }

    public abstract List<Move> calculateLegalMoves(final Board board);
}