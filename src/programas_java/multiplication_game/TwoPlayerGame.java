package multiplication_game;

public class TwoPlayerGame extends Game {

    public void gameCycle() {

        String[] playersNames = namePlayers();

        String playerOneName;
        String playerTwoName;
        
        playerOneName = playersNames[0];
        playerTwoName = playersNames[1];

        Player playerOne = new Player(playerOneName, 1);
        Player playerTwo = new Player(playerTwoName, 2);

        Player[] players = {playerOne, playerTwo};

        do {

            for (Player player : players) {

                playerTurn(player);

            }

            System.out.println(playerOne.getName() + RESPONDS + playerOne.isState() + ".");
            System.out.println(playerTwo.getName() + RESPONDS + playerTwo.isState() + ".");
            System.out.println();

            if (Boolean.TRUE.equals(playerOne.isState()) && Boolean.FALSE.equals(playerTwo.isState())) {

                System.out.println(playerTwo.getName() + LOSES);

            } else if (Boolean.FALSE.equals(playerOne.isState()) && Boolean.TRUE.equals(playerTwo.isState())) {

                System.out.println(playerOne.getName() + LOSES);

            }

            System.out.println();
            
        } while (playerOne.isState() == playerTwo.isState());

    }

    // method to name players 1 and 2
    public String[] namePlayers() {

        String player1;
        String player2;

        System.out.print("Enter player 1's name: ");
        player1 = MainGame.SC.nextLine();
        System.out.println();

        System.out.print("Enter player 2's name: ");
        player2 = MainGame.SC.nextLine();
        System.out.println();

        String[] players = {player1, player2};
        return players;
    
    }
}
