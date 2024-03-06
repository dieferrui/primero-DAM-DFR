package programas_java.games.chess.pieces;

import programas_java.games.chess.*;
import java.util.ArrayList;

public class Peon extends Piece {
    
    public Peon(String color, String type) {

        super(color, type);
        
    }

    public ArrayList<String> movePiece(Square square, ChessBoard board) {

        int filPos = square.getFil();
        int colPos = square.getCol();
        ArrayList<String> validMoves;

        if (this.getColor().equals("white")) {

            validMoves = moveIfWhite(square, board, filPos, colPos);

        } else {

            validMoves = moveIfBlack(square, board, filPos, colPos);

        }

        return validMoves;
    }

    private ArrayList<String> moveIfWhite(Square square, ChessBoard board, int filPos, int colPos) {

        ArrayList<String> validMoves = new ArrayList<>();

        if (square.getPiece().getNumberOfMoves() < 1 && (board.boardLayout[filPos + 2][colPos].getPiece() == null)) {

            String initialMove = board.boardLayout[filPos + 2][colPos].getSquareID();
            validMoves.add(initialMove);

        }

        if (board.boardLayout[filPos + 1][colPos].getPiece() == null) {

            String advance = board.boardLayout[filPos + 1][colPos].getSquareID();
            validMoves.add(advance);

        }

        if (board.boardLayout[filPos + 1][colPos - 1].getPiece() != null) {

            String eatLeft = board.boardLayout[filPos + 1][colPos - 1].getSquareID();
            validMoves.add(eatLeft);

        }

        if (board.boardLayout[filPos + 1][colPos + 1].getPiece() != null) {

            String eatRight = board.boardLayout[filPos + 1][colPos + 1].getSquareID();
            validMoves.add(eatRight);

        }

        return validMoves;
    }

    private ArrayList<String> moveIfBlack(Square square, ChessBoard board, int filPos, int colPos) {

        ArrayList<String> validMoves = new ArrayList<>();

        if (square.getPiece().getNumberOfMoves() < 1 && (board.boardLayout[filPos - 2][colPos].getPiece() == null)) {

            String initialMove = board.boardLayout[filPos - 2][colPos].getSquareID();
            validMoves.add(initialMove);

        }

        if (board.boardLayout[filPos - 1][colPos].getPiece() == null) {

            String advance = board.boardLayout[filPos - 1][colPos].getSquareID();
            validMoves.add(advance);

        }

        if (board.boardLayout[filPos - 1][colPos - 1].getPiece() != null) {

            String eatLeft = board.boardLayout[filPos - 1][colPos - 1].getSquareID();
            validMoves.add(eatLeft);

        }

        if (board.boardLayout[filPos - 1][colPos + 1].getPiece() != null) {

            String eatRight = board.boardLayout[filPos - 1][colPos + 1].getSquareID();
            validMoves.add(eatRight);

        }

        return validMoves;
    }
}
