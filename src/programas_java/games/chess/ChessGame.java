package programas_java.games.chess;

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

        Player[] players = makePlayers(numPlayers);

    }
}
