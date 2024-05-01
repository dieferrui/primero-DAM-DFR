package bingo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main_classes.*;

public class BingoGame extends Game {

    private static Scanner scb = new Scanner(System.in);

    public BingoGame() {
        // Nothing to see here
    }

    public void gameCycle(int numPlayers) {

        ArrayList<Player> players = makePlayersAsList(numPlayers);
        boolean playerFinish = Boolean.FALSE;

        for (Player player : players) {

            player.setCarton(new Carton());

        }

        do {

            for (Player player : players) {

                System.out.println(player.getCarton().toString());
    
            }

            playerFinish = true;

        } while (!playerFinish);

    }

    @Override
    public ArrayList<Player> makePlayersAsList(int numPlayers) {

        ArrayList<Player> players = new ArrayList<>(numPlayers);

        for (int i = 1; i <= numPlayers; i++) {

            int playerAge = 0;
            String nameOfPlayer;
            String playerCity;

            do {

                System.out.print("Enter player " + i + "'s name: ");
                nameOfPlayer = scb.nextLine();
                
                try {

                    System.out.print("Enter player " + i + "'s age: ");
                    playerAge = scb.nextInt();

                } catch (InputMismatchException e) {

                    System.out.println("That's not an age.");

                } finally {

                    scb.nextLine();

                }

                System.out.print("Enter player " + i + "'s city: ");
                playerCity = scb.nextLine();

                System.out.println();

                if (playerAge < 18) {

                    System.out.println("Age of player is not set or too low.");
                    System.out.println();

                }

            } while (playerAge < 18);
            
            Player player = new Player(nameOfPlayer, i, playerCity, playerAge);
            players.add(player);

        }

        return players;
    }
}
