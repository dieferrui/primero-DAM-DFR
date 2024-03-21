package programas_java.games.chess.pieces;

import java.util.ArrayList;

import programas_java.games.chess.ChessBoard;
import programas_java.games.chess.Square;

public class Bishop extends Piece {
    
    public Bishop(String color, String type) {

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
