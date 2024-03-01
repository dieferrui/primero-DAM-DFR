package programas_java.chess.pieces;

public abstract class Piece {
    
    private String color;
    private String type;

    public Piece(String color, String type) {

        this.color = color;
        this.type = type;

    }

    public abstract void movePiece();

}
