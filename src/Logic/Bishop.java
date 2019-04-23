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

    @Override
    // dobavi dulgite dvizheniq na vsi4ki figuri
    public List<Move> calculateLegalMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {

            final int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;

            if (Board.isValidTileCoordinate(candidateDestinationCoordinate)) {

                final Piece pieceAtDestination = board.getPiece(candidateDestinationCoordinate);

                if (pieceAtDestination == null) {
                    legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
                } else {
                    final boolean pieceAtDestinationAllegiance = pieceAtDestination.getPieceAllegiance();
                    if (this.isWhite != pieceAtDestinationAllegiance) {
                        legalMoves.add(new Move.MajorAttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                    }
                }
            }
        }
        return legalMoves;
    }

}