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

        addValidMove(board, validMoves, filPos, colPos - 1, targetColor); // Casilla a la izquierda
        addValidMove(board, validMoves, filPos, colPos + 1, targetColor); // Casilla a la derecha
        addValidMove(board, validMoves, filPos - 1, colPos, targetColor); // Casilla arriba
        addValidMove(board, validMoves, filPos + 1, colPos, targetColor); // Casilla abajo
        addValidMove(board, validMoves, filPos - 1, colPos - 1, targetColor); // Casilla arriba a la izquierda
        addValidMove(board, validMoves, filPos - 1, colPos + 1, targetColor); // Casilla arriba a la derecha
        addValidMove(board, validMoves, filPos + 1, colPos - 1, targetColor); // Casilla abajo a la izquierda
        addValidMove(board, validMoves, filPos + 1, colPos + 1, targetColor); // Casilla abajo a la derecha

        return validMoves;
    }

    private void addValidMove(ChessBoard board, ArrayList<Square> validMoves, int filPos, int colPos, String targetColor) {

        try {

            if (board.boardLayout[filPos][colPos].getPiece() == null ||
                    board.boardLayout[filPos][colPos].getPiece().getColor().equals(targetColor)) {
                validMoves.add(board.boardLayout[filPos][colPos]);
            }
            
        } catch (IndexOutOfBoundsException e) {
            // Ignora casillas fuera del tablero
        }
    }
}
