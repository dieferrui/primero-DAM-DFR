package programas_java.multiplication_game;

import java.util.Random;
import java.util.ArrayList;

public class HangmanGame extends Game {
    
    private Random random = new Random();

    public HangmanGame() {
        // Needs an instance, don't need params
    }

    public void gameCycle(int numPlayers) {

        Player[] players = makePlayers(numPlayers);
        int rounds = 1;
        Palabra palabra = selectPalabra();
        String palabraProgreso = startProgress(palabra);
        
        for (Player player : players) {

            player.setLives(6);

        }

        do {

            System.out.println("Round " + rounds);

            for (Player player : players) {

                System.out.println("Adivina la palabra:\n" + palabraProgreso);
                playerTurn(player, palabra, palabraProgreso);

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

    public String startProgress(Palabra palabra) {

        int palabraLength = palabra.getPalabra().length();
        ArrayList<Character> occultPalabra = new ArrayList<>();
        String palabro = palabra.toString();

        for (int i = 0; i < palabraLength; i++) {

            char ch = palabro.charAt(i);

            if (ch == ' ') {

                occultPalabra.add(' ');

            } else {

                occultPalabra.add('-');

            }

        }

        return occultPalabra.toString();
    }

    public void playerTurn(Player player, Palabra palabra, String palabraProgreso) {

        // TODO continuar el código
    }
    
}
