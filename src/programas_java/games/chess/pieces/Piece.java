package programas_java.games.chess.pieces;

import programas_java.games.chess.*;
import java.util.ArrayList;

public abstract class Piece {
    
    protected String color;
    protected String type;
    protected int numberOfMoves = 0;

    public Piece(String color, String type) {

        this.color = color;
        this.type = type;

    }

    public abstract ArrayList<Square> movePiece(Square square, ChessBoard board);

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();

    }

}
