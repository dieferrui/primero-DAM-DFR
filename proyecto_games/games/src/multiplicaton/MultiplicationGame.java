package programas_java.games.multiplicaton;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Game;
import Player;
import programas_java.games.*;

public class MultiplicationGame extends Game {

    private Random random = new Random();
    protected static Scanner scm = new Scanner(System.in);

    public MultiplicationGame() {
        // Game needs an instance, but doesn't need any parameters
    }

    public void gameCycle(int numPlayers) {

        ArrayList<Boolean> trueArray = new ArrayList<>();
        ArrayList<Boolean> falseArray = new ArrayList<>();
        int rounds = 1;
        
        for (int i = 0; i < numPlayers; i++) {

            trueArray.add(true);
            falseArray.add(false);

        }

        Player[] players = makePlayers(numPlayers);
        ArrayList<Boolean> states = new ArrayList<>(numPlayers);

        do {

            states.clear();

            System.out.println("Round " + rounds);

            for (Player player : players) {

                playerTurn(player);
                states.add(player.isState());

            }

            rounds++;
            
        } while (deepEquals(trueArray, states) || deepEquals(falseArray, states));
        
        compareResults(players);
        System.out.println();
    }

    // Method that runs each player's turn and sets their state based on answer
    private void playerTurn(Player player) {

        int answer = 0;
        player.setState(true);

        System.out.println(player.getName() + "'s turn...");

        int[] values = generateValues();

        String problem = askValues(values);

        System.out.println(problem);
        
        // Catches any input that isn't an int and punishes the funny player with a wrong answer
        try {
            
            answer = scm.nextInt();
            scm.nextLine();

        } catch (InputMismatchException e) {

            scm.nextLine();
            player.setState(false);
            System.out.println("Wrong answer, chucklenuts...\n");

        }

        // If the player did respond with an int, runs the checking
        if (player.isState()) {

            if (values[2] == answer) {

                player.setState(true);
                System.out.println("Correct.\n");
        
            } else {
                
                player.setState(false);
                System.out.println("Wrong, answer was " + values[2] + ".\n");

            }
        }
    }

    // Method that generates the values required for the multiplications
    private int[] generateValues() {

        int value1;
        int value2;
        int result;

        value1 = random.nextInt(50) + 1;
        value2 = random.nextInt(50) + 1;
        result = value1 * value2;

        return new int[]{value1, value2, result};
    }

    // Method to generate the string each time a player is asked to multiply
    private String askValues(int[] values) {

        StringBuilder question = new StringBuilder();
        
        question.append("Calculate: ");
        question.append(values[0] + " x " + values[1] + "...");

        return question.toString();
    }

    // Method to deep compare ArrayLists
    private boolean deepEquals(List<Boolean> list1, List<Boolean> list2) {

        boolean result = true;
        Object[] array1 = list1.toArray();
        Object[] array2 = list2.toArray();

        for (int i = 0; i < list1.size(); i++) {

            if (!array1[i].equals(array2[i])) {

                result = false;

            }
        }

        return result;
    }


    // Method to compare player's results after a game is finished
    private void compareResults(Player[] players) {

        System.out.println("Game finished.\nResults: ");

        for (Player player : players) {

            if (!player.isState()) {
    
                System.out.println(player.getName() + " has lost the game.");
    
            } else {

                System.out.println(player.getName() + " has won the game.");

            }
        }
    }

    public static Scanner getScm() {
        return scm;
    }

}
