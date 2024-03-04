package programas_java.games.chess;

import programas_java.games.*;
import programas_java.games.chess.pieces.*;
import java.util.ArrayList;

import java.util.Scanner;

public class ChessGame extends Game {
    
    protected static Scanner scc = new Scanner(System.in);
    private boolean isQuantum;

    public ChessGame() {
        // Empty constructor
    }

    public void gameSelection(boolean isQuantum) {

        this.isQuantum = isQuantum;
        this.gameCycle(2);

    }

    public void gameCycle(int numPlayers) {

        int kingNumber;

        Player[] players = makePlayers(numPlayers);
        players[0].setColor("white");
        players[1].setColor("black");

        ChessBoard board = new ChessBoard();
        board.prepareBoard();

        do {
            
            for (Player player : players) {

                board.paintBoard();
                playerTurn(player, board);
                kingNumber = checkForKings();

                if (kingNumber < 2) {
                    break;
                }

            }

        } while (kingNumber >= 2);

    }

    private void playerTurn(Player player, ChessBoard board) {

        String selectedPiece;

        System.out.println(player.getName() + "'s turn...\n");
        System.out.println("Select piece to move (type exact square where piece is):");

        Square[] pieces = checkPieces(player, board);

        for (Square square : pieces) {

            System.out.printf("%s in square %s\n", square.getPiece().getType(), square.toString());

        }

        selectedPiece = scc.nextLine();

        for (Square square : pieces) {

            if (selectedPiece.equals(square.getSquareID())) {

                movePiece(square, board);
            }
        }
        
        // Seguir aquí
    }

    private Square[] checkPieces(Player player, ChessBoard board) {

        ArrayList<Square> validPieces = new ArrayList<>();
        Square[] returnedPieces;

        for (int fil = 0; fil < 8; fil++) {

            for (int col = 0; col < 8; col++) {

                if (board.boardLayout[fil][col].getPiece().getColor().equals(player.getColor())) {

                    validPieces.add(board.boardLayout[fil][col]);

                }
            }
        }

        returnedPieces = (Square[])validPieces.toArray();
        return returnedPieces;
    }

    private void movePiece(Square square, ChessBoard board) {

        
    }

    public static Scanner getScc() {
        return scc;
    }

    public boolean isQuantum() {
        return isQuantum;
    }

    public void setQuantum(boolean isQuantum) {
        this.isQuantum = isQuantum;
    }
    
}
