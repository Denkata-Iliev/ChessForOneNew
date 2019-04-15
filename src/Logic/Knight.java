package Logic;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    private final static int[] candidateMoveCoordinates = new int[8];

    Knight(Alliance alliance, int piecePosition) {
        super(alliance, piecePosition);
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {
        return null;
    }

    @Override
    public List<Move> calculateLegalMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for (final int currentCandidateOffset : candidateMoveCoordinates) {

            final int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;

            if (true /*nz oshte ama imashe neshto*/)) {

                //final Piece pieceAtDestination = board.getPiece(candidateDestinationCoordinate);

                //if (pieceAtDestination == null) {

                    //legalMoves.add(new Move(board, this, candidateDestinationCoordinate));

                }/* else {
                    final Alliance pieceAtDestinationAllegiance = pieceAtDestination.getPieceAllegiance();
                    if (this.pieceAlliance != pieceAtDestinationAllegiance) {
                        legalMoves.add(new MajorAttackMove(board, this, candidateDestinationCoordinate,
                                pieceAtDestination));
                    }
                }
                */
            }
        }
        //return ImmutableList.copyOf(legalMoves);    Dobavi imutable
    }
}
