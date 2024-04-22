package chess.pieces;

import java.util.ArrayList;

import chess.*;

public class Bishop extends Piece {
    
    public Bishop(String color, String type) {

        super(color, type);
        
    }

    public ArrayList<Square> movePiece(Square square, ChessBoard board) {

        ArrayList<Square> validMoves = new ArrayList<>();
        int filPos = square.getFil();
        int colPos = square.getCol();
        String targetColor = square.getPiece().getColor().equals("white") ? "black" : "white";

        validMoves.addAll(moveDiagonalUpLeft(filPos, colPos, board, targetColor));
        validMoves.addAll(moveDiagonalUpRight(filPos, colPos, board, targetColor));
        validMoves.addAll(moveDiagonalDownLeft(filPos, colPos, board, targetColor));
        validMoves.addAll(moveDiagonalDownRight(filPos, colPos, board, targetColor));

        return validMoves;
    }

    private ArrayList<Square> moveDiagonalUpLeft(int filPos, int colPos, ChessBoard board, String targetColor) {

        ArrayList<Square> validMoves = new ArrayList<>();

        for (int i = filPos - 1, j = colPos - 1; i >= 0 && j >= 0; i--, j--) {

            if (board.boardLayout[i][j].getPiece() == null) {

                validMoves.add(board.boardLayout[i][j]);

            } else if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[i][j]);
                break;

            } else {

                break;

            }
        }

        return validMoves;
    }

    private ArrayList<Square> moveDiagonalUpRight(int filPos, int colPos, ChessBoard board, String targetColor) {

        ArrayList<Square> validMoves = new ArrayList<>();

        for (int i = filPos - 1, j = colPos + 1; i >= 0 && j <= 7; i--, j++) {

            if (board.boardLayout[i][j].getPiece() == null) {

                validMoves.add(board.boardLayout[i][j]);

            } else if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[i][j]);
                break;

            } else {

                break;

            }
        }

        return validMoves;
    }

    private ArrayList<Square> moveDiagonalDownLeft(int filPos, int colPos, ChessBoard board, String targetColor) {

        ArrayList<Square> validMoves = new ArrayList<>();

        for (int i = filPos + 1, j = colPos - 1; i <= 7 && j >= 0; i++, j--) {

            if (board.boardLayout[i][j].getPiece() == null) {

                validMoves.add(board.boardLayout[i][j]);

            } else if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[i][j]);
                break;

            } else {

                break;

            }
        }

        return validMoves;
    }

    private ArrayList<Square> moveDiagonalDownRight(int filPos, int colPos, ChessBoard board, String targetColor) {

        ArrayList<Square> validMoves = new ArrayList<>();

        for (int i = filPos + 1, j = colPos + 1; i <= 7 && j <= 7; i++, j++) {

            if (board.boardLayout[i][j].getPiece() == null) {

                validMoves.add(board.boardLayout[i][j]);

            } else if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                validMoves.add(board.boardLayout[i][j]);
                break;

            } else {

                break;

            }
        }

        return validMoves;
    }
}
