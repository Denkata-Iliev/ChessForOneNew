package Logic;

import java.util.List;

public abstract class Piece {

    final Alliance pieceAlliance;
    final int piecePosition;

    Piece(final Alliance alliance,
          final int piecePosition) {
        this.piecePosition = piecePosition;
        this.pieceAlliance = alliance;
    }

    public abstract List<Move> calculateLegalMoves(final Board board);
}