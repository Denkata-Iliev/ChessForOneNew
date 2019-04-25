package Logic;

import java.util.List;

public class Player {
    public boolean isWhite;
    public boolean isInCheck;
    public boolean isInCheckMate;
    public boolean isInStaleMate;

    List<Move> legalMoves;

    public Player(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isInCheck() {
        return this.isInCheck;
    }

    public boolean isInCheckMate() {
        return this.isInCheck && !hasEscapeMoves();
    }

    public boolean isInStaleMate() {
        return !this.isInCheck && !hasEscapeMoves();
    }

    private boolean hasEscapeMoves() {
        if (this.legalMoves == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean getAlliance(){
        return this.isWhite;
    }

    public List<Move> getLegalMoves() {
        return this.legalMoves;
    }

    //playmove

}
