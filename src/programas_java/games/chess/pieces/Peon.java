package programas_java.games.chess.pieces;

import programas_java.games.chess.*;
import java.util.ArrayList;

public class Peon extends Piece {
    
    public Peon(String color, String type) {

        super(color, type);
        
    }

    public ArrayList<Square> movePiece(Square square, ChessBoard board) {

        int filPos = square.getFil();
        int colPos = square.getCol();
        ArrayList<Square> validMoves;

        if (this.getColor().equals("white")) {

            validMoves = moveIfWhite(square, board, filPos, colPos);

        } else {

            validMoves = moveIfBlack(square, board, filPos, colPos);

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

        if (board.boardLayout[filPos + 1][colPos].getPiece() == null) {

            Square advance = board.boardLayout[filPos + 1][colPos];
            validMoves.add(advance);

        }

        if (board.boardLayout[filPos + 1][colPos - 1].getPiece() != null) {

            Square eatLeft = board.boardLayout[filPos + 1][colPos - 1];
            validMoves.add(eatLeft);

        }

        if (board.boardLayout[filPos + 1][colPos + 1].getPiece() != null) {

            Square eatRight = board.boardLayout[filPos + 1][colPos + 1];
            validMoves.add(eatRight);

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

        if (board.boardLayout[filPos - 1][colPos].getPiece() == null) {

            Square advance = board.boardLayout[filPos - 1][colPos];
            validMoves.add(advance);

        }

        if (board.boardLayout[filPos - 1][colPos - 1].getPiece() != null) {

            Square eatLeft = board.boardLayout[filPos - 1][colPos - 1];
            validMoves.add(eatLeft);

        }

        if (board.boardLayout[filPos - 1][colPos + 1].getPiece() != null) {

            Square eatRight = board.boardLayout[filPos - 1][colPos + 1];
            validMoves.add(eatRight);

        }

        return validMoves;
    }
}
