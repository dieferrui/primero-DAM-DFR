package chess.pieces;

import chess.*;
import java.util.ArrayList;

public abstract class Piece {
    
    protected String color;
    protected String type;
    protected String symbol;
    protected int numberOfMoves = 0;

    public Piece(String color, String type) {

        this.color = color;
        this.type = type;

    }

    public abstract ArrayList<Square> movePiece(Square square, ChessBoard board);

    public void addMove() {

        numberOfMoves++;
        
    }

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();

    }
}
