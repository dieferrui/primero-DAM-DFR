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

    // Método necesario para elegir el tipo de juego
    public void gameSelection(boolean isQuantum) {

        this.isQuantum = isQuantum;
        this.gameCycle(2);

    }

    // Método para ciclo de juego
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

    // Método del turno del jugador
    private void playerTurn(Player player, ChessBoard board) {

        String selectedPiece;

        System.out.println(player.getName() + "'s turn...\n");
        System.out.println("Select piece to move (type exact square where piece is):");

        Square[] pieces = checkPieces(player, board);

        for (Square square : pieces) {

            System.out.printf("%s in square %s%n", square.getPiece().getType(), square.toString());

        }

        selectedPiece = scc.nextLine();

        for (Square square : pieces) {

            if (selectedPiece.equals(square.getSquareID())) {

                movePiece(square, board);
            }
        }
        
        // TODO finalizar el método
    }

    // Método para visualizar qué piezas puede mover el jugador
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

    // Método para elegir a qué casilla se desea mover la pieza seleccionada
    private int movePiece(Square square, ChessBoard board) {

        ArrayList<String> validMoves = square.getPiece().movePiece(square, board);
        int localMoves = 0;

        if (validMoves.isEmpty()) {

            System.out.println("This piece can't move.");

        } else {

            localMoves++;

            System.out.println("Select square to move: ");

            for (String move : validMoves) {

                System.out.printf("Move %s to square %s%n", square.getPiece().getType(), move);

            }

            // TODO finalizar el método

        }

        return localMoves;

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
