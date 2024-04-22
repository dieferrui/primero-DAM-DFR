package chess.pieces;

import java.util.ArrayList;

import chess.*;

public class King extends Piece {
    
    public King(String color, String type) {

        super(color, type);
        
    }

    public ArrayList<Square> movePiece(Square square, ChessBoard board) {

        ArrayList<Square> validMoves = new ArrayList<>();
        int filPos = square.getFil();
        int colPos = square.getCol();
        String targetColor;

        if (square.getPiece().getColor().equals("white")) {

            targetColor = "black";

        } else {

            targetColor = "white";
        }

        // Casilla a la izquierda
        try {

            if (board.boardLayout[filPos][colPos - 1].getPiece() == null || 
            board.boardLayout[filPos][colPos - 1].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[filPos][colPos - 1]);

            }

        } catch (IndexOutOfBoundsException e) {
            // Do nothing
        }
        

        // Casilla a la derecha
        try {

            if (board.boardLayout[filPos][colPos + 1].getPiece() == null || 
                board.boardLayout[filPos][colPos + 1].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[filPos][colPos + 1]);

            }

        } catch (IndexOutOfBoundsException e) {
            // Do nothing
        }

        // Casilla arriba
        try {

            if (board.boardLayout[filPos - 1][colPos].getPiece() == null || 
                board.boardLayout[filPos - 1][colPos].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[filPos - 1][colPos]);

            }
            
        } catch (IndexOutOfBoundsException e) {
            // Do nothing
        }

        // Casilla abajo
        try {

            if (board.boardLayout[filPos + 1][colPos].getPiece() == null || 
                board.boardLayout[filPos + 1][colPos].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[filPos + 1][colPos]);

            }
        
        } catch (IndexOutOfBoundsException e) { 
            // Do nothing
        }

        // Casilla arriba a la izquierda
        try {

            if (board.boardLayout[filPos - 1][colPos - 1].getPiece() == null || 
                board.boardLayout[filPos - 1][colPos - 1].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[filPos - 1][colPos - 1]);

            }

        } catch (IndexOutOfBoundsException e) {
            // Do nothing
        }

        // Casilla arriba a la derecha
        try {

            if (board.boardLayout[filPos - 1][colPos + 1].getPiece() == null || 
                board.boardLayout[filPos - 1][colPos + 1].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[filPos - 1][colPos + 1]);

            }

        } catch (IndexOutOfBoundsException e) {
            // Do nothing
        }

        // Casilla abajo a la izquierda
        try {

            if (board.boardLayout[filPos + 1][colPos - 1].getPiece() == null || 
                board.boardLayout[filPos + 1][colPos - 1].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[filPos + 1][colPos - 1]);

            }

        } catch (IndexOutOfBoundsException e) {
            // Do nothing
        }

        // Casilla abajo a la derecha
        try {

            if (board.boardLayout[filPos + 1][colPos + 1].getPiece() == null || 
                board.boardLayout[filPos + 1][colPos + 1].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[filPos + 1][colPos + 1]);

            }

        } catch (IndexOutOfBoundsException e) {
            // Do nothing
        }

        return validMoves;
    }
}
