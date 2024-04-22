package chess;

import chess.pieces.*;

public class ChessBoard {

    public ChessBoard() {
        // Empty constructor
    }

    public Square[][] boardLayout = new Square[8][8];

    private static final String WHITE = "white";
    private static final String BLACK = "black";
    private static final String PAWN = "pawn";
    private static final String TOWER = "tower";
    private static final String HORSE = "horse";
    private static final String BISHOP = "bishop";
    private static final String QUEEN = "queen";
    private static final String KING = "king";
    
    public void prepareBoard() {

        for (int fil = 0; fil < 8; fil++) {

            for (int col = 0; col < 8; col++) {

                char idLetra = (char)('A' + col);
                int idNum = 8 - fil;

                String idCompleta = "" + idLetra + idNum;
                boardLayout[fil][col] = new Square(idCompleta, fil, col);

                Piece startPiece = generatePiece(fil, col);
                boardLayout[fil][col].setPiece(startPiece);

            }
        }
    }

    private Piece generatePiece(int fil, int col) {

        Piece pieceReturned = null;

        if (fil == 1) {
            
            pieceReturned = new Peon(WHITE, PAWN);
            pieceReturned.setSymbol("♙");

        } else if (fil == 0) {

            switch(col) {

                case 0, 7: 
                    pieceReturned = new Tower(WHITE, TOWER);
                    pieceReturned.setSymbol("♖");
                    break;
                case 1, 6: 
                    pieceReturned = new Horse(WHITE, HORSE);
                    pieceReturned.setSymbol("♘");
                    break;
                case 2, 5: 
                    pieceReturned = new Bishop(WHITE, BISHOP);
                    pieceReturned.setSymbol("♗");
                    break;
                case 3: 
                    pieceReturned = new Queen(WHITE, QUEEN);
                    pieceReturned.setSymbol("♕");
                    break;
                case 4: 
                    pieceReturned = new King(WHITE, KING);
                    pieceReturned.setSymbol("♔");
                    break;

            }

        } else if (fil == 6) {

            pieceReturned = new Peon(BLACK, PAWN);
            pieceReturned.setSymbol("♟︎");

        } else if (fil == 7) {

            switch(col) {

                case 0, 7: 
                    pieceReturned = new Tower(BLACK, TOWER);
                    pieceReturned.setSymbol("♜");
                    break;
                case 1, 6: 
                    pieceReturned = new Horse(BLACK, HORSE);
                    pieceReturned.setSymbol("♞");
                    break;
                case 2, 5: 
                    pieceReturned = new Bishop(BLACK, BISHOP);
                    pieceReturned.setSymbol("♝");
                    break;
                case 3: 
                    pieceReturned = new Queen(BLACK, QUEEN);
                    pieceReturned.setSymbol("♛");
                    break;
                case 4: 
                    pieceReturned = new King(BLACK, KING);
                    pieceReturned.setSymbol("♚");
                    break;

            }
        }

        return pieceReturned;
    }

    public void displayBoard() {

        System.out.println("    A  B  C  D  E  F  G  H");
        System.out.println(" +--------------------------+");

        for (int fil = 0; fil < 8; fil++) {

            System.out.print(8 - fil + " |");

            for (int col = 0; col < 8; col++) {

                if (boardLayout[fil][col].getPiece() == null) {

                    System.out.print(" . ");

                } else {

                    System.out.print(" " + boardLayout[fil][col].getPiece().getSymbol() + " ");
                }
            }

            System.out.println("| " + (8 - fil));

        }

        System.out.println(" +--------------------------+");
        System.out.println("    A  B  C  D  E  F  G  H");
    }
}
