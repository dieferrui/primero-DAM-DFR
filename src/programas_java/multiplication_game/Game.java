package programas_java.multiplication_game;

import java.util.InputMismatchException;
import java.util.Random;

public abstract class Game {

    protected static final String LOSES = " loses.";
    protected static final String LOSE = " lose.";
    protected static final String AND = " and ";
    protected static final String RESPONDS = "'s response was ";
    
    public abstract String[] namePlayers();

    public abstract void gameCycle();

    // Method that generates the values required for the multiplications
    public int[] generateValues() {

        Random random = new Random();
        int value1;
        int value2;
        int result;

        value1 = random.nextInt(50) + 1;
        value2 = random.nextInt(50) + 1;
        result = value1 * value2;

        int[] values = {value1, value2, result};

        return values;

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
        
            } else {
        
                player.setState(false);
                System.out.println("Wrong\n");
        
            }
        }
    }

    // Method to generate the string each time a player is asked to multiply
    public String askValues(int[] values) {

        StringBuilder question = new StringBuilder();
        
        question.append("Calculate: ");
        question.append(values[0] + " x " + values[1] + "...");

        return question.toString();

    }
}
