package Logic;

public abstract class Tile {

    int tileCoordinateX;
    int tileCoordinateY;


    public Tile(int tileCoordinateX, int tileCoordinateY) {
        this.tileCoordinateX = tileCoordinateX;
        this.tileCoordinateY = tileCoordinateY;
    }




    public abstract boolean isItOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile{

        public EmptyTile(int tileCoordinateX, int tileCoordinateY) {
            super(tileCoordinateX, tileCoordinateY);
        }

        @Override
        public boolean isItOccupied(){
            return false;
        }

        @Override
        public Piece getPiece(){
            return null;
        }
    }

    public static final class occupiedTile extends Tile{

        Piece pieceOnTile;

        public occupiedTile(int tileCoordinateX, int tileCoordinateY, Piece pieceOnTile) {
            super(tileCoordinateX, tileCoordinateY);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isItOccupied(){
            return true;
        }

        @Override
        public Piece getPiece(){
            return this.pieceOnTile;
        }
    }
}
