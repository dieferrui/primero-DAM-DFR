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
        String targetColor;

        if (square.getPiece().getColor().equals("white")) {

            targetColor = "black";

        } else {

            targetColor = "white";
        }

        // Movimiento vertical hacia arriba
        for (int i = (filPos - 1); i >= 0; i--) {

            if (board.boardLayout[i][colPos].getPiece() == null) {

                validMoves.add(board.boardLayout[i][colPos]);

            } else {

                if (board.boardLayout[i][colPos].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[i][colPos]);
                    break;

                } else {

                    break;

                }
            }
        }

        // Movimiento vertical hacia abajo
        for (int i = (filPos + 1); i <= 7; i++) {

            if (board.boardLayout[i][colPos].getPiece() == null) {

                validMoves.add(board.boardLayout[i][colPos]);

            } else {

                if (board.boardLayout[i][colPos].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[i][colPos]);
                    break;

                } else {

                    break;

                }
            }
        }

        // Movimiento horizontal a la izquierda
        for (int i = (colPos - 1); i >= 0; i--) {

            if (board.boardLayout[filPos][i].getPiece() == null) {

                validMoves.add(board.boardLayout[filPos][i]);

            } else {

                if (board.boardLayout[filPos][i].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[filPos][i]);
                    break;

                } else {

                    break;

                }
            }
        }

        // Movimiento horizontal a la derecha
        for (int i = (colPos + 1); i <= 7; i++) {

            if (board.boardLayout[filPos][i].getPiece() == null) {

                validMoves.add(board.boardLayout[filPos][i]);

            } else {

                if (board.boardLayout[filPos][i].getPiece().getColor().equals(targetColor)) {

                    validMoves.add(board.boardLayout[filPos][i]);
                    break;

                } else {

                    break;

                }
            }
        }

        // Movimiento diagonal arriba izquierda
        for (int i = (filPos - 1); i >= 0; i--) {

            for (int j = (colPos - 1); j >= 0; j--) {

                if (board.boardLayout[i][j].getPiece() == null) {

                    validMoves.add(board.boardLayout[i][j]);

                } else {

                    if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                        validMoves.add(board.boardLayout[i][j]);
                        break;

                    } else {

                        break;

                    }
                }
            }
        }

        // Movimiento diagonal arriba derecha
        for (int i = (filPos - 1); i >= 0; i--) {

            for (int j = (colPos + 1); j <= 7; j++) {

                if (board.boardLayout[i][j].getPiece() == null) {

                    validMoves.add(board.boardLayout[i][j]);

                } else {

                    if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                        validMoves.add(board.boardLayout[i][j]);
                        break;

                    } else {

                        break;

                    }
                }
            }
        }

        // Movimiento diagonal abajo izquierda
        for (int i = (filPos + 1); i <= 7; i++) {

            for (int j = (colPos - 1); j >= 0; j--) {

                if (board.boardLayout[i][j].getPiece() == null) {

                    validMoves.add(board.boardLayout[i][j]);

                } else {

                    if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                        validMoves.add(board.boardLayout[i][j]);
                        break;

                    } else {

                        break;

                    }
                }
            }
        }

        // Movimiento diagonal abajo derecha
        for (int i = (filPos + 1); i <= 7; i++) {

            for (int j = (colPos + 1); j <= 7; j++) {

                if (board.boardLayout[i][j].getPiece() == null) {

                    validMoves.add(board.boardLayout[i][j]);

                } else {

                    if (board.boardLayout[i][j].getPiece().getColor().equals(targetColor)) {

                        validMoves.add(board.boardLayout[i][j]);
                        break;

                    } else {

                        break;

                    }
                }
            }
        }

        return validMoves;
    }
}
