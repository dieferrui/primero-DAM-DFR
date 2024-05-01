package main_classes;
import java.util.Scanner;

import chess.ChessGame;
import hangman.HangmanGame;
import multiplicaton.MultiplicationGame;
import bingo.BingoGame;

public class MainGame {

    protected static final Scanner SC = new Scanner(System.in);
    
    public static void main(String[] args) {

        String mainSelect;

        do {
            
            System.out.println("Welcome to the Game selection screen.");
            System.out.println("What game would you like to play?\n1. Multiplication Game\n"
                            + "2. Hangman\n3. Chess\n4. Bingo\n5. Exit");
            mainSelect = SC.nextLine();

            switch (mainSelect) {

                case "1": multiplyGame(); break;
                case "2": hangmanGame(); break;
                case "3": chessGame(); break;
                case "4": bingoGame(); break;
                default: break;
            }


        } while (!mainSelect.equals("3"));

        SC.close();
        MultiplicationGame.getScm().close();
        HangmanGame.getSch().close();
        ChessGame.getScc().close();
    }

    public static void multiplyGame() {

        String select;
        String rulesetPath = "primero-DAM-DFR\\src\\programas_java\\multiplication_game\\MultiRuleset.txt";
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
        String rulesetPath = "primero-DAM-DFR\\src\\programas_java\\multiplication_game\\HangsRuleset.txt";
        HangmanGame game = new HangmanGame();

        do {

            System.out.println("Hangman");
            System.out.println("Choose game mode:\n1. Head to Head\n2. Three Dead Men\n3. Four Horsemen\n4. Rules\n5. Exit");

            select = SC.nextLine();

            switch (select) {

                case "1": game.gameCycle(2); break;
                case "2": game.gameCycle(3); break;
                case "3": game.gameCycle(4); break;
                case "4": Lector.openFile(rulesetPath); break;
                default: break;
            }

        } while (!select.equals("5"));
    }

    public static void chessGame() {

        String select;
        String rulesetPath = "primero-DAM-DFR\\src\\programas_java\\multiplication_game\\ChessRuleset.txt";
        ChessGame game = new ChessGame();

        do {

            System.out.println("Chess");
            System.out.println("Choose game mode:\n1. Classic\n2. Quantum (in progress)\n3. Rules\n4. Exit");

            select = SC.nextLine();

            switch (select) {

                case "1": game.gameSelection(false); break;
                case "2": game.gameSelection(true); break;
                case "3": Lector.openFile(rulesetPath); break;
                default: break;
            }

        } while (!select.equals("4"));
    }

    public static void bingoGame() {

        String select;
        BingoGame game = new BingoGame();

        do {

            System.out.println("Bingo");
            System.out.println("Choose game mode:\n1. Two players\n2. Three players\n3. Four players\n4. Exit");

            select = SC.nextLine();

            switch (select) {

                case "1": game.gameCycle(2); break;
                case "2": game.gameCycle(3); break;
                case "3": game.gameCycle(4); break;
                default: break;
            }

        } while (!select.equals("5"));
    }
    
}
