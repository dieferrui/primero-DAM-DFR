package programas_java.games.chess;

import chess.pieces.*;

public class ChessBoard {

    Square[][] board = new Square[8][8];
    private final String WHITE = "white";
    private final String BLACK = "black";
    private final String PAWN = "pawn";
    private final String TOWER = "tower";
    private final String HORSE = "horse";
    private final String BISHOP = "bishop";
    private final String QUEEN = "queen";
    private final String KING = "king";
    
    private void prepareBoard() {

        for (int fil = 0; fil < 8; fil++) {

            for (int col = 0; col < 8; col++) {

                char idLetra = (char)('A' + col);
                int idNum = 8 - fil;

                String idCompleta = "" + idLetra + idNum;
                board[fil][col] = new Square(idCompleta);

                Piece startPiece = generatePiece(fil, col);

            }
        }
    }

    private Piece generatePiece(int fil, int col) {

        Piece pieceReturned;

        if (fil == 1) {
            
            pieceReturned = new Peon(WHITE, PAWN);

        } else if (fil == 0) {

            switch(col) {

                case 0, 7: pieceReturned = new Tower(WHITE, TOWER); break;
                case 1, 6: pieceReturned = new Horse(WHITE, HORSE); break;
                case 2, 5: pieceReturned = new Bishop(WHITE, BISHOP); break;
                case 3: pieceReturned = new Queen(WHITE, QUEEN); break;
                case 4: pieceReturned = new King(WHITE, KING); break;

            }

        } else if (fil == 6) {

            pieceReturned = new Peon(BLACK, PAWN);

        } else if (fil == 7) {

            switch(col) {

                case 0, 7: pieceReturned = new Tower(BLACK, TOWER); break;
                case 1, 6: pieceReturned = new Horse(BLACK, HORSE); break;
                case 2, 5: pieceReturned = new Bishop(BLACK, BISHOP); break;
                case 3: pieceReturned = new Queen(BLACK, QUEEN); break;
                case 4: pieceReturned = new King(BLACK, KING); break;

            }
        }

        return pieceReturned;
    }
}
