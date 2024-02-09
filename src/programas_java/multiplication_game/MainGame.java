package programas_java.multiplication_game;

import java.util.Scanner;

public class MainGame {

    protected static final Scanner SC = new Scanner(System.in);
    
    public static void main(String[] args) {

        String select;
        String rulesetPath = "src\\programas_java\\multiplication_game\\Ruleset.txt";
        MultiplicationGame game = new MultiplicationGame();

        do {

            System.out.println("Multiplication Game");
            System.out.println("Choose game mode:\n1. One on One\n2. Threesome\n3. Rules\n4. Exit");

            select = SC.nextLine();

            switch (select) {

                case "1": game.gameCycle(2); break;
                case "2": game.gameCycle(3); break;
                case "3": Lector.openFile(rulesetPath); break;
                default: break;
            }

        } while (!select.equals("4"));

        SC.close();

    }
}
