package chess.pieces;

import java.util.ArrayList;

import chess.*;

public class Tower extends Piece {
    
    public Tower(String color, String type) {

        super(color, type);
        
    }

    public ArrayList<Square> movePiece(Square square, ChessBoard board) {

        ArrayList<Square> validMoves = new ArrayList<>();
        int filPos = square.getFil();
        int colPos = square.getCol();
        String targetColor = square.getPiece().getColor().equals("white") ? "black" : "white";

        validMoves.addAll(getValidVerticalMoves(filPos, colPos, targetColor, board));
        validMoves.addAll(getValidHorizontalMoves(filPos, colPos, targetColor, board));

        return validMoves;
    }

    private ArrayList<Square> getValidVerticalMoves(int filPos, int colPos, String targetColor, ChessBoard board) {

        ArrayList<Square> validMoves = new ArrayList<>();

        // Movimiento vertical hacia arriba
        for (int i = filPos - 1; i >= 0; i--) {

            if (addValidMove(validMoves, board.boardLayout[i][colPos], targetColor)) {

                break;

            }
        }

        // Movimiento vertical hacia abajo
        for (int i = filPos + 1; i <= 7; i++) {

            if (addValidMove(validMoves, board.boardLayout[i][colPos], targetColor)) {

                break;

            }
        }

        return validMoves;
    }

    private ArrayList<Square> getValidHorizontalMoves(int filPos, int colPos, String targetColor, ChessBoard board) {

        ArrayList<Square> validMoves = new ArrayList<>();

        // Movimiento horizontal a la izquierda
        for (int i = colPos - 1; i >= 0; i--) {

            if (addValidMove(validMoves, board.boardLayout[filPos][i], targetColor)) {

                break;

            }
        }

        // Movimiento horizontal a la derecha
        for (int i = colPos + 1; i <= 7; i++) {

            if (addValidMove(validMoves, board.boardLayout[filPos][i], targetColor)) {

                break;

            }
        }

        return validMoves;
    }

    private boolean addValidMove(ArrayList<Square> validMoves, Square square, String targetColor) {

        if (square.getPiece() == null) {

            validMoves.add(square);

        } else if (square.getPiece().getColor().equals(targetColor)) {

            validMoves.add(square);
            return true;

        }
        
        return false;
    }
}
