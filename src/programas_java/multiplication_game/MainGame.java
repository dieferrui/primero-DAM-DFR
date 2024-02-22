package programas_java.multiplication_game;

import java.util.Scanner;

public class MainGame {

    protected static final Scanner SC = new Scanner(System.in);
    
    public static void main(String[] args) {

        String mainSelect;

        do {
            
            System.out.println("Welcome to the Game selection screen.");
            System.out.println("What game would you like to play?\n1. Multiplication Game\n"
                            + "2. Hangman\n3. Exit");
            mainSelect = SC.nextLine();

            switch (mainSelect) {

                case "1": multiplyGame(); break;
                case "2": hangmanGame(); break;
                default: break;
            }


        } while (!mainSelect.equals("3"));

        SC.close();
        MultiplicationGame.scm.close();
    }

    public static void multiplyGame() {

        String select;
        String rulesetPath = "src\\programas_java\\multiplication_game\\MultiRuleset.txt";
        MultiplicationGame game = new MultiplicationGame();

        do {

            System.out.println("Multiplication Game");
            System.out.println("Choose game mode:\n1. One by One\n2. Threeplication\n3. Rules\n4. Exit");

            select = SC.nextLine();

            switch (select) {

                case "1": game.gameCycle(2); break;
                case "2": game.gameCycle(3); break;
                case "3": Lector.openFile(rulesetPath); break;
                default: break;
            }

        } while (!select.equals("4"));
    }

    public static void hangmanGame() {

        String select;
        String rulesetPath = "src\\programas_java\\multiplication_game\\HangsRuleset.txt";
        HangmanGame game = new HangmanGame();

        do {

            System.out.println("Hangman");
            System.out.println("Choose game mode:\n1. Head to Head\n2. Three Dead Men\n3. Rules\n4. Exit");

            select = SC.nextLine();

            switch (select) {

                case "1": game.gameCycle(2); break;
                case "2": game.gameCycle(3); break;
                case "3": Lector.openFile(rulesetPath); break;
                default: break;
            }

        } while (!select.equals("4"));
    }
    
}
