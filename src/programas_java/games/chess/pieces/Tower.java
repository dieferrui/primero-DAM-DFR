package programas_java.games.chess.pieces;

import java.util.ArrayList;

import programas_java.games.chess.ChessBoard;
import programas_java.games.chess.Square;

public class Tower extends Piece {
    
    public Tower(String color, String type) {

        super(color, type);
        
    }

    public ArrayList<Square> movePiece(Square square, ChessBoard board) {

        ArrayList<Square> validMoves;

        validMoves = moveByColor(square, board, square.getPiece().getColor());

        return validMoves;
    }

    public ArrayList<Square> moveByColor(Square square, ChessBoard board, String color) {

        ArrayList<Square> validMoves = new ArrayList<>();
        String targetColor;
        int filPos = square.getFil();
        int colPos = square.getCol();
        
        if (color.equals("white")) {

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
        for (int i = (filPos + 1); i <= 8; i++) {

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
        for (int i = (colPos + 1); i <= 8; i++) {

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

        return validMoves;
    }
}
