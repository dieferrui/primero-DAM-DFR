package programas_java.multiplication_game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class MultiplicationGame {

    private Random random = new Random();
    private static final String LOSES = " loses.";
    private static final String LOSE = " lose.";
    private static final String AND = " and ";
    private static final String RESPONDS = "'s response was ";

    public MultiplicationGame() {
        // Game needs an instance, but doesn't need any parameters
    }

    public void gameCycle(int numPlayers) {

        ArrayList<Boolean> trueArray = new ArrayList<>();
        ArrayList<Boolean> falseArray = new ArrayList<>();
        
        for (int i = 0; i < numPlayers; i++) {

            trueArray.add(true);
            falseArray.add(false);

        }

        Player[] players = makePlayers(numPlayers);
        ArrayList<Boolean> states = new ArrayList<>(numPlayers);

        do {

            for (Player player : players) {

                playerTurn(player);
                System.out.println(player.getName() + RESPONDS + player.isState() + ".");
                System.out.println();
                states.add(player.isState());

            }
            
        } while (deepEquals(trueArray, states) || deepEquals(falseArray, states));
        
        compareResults(players, states);
        System.out.println();
    }

    // Method that runs each player's turn and sets their state based on answer
    public void playerTurn(Player player) {

        int answer = 0;
        player.setState(true);

        System.out.println(player.getName() + "'s turn...");

        int[] values = generateValues();

        String problem = askValues(values);

        System.out.println(problem);
        
        // Catches any input that isn't an int and punishes the funny player with a wrong answer
        try {
            
            answer = MainGame.SC.nextInt();
            MainGame.SC.nextLine();

        } catch (InputMismatchException e) {

            MainGame.SC.next();
            player.setState(false);
            System.out.println("Wrong answer, chucklenuts...\n");

        }

        // If the player did respond with an int, runs the checking
        if (player.isState()) {

            if (values[2] == answer) {

                player.setState(true);
                System.out.println("Correct\n");
                MainGame.SC.reset();
        
            } else {
        
                player.setState(false);
                System.out.println("Wrong, answer was " + values[2] + ".\n");
                MainGame.SC.reset();
        
            }
        }
    }

    // Method that generates the values required for the multiplications
    public int[] generateValues() {

        int value1;
        int value2;
        int result;

        value1 = random.nextInt(50) + 1;
        value2 = random.nextInt(50) + 1;
        result = value1 * value2;

        return new int[]{value1, value2, result};

    }

    // Method to generate the string each time a player is asked to multiply
    public String askValues(int[] values) {

        StringBuilder question = new StringBuilder();
        
        question.append("Calculate: ");
        question.append(values[0] + " x " + values[1] + "...");

        return question.toString();

    }

    // method to generate players
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

    // Method to deep compare ArrayLists
    public boolean deepEquals(List<Boolean> list1, List<Boolean> list2) {

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

    public void compareResults(Player[] players, List<Boolean> states) {

        HashSet<Object> hashStates = new HashSet<>(states);

        if (hashStates.size() > 1) {

            for (Player player : players) {

                if (!player.isState()) {
    
                    System.out.println(player.getName() + " has lost the game.");
    
                } else {

                    System.out.println(player.getName() + " has won the game.");

                }
            }
        }

    }

}
