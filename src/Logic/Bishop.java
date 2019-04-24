package Logic;



import Logic.Move;
import Logic.Piece;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class Bishop extends Piece {

    int[] CANDIDATE_MOVE_COORDINATES = {-9, -7, 7, 9};

    public Bishop(boolean isWhite, final int piecePosition) {
        super(isWhite, piecePosition);
    }

    public List<Move> calculateLegalMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
            int candidateDestinationCoordinate = this.piecePosition;
            while (board.isValidTileCoordinate(candidateDestinationCoordinate)) {
                candidateDestinationCoordinate += currentCandidateOffset;
                if (board.isValidTileCoordinate(candidateDestinationCoordinate)) {

                    final Piece pieceAtDestination = board.getPiece(candidateDestinationCoordinate);

                    if (pieceAtDestination == null) {
                        legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
                    }
                    else {
                        final boolean pieceAlliance = pieceAtDestination.getPieceAllegiance();
                        if (this.isWhite != pieceAlliance) {
                            legalMoves.add(new Move.MajorAttackMove(board, this, candidateDestinationCoordinate,
                                    pieceAtDestination));
                        }
                        break;
                    }
                }
            }
        }
        return legalMoves;
    }

}