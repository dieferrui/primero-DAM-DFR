package chess.pieces;

import java.util.ArrayList;

import chess.*;

public class Queen extends Piece {
    
    public Queen(String color, String type) {

        super(color, type);
        
    }

    public ArrayList<Square> movePiece(Square square, ChessBoard board) {

        ArrayList<Square> validMoves = new ArrayList<>();
        int filPos = square.getFil();
        int colPos = square.getCol();
        String targetColor = square.getPiece().getColor().equals("white") ? "black" : "white";

        validMoves.addAll(moveVerticalUp(filPos, colPos, board, targetColor));
        validMoves.addAll(moveVerticalDown(filPos, colPos, board, targetColor));
        validMoves.addAll(moveHorizontalLeft(filPos, colPos, board, targetColor));
        validMoves.addAll(moveHorizontalRight(filPos, colPos, board, targetColor));
        validMoves.addAll(moveDiagonalUpLeft(filPos, colPos, board, targetColor));
        validMoves.addAll(moveDiagonalUpRight(filPos, colPos, board, targetColor));
        validMoves.addAll(moveDiagonalDownLeft(filPos, colPos, board, targetColor));
        validMoves.addAll(moveDiagonalDownRight(filPos, colPos, board, targetColor));

        return validMoves;
    }

    private ArrayList<Square> moveVerticalUp(int filPos, int colPos, ChessBoard board, String targetColor) {

        ArrayList<Square> validMoves = new ArrayList<>();

        for (int i = filPos - 1; i >= 0; i--) {

            if (board.boardLayout[i][colPos].getPiece() == null) {

                validMoves.add(board.boardLayout[i][colPos]);

            } else {

                if (board.boardLayout[i][colPos].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[i][colPos]);

                }

                break;
            }
        }
        return validMoves;
    }

    private ArrayList<Square> moveVerticalDown(int filPos, int colPos, ChessBoard board, String targetColor) {

        ArrayList<Square> validMoves = new ArrayList<>();

        for (int i = filPos + 1; i <= 7; i++) {

            if (board.boardLayout[i][colPos].getPiece() == null) {

                validMoves.add(board.boardLayout[i][colPos]);

            } else {

                if (board.boardLayout[i][colPos].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[i][colPos]);

                }

                break;
            }
        }

        return validMoves;
    }

    private ArrayList<Square> moveHorizontalLeft(int filPos, int colPos, ChessBoard board, String targetColor) {

        ArrayList<Square> validMoves = new ArrayList<>();

        for (int i = colPos - 1; i >= 0; i--) {

            if (board.boardLayout[filPos][i].getPiece() == null) {

                validMoves.add(board.boardLayout[filPos][i]);

            } else {

                if (board.boardLayout[filPos][i].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[filPos][i]);

                }

                break;
            }
        }

        return validMoves;
    }

    private ArrayList<Square> moveHorizontalRight(int filPos, int colPos, ChessBoard board, String targetColor) {

        ArrayList<Square> validMoves = new ArrayList<>();

        for (int i = colPos + 1; i <= 7; i++) {

            if (board.boardLayout[filPos][i].getPiece() == null) {

                validMoves.add(board.boardLayout[filPos][i]);

            } else {

                if (board.boardLayout[filPos][i].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[filPos][i]);

                }

                break;
            }
        }

        return validMoves;
    }

    private ArrayList<Square> moveDiagonalUpLeft(int filPos, int colPos, ChessBoard board, String targetColor) {

        ArrayList<Square> validMoves = new ArrayList<>();

        for (int i = filPos - 1, j = colPos - 1; i >= 0 && j >= 0; i--, j--) {

            if (board.boardLayout[i][j].getPiece() == null) {

                validMoves.add(board.boardLayout[i][j]);

            } else {

                if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[i][j]);

                }

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

            } else {

                if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[i][j]);

                }

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

            } else {

                if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[i][j]);

                }

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

            } else {

                if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[i][j]);

                }

                break;
            }
        }
        
        return validMoves;
    }
}
