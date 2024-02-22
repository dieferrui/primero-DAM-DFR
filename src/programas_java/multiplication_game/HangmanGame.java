package programas_java.multiplication_game;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame extends Game {
    
    private Random random = new Random();
    protected static Scanner sch = new Scanner(System.in);

    public HangmanGame() {
        // Needs an instance, don't need params
    }

    public void gameCycle(int numPlayers) { // TODO revisar el ciclo cuando se acaben las demás clases

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

                player.showHangman();
                playerTurn(player, palabra, palabraProgreso);

            }

            rounds++;
            
        } while (players.length > 1 || palabra.isSolved());

    }

    public Palabra selectPalabra() {

        System.out.println("Elija la temática de la palabra:\n1. Grupos musicales\n2. Videojuegos"
        + "\n3. Animes\n4. Tanques");
        String theme = sch.nextLine();
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

        System.out.println("Adivina la palabra:\n" + palabraProgreso);
        System.out.println("¿Qué quieres hacer en tu turno, " + player.getName() + "?");
        System.out.println("1. Elegir carácter\n2. Resolver");
        String hangMenu = sch.nextLine();

        switch (hangMenu) {

            int caseInPoint;

            case "1":

                do {
                    
                    System.out.println("Elige carácter: ");
                    String letraElegida = sch.nextLine();
                    
                    caseInPoint = tryLetter(letraElegida, palabra, palabraProgreso);

                    executeResult(player, letraElegida, caseInPoint, palabraProgreso, palabra);

                } while (caseInPoint == 1);
        }

    }

    public int tryLetter(String letraElegida, Palabra palabra, String palabraProgreso) {

        int caseHappen;

        if (letraElegida.length() > 1) {

            System.out.println("Has introducido más de un carácter, inténtalo de nuevo.");
            caseHappen = 1;

        } else if (palabraProgreso.contains(letraElegida)) {

            System.out.println("Este carácter ya es visible.");
            caseHappen = 2;

        } else if (palabra.getPalabra().contains(letraElegida)) {

            System.out.println("El carácter está en la palabra oculta.");
            caseHappen = 3;

        } else {

            System.out.println("El carácter no está en la palabra oculta.");
            caseHappen = 4;

        }

        return caseHappen;

    }

    public void executeResult(Player player, String letraElegida, int caseInPoint, String palabraProgreso, Palabra palabra) {

        switch (caseInPoint) {

            case 1:
                
                break;

            case 2:

                player.setLives(player.getLives() - 1);

            case 3:

                for (int i = 0; i < palabraProgreso.length(); i++) {

                    if (palabra.getPalabra().charAt(i) == letraElegida.charAt(0)) {

                        palabraProgreso.replace(palabraProgreso.charAt(i), letraElegida.charAt(0));

                    }

                }
            
            case 4:

                player.setLives(player.getLives() - 1);

            default:
                break;

        }

    }
    
}
