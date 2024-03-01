package programas_java.games;

import java.util.ArrayList;

public abstract class Game {

    // Main Game-cycle method
    public abstract void gameCycle(int numPlayers);

    // Method to generate players in an array
    public Player[] makePlayers(int numPlayers) {

        Player[] players = new Player[numPlayers];

        for (int i = 1; i <= numPlayers; i++) {

            System.out.print("Enter player " + i + "'s name: ");
            String nameOfPlayer = MainGame.SC.nextLine();
            System.out.println();

            Player player = new Player(nameOfPlayer, i);
            players[i - 1] = player;

        }

        return players;
    }

    // Method to generate players in an arrayList
    public ArrayList<Player> makePlayersAsList(int numPlayers) {

        ArrayList<Player> players = new ArrayList<>(numPlayers);

        for (int i = 1; i <= numPlayers; i++) {

            System.out.print("Enter player " + i + "'s name: ");
            String nameOfPlayer = MainGame.SC.nextLine();
            System.out.println();

            Player player = new Player(nameOfPlayer, i);
            players.add(player);

        }

        return players;
    }

}