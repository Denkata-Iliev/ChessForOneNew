package Logic;

public class Move {

    Board board;
    int destinationCoordinate;
    Piece movedPiece;

    public void execute() {
        board.movePiece(movedPiece.getPiecePosition(), destinationCoordinate);
    }

    public Move(Board board,
                Piece pieceMoved,
                int destinationCoordinate) {
        this.board = board;
        this.destinationCoordinate = destinationCoordinate;
        this.movedPiece = pieceMoved;


    }


    public Board getBoard() {
        return this.board;
    }

    public int getCurrentCoordinate() {
        return this.movedPiece.getPiecePosition();
    }

    public int getDestinationCoordinate() {
        return this.destinationCoordinate;
    }

    public Piece getMovedPiece() {
        return this.movedPiece;
    }


    public Piece getAttackedPiece() {
        return null;
    }


    public static class MajorMove
            extends Move {

        public MajorMove(final Board board,
                         final Piece pieceMoved,
                         final int destinationCoordinate) {
            super(board, pieceMoved, destinationCoordinate);
        }

    }

    abstract static class AttackMove
            extends Move {

        private final Piece attackedPiece;

        AttackMove(final Board board,
                   final Piece pieceMoved,
                   final int destinationCoordinate,
                   final Piece pieceAttacked) {
            super(board, pieceMoved, destinationCoordinate);
            this.attackedPiece = pieceAttacked;
        }


        @Override
        public Piece getAttackedPiece() {
            return this.attackedPiece;
        }


    }

    public static class MajorAttackMove
            extends AttackMove {

        public MajorAttackMove(final Board board,
                               final Piece pieceMoved,
                               final int destinationCoordinate,
                               final Piece pieceAttacked) {
            super(board, pieceMoved, destinationCoordinate, pieceAttacked);
        }


    }

    public class PawnMove
            extends Move {

        public PawnMove(final Board board,
                        final Piece pieceMoved,
                        final int destinationCoordinate) {
            super(board, pieceMoved, destinationCoordinate);
        }


    }


    public static class PawnAttackMove
            extends AttackMove {

        public PawnAttackMove(final Board board,
                              final Piece pieceMoved,
                              final int destinationCoordinate,
                              final Piece pieceAttacked) {
            super(board, pieceMoved, destinationCoordinate, pieceAttacked);
        }


    }

    public class PawnPromotion
            extends PawnMove {

        final Move decoratedMove;
        final Pawn promotedPawn;
        final Piece promotionPiece;

        public PawnPromotion(final Move decoratedMove,
                             final Piece promotionPiece) {
            super(decoratedMove.getBoard(), decoratedMove.getMovedPiece(), decoratedMove.getDestinationCoordinate());
            this.decoratedMove = decoratedMove;
            this.promotedPawn = (Pawn) decoratedMove.getMovedPiece();
            this.promotionPiece = promotionPiece;
        }

    /*public Board execute() {
        final Board.Builder builder = new Builder();
        this.board.currentPlayer().getActivePieces().stream().filter(piece -> !this.movedPiece.equals(piece)).forEach(builder::setPiece);
        this.board.currentPlayer().getOpponent().getActivePieces().forEach(builder::setPiece);
        builder.setPiece(this.movedPiece.movePiece(this));
        builder.setMoveMaker(this.board.currentPlayer().getOpponent().getAlliance());
        builder.setMoveTransition(this);
        return builder.build();
    }
    */

    }
}

