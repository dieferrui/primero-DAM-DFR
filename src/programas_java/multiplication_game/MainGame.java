package multiplication_game;

import java.util.Scanner;

public class MainGame {

    protected static final Scanner SC = new Scanner(System.in);
    
    public static void main(String[] args) {

        String select;
        String rulesetPath = "MultiplicationGame\\Ruleset.txt";
        TwoPlayerGame game2 = new TwoPlayerGame();
        ThreePlayerGame game3 = new ThreePlayerGame();

        do {

            System.out.println("Multiplication Game");
            System.out.println("Choose game mode:\n1. Versus\n2. Triple match\n3. Rules\n4. Exit");

            select = SC.nextLine();

            switch (select) {

                case "1": game2.gameCycle(); break;
                case "2": game3.gameCycle(); break;
                case "3": Lector.openFile(rulesetPath); break;
                default: break;
            }

        } while (!select.equals("4"));

        SC.close();

    }
}
