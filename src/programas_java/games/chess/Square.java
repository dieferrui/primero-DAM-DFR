package programas_java.games.chess;

public class Square {
    
    private String squareID;
    private Piece piece;

    public Square(String squareID) {

        this.squareID = squareID;

    }

    public Piece getPiece() {

        return this.piece;

    }

    public void setPiece(Piece piece) {

        this.piece = piece;
        
    }
}
