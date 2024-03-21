package chess.pieces;

import chess.*;
import java.util.ArrayList;

public class Peon extends Piece {
    
    public Peon(String color, String type) {

        super(color, type);
        
    }

    public ArrayList<Square> movePiece(Square square, ChessBoard board) {

        ArrayList<Square> validMoves;
        int filPos = square.getFil();
        int colPos = square.getCol();

        if (this.getColor().equals("white")) {

            validMoves = moveIfWhite(square, board, filPos, colPos);

        } else {

            validMoves = moveIfBlack(square, board, filPos, colPos);

        }

        for (int i = 0; i < validMoves.size(); i++) {

            if (validMoves.get(i).getFil() < 0 || validMoves.get(i).getCol() < 0) {

                validMoves.remove(validMoves.get(i));

            }
        }

        return validMoves;
    }

    private ArrayList<Square> moveIfWhite(Square square, ChessBoard board, int filPos, int colPos) {

        ArrayList<Square> validMoves = new ArrayList<>();

        if (square.getPiece().getNumberOfMoves() < 1 && board.boardLayout[filPos + 2][colPos].getPiece() == null &&
            board.boardLayout[filPos + 1][colPos].getPiece() == null) {

            Square initialMove = board.boardLayout[filPos + 2][colPos];
            validMoves.add(initialMove);

        }

        try {

            if (board.boardLayout[filPos + 1][colPos].getPiece() == null) {

                Square advance = board.boardLayout[filPos + 1][colPos];
                validMoves.add(advance);

            }
        
        } catch (ArrayIndexOutOfBoundsException e) {

            // Square doesn't get added to the Array of moves
        }

        try {

            if (board.boardLayout[filPos + 1][colPos - 1].getPiece().getColor().equals("black")) {

                Square eatLeft = board.boardLayout[filPos + 1][colPos - 1];
                validMoves.add(eatLeft);

            }

        } catch (ArrayIndexOutOfBoundsException e) {

            // Square doesn't get added to Array of moves

        } catch (NullPointerException e) {

            // Ignore null squares

        }

        try {
            
            if (board.boardLayout[filPos + 1][colPos + 1].getPiece().getColor().equals("black")) {

                Square eatRight = board.boardLayout[filPos + 1][colPos + 1];
                validMoves.add(eatRight);

            }
        
        } catch (ArrayIndexOutOfBoundsException e) {

            // Square doesn't get added to Array of moves

        } catch (NullPointerException e) {

            // Ignore null squares

        }

        return validMoves;
    }

    private ArrayList<Square> moveIfBlack(Square square, ChessBoard board, int filPos, int colPos) {

        ArrayList<Square> validMoves = new ArrayList<>();

        if (square.getPiece().getNumberOfMoves() < 1 && board.boardLayout[filPos - 2][colPos].getPiece() == null &&
            board.boardLayout[filPos - 1][colPos].getPiece() == null) {

            Square initialMove = board.boardLayout[filPos - 2][colPos];
            validMoves.add(initialMove);

        }

        try {
            
            if (board.boardLayout[filPos - 1][colPos].getPiece() == null) {

                Square advance = board.boardLayout[filPos - 1][colPos];
                validMoves.add(advance);

            }

        } catch (ArrayIndexOutOfBoundsException e) {

            // Square doesn't get added to Array of moves

        } catch (NullPointerException e) {

            // Ignore null squares

        }

        try {

            if (board.boardLayout[filPos - 1][colPos - 1].getPiece().getColor().equals("white")) {

                Square eatLeft = board.boardLayout[filPos - 1][colPos - 1];
                validMoves.add(eatLeft);

            }
        
        } catch (ArrayIndexOutOfBoundsException e) {

            // Square doesn't get added to Array of moves

        } catch (NullPointerException e) {

            // Ignore null squares

        }

        try {

            if (board.boardLayout[filPos - 1][colPos + 1].getPiece().getColor().equals("white")) {

                Square eatRight = board.boardLayout[filPos - 1][colPos + 1];
                validMoves.add(eatRight);

            }

        } catch (ArrayIndexOutOfBoundsException e) {

            // Square doesn't get added to Array of moves

        } catch (NullPointerException e) {

            // Ignore null squares

        }

        return validMoves;
    }
}
