package programas_java.multiplication_game;

import java.util.Random;

public class HangmanGame extends Game {
    
    private Random random = new Random();

    public HangmanGame() {
        // Needs an instance, don't need params
    }

    public void gameCycle(int numPlayers) {

        Player[] players = makePlayers(numPlayers);
        int rounds = 1;
        Palabra palabra = selectPalabra();
        
        for (Player player : players) {

            player.setLives(6);

        }

        do {

            System.out.println("Round " + rounds);

            for (Player player : players) {

                showPalabra(palabra);
                playerTurn(player, palabra);

            }

            rounds++;
            
        } while (players.length > 1 || palabra.isSolved());

    }

    public Palabra selectPalabra() {

        System.out.println("Elija la temática de la palabra:\n1. Grupos musicales\n2. Videojuegos"
        + "\n3. Animes\n4. Tanques");
        String theme = MainGame.SC.nextLine();
        Palabra word;

        switch (theme) {

            case "1": word = new Palabra("Grupo"); break;
            case "2": word = new Palabra("Juego"); break;
            case "3": word = new Palabra("Anime"); break;
            case "4": word = new Palabra("Tanque"); break;
            default: word = new Palabra("Tanque"); break;

        }

        return word;

    }

    public String showPalabra(Palabra palabra) {

        
    }
}
