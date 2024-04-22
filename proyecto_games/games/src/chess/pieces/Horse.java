package chess.pieces;

import java.util.ArrayList;

import chess.*;

public class Horse extends Piece {
    
    public Horse(String color, String type) {

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

        addValidMove(validMoves, board, filPos - 1, colPos - 2, targetColor);
        addValidMove(validMoves, board, filPos - 2, colPos - 1, targetColor);
        addValidMove(validMoves, board, filPos - 2, colPos + 1, targetColor);
        addValidMove(validMoves, board, filPos - 1, colPos + 2, targetColor);
        addValidMove(validMoves, board, filPos + 1, colPos - 2, targetColor);
        addValidMove(validMoves, board, filPos + 2, colPos - 1, targetColor);
        addValidMove(validMoves, board, filPos + 2, colPos + 1, targetColor);
        addValidMove(validMoves, board, filPos + 1, colPos + 2, targetColor);

        return validMoves;
    }

    private void addValidMove(ArrayList<Square> validMoves, ChessBoard board, int fil, int col, String targetColor) {

        try {

            if (board.boardLayout[fil][col].getPiece() == null || board.boardLayout[fil][col].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[fil][col]);

            }
            
        } catch (IndexOutOfBoundsException e) {
            // Ignorar casillas fuera del tablero
        }
    }
}

