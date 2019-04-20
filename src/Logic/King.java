package Logic;



import java.util.ArrayList;
import java.util.List;

public final class King extends Piece {

    int[] CANDIDATE_MOVE_COORDINATES = { -9, -8, -7, -1, 1, 7, 8, 9 };
    boolean isCastled;
    //private final boolean kingSideCastleCapable;
    //private final boolean queenSideCastleCapable;

    public King(boolean isWhite, final int piecePosition) {
        super(isWhite, piecePosition);
        this.isCastled = false;
    }


    public boolean isCastled() {
        return this.isCastled;
    }


    @Override
    public List<Move> calculateLegalMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for (int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {

            int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;

            if ((Boolean) Board.isValidTileCoordinate(candidateDestinationCoordinate)) {

                Piece pieceAtDestination = board.getPiece(candidateDestinationCoordinate);

                if (pieceAtDestination == null) {
                    legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
                } else {
                    boolean pieceAtDestinationAllegiance = pieceAtDestination.getPieceAllegiance();
                    if (this.isWhite != pieceAtDestinationAllegiance) {
                        legalMoves.add(new Move.MajorAttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                    }
                }
            }
        }
        if (legalMoves ==null){
            isCastled = true;
        }
        return legalMoves;
    }


}