package programas_java.games.chess.pieces;

import programas_java.games.chess.*;

public class Peon extends Piece {
    
    public Peon(String color, String type) {

        super(color, type);
        
    }

    public int[][] movePiece(Square square, ChessBoard board) {

        int filPos = square.getFil();
        int colPos = square.getCol();

        if (this.getColor().equals("white")) {

            if (this.getNumberOfMoves() < 1) {

                
            }
        }

    }
}
