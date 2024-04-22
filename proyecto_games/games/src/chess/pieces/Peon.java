package chess.pieces;

import chess.*;
import java.util.ArrayList;

public class Peon extends Piece {
    
    public Peon(String color, String type) {
        super(color, type);
    }

    public ArrayList<Square> movePiece(Square square, ChessBoard board) {

        ArrayList<Square> validMoves = new ArrayList<>();
        int filPos = square.getFil();
        int colPos = square.getCol();
        int direction = this.getColor().equals("white") ? 1 : -1;

        if (square.getPiece().getNumberOfMoves() < 1 && board.boardLayout[filPos + 2 * direction][colPos].getPiece() == null &&
            board.boardLayout[filPos + direction][colPos].getPiece() == null) {

            validMoves.add(board.boardLayout[filPos + 2 * direction][colPos]);

        }

        try {

            if (board.boardLayout[filPos + direction][colPos].getPiece() == null) {

                validMoves.add(board.boardLayout[filPos + direction][colPos]);

            }

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            // Las casillas fuera del tablero no se añaden al array de movimientos
        }

        try {

            if (board.boardLayout[filPos + direction][colPos - 1].getPiece().getColor().equals(this.getOppositeColor())) {

                validMoves.add(board.boardLayout[filPos + direction][colPos - 1]);

            }

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            // Las casillas fuera del tablero no se añaden al array de movimientos
        }

        try {

            if (board.boardLayout[filPos + direction][colPos + 1].getPiece().getColor().equals(this.getOppositeColor())) {

                validMoves.add(board.boardLayout[filPos + direction][colPos + 1]);

            }

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            // Las casillas fuera del tablero no se añaden al array de movimientos
        }

        return validMoves;
    }

    public String getOppositeColor() {

        return this.getColor().equals("white") ? "black" : "white";

    }
    
}

