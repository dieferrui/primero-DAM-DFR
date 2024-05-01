package bingo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import main_classes.*;

public class BingoGame extends Game {

    private static Scanner scb = new Scanner(System.in);
    private Random random = new Random();
    
    public BingoGame() {
        // Nothing to see here
    }

    public void gameCycle(int numPlayers) {

        ArrayList<Player> players = makePlayersAsList(numPlayers);
        Set<Integer> numEscogidos = new HashSet<>();

        boolean playerFinish = Boolean.FALSE;
        int numberBall = 1;
        int numero;

        for (Player player : players) {

            player.setCarton(new Carton());
            player.setCartonCopy(player.getCarton());

        }

        do {

            System.out.println("Ball number " + numberBall);

            do {

                numero = random.nextInt(91);

                if (numero == 0) {
                    numero = 1;
                }

            } while (numEscogidos.contains(numero));

            System.out.println("-- " + numero + " --\n");
            numEscogidos.add(numero);

            for (Player player : players) {

                player.getCarton().setFila1(contieneValor(player.getCarton().getFila1(), numero, player));
                player.getCarton().setFila2(contieneValor(player.getCarton().getFila2(), numero, player));
                player.getCarton().setFila3(contieneValor(player.getCarton().getFila3(), numero, player));

                System.out.println(player.getName() + "'s carton:");
                System.out.println(player.getCarton().toString());

                try {

                    Thread.sleep(2000);

                } catch (InterruptedException e) {

                    e.printStackTrace();
                    
                }

                if (player.getCarton().getAciertos() >= 15) {

                    playerFinish = Boolean.TRUE;
                    System.out.println(player.showBingoVictor() + "\n");
                    System.out.println(player.getCartonCopy().toString());

                    players.remove(player);

                    for (Player playerLose : players) {

                        System.out.println(playerLose.getName() + "'s carton:\n");
                        System.out.println(playerLose.getCarton().toString() + "\n");
                        System.out.println();

                    }

                }
    
            }

            numberBall++;

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

    public static int[] contieneValor(int[] numeros, int valor, Player player) {

        for (int i = 0; i < numeros.length; i++) {

            if (numeros[i] == valor) {

                numeros[i] = 0;
                player.getCarton().setAciertos(player.getCarton().getAciertos() + 1);

                System.out.println("Number " + valor + " found in " + player.getName() + "'s carton!");

            }
        }

        return numeros;
    }
}
