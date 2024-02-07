package programas_java.multiplication_game;

public class ThreePlayerGame extends Game {

    public void gameCycle() {

        String[] playersNames = namePlayers();
        Boolean[] states;
        
        String playerOneName = playersNames[0];
        String playerTwoName = playersNames[1];
        String playerThreeName = playersNames[2];

        Player playerOne = new Player(playerOneName, 1);
        Player playerTwo = new Player(playerTwoName, 2);
        Player playerThree = new Player(playerThreeName, 3);

        Player[] players = {playerOne, playerTwo, playerThree};

        do {

            for (Player player : players) {

                playerTurn(player);

            }

            System.out.println(playerOne.getName() + RESPONDS + playerOne.isState() + ".");
            System.out.println(playerTwo.getName() + RESPONDS + playerTwo.isState() + ".");
            System.out.println(playerThree.getName() + RESPONDS + playerThree.isState() + ".\n");

            states = responseChecker(playerOne, playerTwo, playerThree);
            
        } while (states[0].equals(states[1]) && states[0].equals(states[2]));
        
    }

    // method to name players 1, 2 and 3
    public String[] namePlayers() {

        String player1;
        String player2;
        String player3;

        System.out.print("Enter player 1's name: ");
        player1 = MainGame.SC.nextLine();
        System.out.println();

        System.out.print("Enter player 2's name: ");
        player2 = MainGame.SC.nextLine();
        System.out.println();

        System.out.print("Enter player 3's name: ");
        player3 = MainGame.SC.nextLine();
        System.out.println();

        String[] players = {player1, player2, player3};
        return players;

    }

    public Boolean[] responseChecker(Player playerOne, Player playerTwo, Player playerThree) {

        if (playerOne.isState() && playerTwo.isState()) {

            if (!playerThree.isState()) {

                System.out.println(playerThree.getName() + LOSES);

            }

        } else if (playerOne.isState() && !playerTwo.isState()) {

            if (playerThree.isState()) {

                System.out.println(playerTwo.getName() + LOSES);

            } else {

                System.out.println(playerTwo.getName() + AND + playerThree.getName() + LOSE);

            }
            
        } else if (!playerOne.isState() && playerTwo.isState()) {

            if (playerThree.isState()) {
                
                System.out.println(playerOne.getName() + LOSES);

            } else {

                System.out.println(playerOne.getName() + AND + playerThree.getName() + LOSE);

            }

        } else if (!playerOne.isState() && !playerTwo.isState()) {

            if (playerThree.isState()) {

                System.out.println(playerOne.getName() + AND + playerTwo.getName() + LOSE);

            }
        }

        System.out.println();

        Boolean[] states = {playerOne.isState(), playerTwo.isState(), playerThree.isState()};
        return states;
    }
}
