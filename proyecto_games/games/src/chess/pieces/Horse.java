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

        // L superior izquierda
        if (board.boardLayout[filPos - 1][colPos - 2].getPiece() == null || 
            board.boardLayout[filPos - 1][colPos - 2].getPiece().getColor().equals(targetColor)) {

            validMoves.add(board.boardLayout[filPos - 1][colPos - 2]);

        }

        // L superior invertida izquierda
        if (board.boardLayout[filPos - 2][colPos - 1].getPiece() == null || 
            board.boardLayout[filPos - 2][colPos - 1].getPiece().getColor().equals(targetColor)) {

            validMoves.add(board.boardLayout[filPos - 2][colPos - 1]);

        }

        // L superior invertida derecha
        if (board.boardLayout[filPos - 2][colPos + 1].getPiece() == null || 
            board.boardLayout[filPos - 2][colPos + 1].getPiece().getColor().equals(targetColor)) {

            validMoves.add(board.boardLayout[filPos - 2][colPos + 1]);

        }

        // L superior derecha
        if (board.boardLayout[filPos - 1][colPos + 2].getPiece() == null || 
            board.boardLayout[filPos - 1][colPos + 2].getPiece().getColor().equals(targetColor)) {

            validMoves.add(board.boardLayout[filPos - 1][colPos + 2]);

        }

        // L inferior invertida izquierda
        if (board.boardLayout[filPos + 1][colPos - 2].getPiece() == null || 
            board.boardLayout[filPos + 1][colPos - 2].getPiece().getColor().equals(targetColor)) {

            validMoves.add(board.boardLayout[filPos + 1][colPos - 2]);

        }

        // L inferior izquierda
        if (board.boardLayout[filPos + 2][colPos - 1].getPiece() == null || 
            board.boardLayout[filPos + 2][colPos - 1].getPiece().getColor().equals(targetColor)) {

            validMoves.add(board.boardLayout[filPos + 2][colPos - 1]);

        }

        // L inferior derecha
        if (board.boardLayout[filPos + 2][colPos + 1].getPiece() == null || 
            board.boardLayout[filPos + 2][colPos + 1].getPiece().getColor().equals(targetColor)) {

            validMoves.add(board.boardLayout[filPos + 2][colPos + 1]);

        }

        // L inferior invertida derecha
        if (board.boardLayout[filPos + 1][colPos + 2].getPiece() == null || 
            board.boardLayout[filPos + 1][colPos + 2].getPiece().getColor().equals(targetColor)) {

            validMoves.add(board.boardLayout[filPos + 1][colPos + 2]);

        }

        return validMoves;
    }
}

