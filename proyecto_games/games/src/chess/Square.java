package chess;

import chess.pieces.*;

public class Square {
    
    private String squareID;
    private Piece piece;
    private int fil;
    private int col;

    public Square(String squareID, int fil, int col) {

        this.squareID = squareID;
        this.fil = fil;
        this.col = col;

    }

    public Piece getPiece() {

        return this.piece;

    }

    public void setPiece(Piece piece) {

        this.piece = piece;
        
    }

    public String getSquareID() {
        return squareID;
    }

    public void setSquareID(String squareID) {
        this.squareID = squareID;
    }
    
    public int getFil() {
        return fil;
    }

    public void setFil(int fil) {
        this.fil = fil;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "" + squareID;
    }

}
