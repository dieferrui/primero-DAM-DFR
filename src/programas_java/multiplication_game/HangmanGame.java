package programas_java.multiplication_game;

import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame extends Game {
    
    protected static Scanner sch = new Scanner(System.in);

    public HangmanGame() {
        // Needs an instance, don't need params
    }

    public void gameCycle(int numPlayers) {

        ArrayList<Player> players = makePlayersAsList(numPlayers);
        int rounds = 1;
        Palabra palabra = selectPalabra();
        String palabraProgreso = startProgress(palabra);
        StringBuilder letrasFalsas = new StringBuilder();
        
        for (Player player : players) {

            player.setLives(6);

        }

        do {

            System.out.println("Round " + rounds + "\n");

            for (Player player : players) {

                System.out.println("Turno de " + player.getName());
                player.showHangman();
                System.out.println(letrasFalsas.toString() + "\n");
                playerTurn(player, palabra, palabraProgreso, letrasFalsas);
                player.showHangman();

                if (player.getLives() <= 0) {

                    players.remove(player);
                    System.out.println("Has sido eliminado de la partida.\n");

                }

            }

            if (players.size() == 1 && !palabra.isSolved()) {

                System.out.println("El jugador " + players.get(0).getName() + " gana por eliminación.\n");

            }

            rounds++;
            
        } while (players.size() > 1 || palabra.isSolved());

        System.out.println("Fin del juego.\n");

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
         
        System.out.println();
        return word;

    }

    public String startProgress(Palabra palabra) {

        StringBuilder palabraOculta = new StringBuilder(palabra.getPalabra());
        char spaceChar = ' ';

        for (int i = 0; i < palabraOculta.length(); i++) {

            Character pointedChar = palabraOculta.charAt(i);

            if (!pointedChar.equals(spaceChar)) {

                palabraOculta.setCharAt(i, '-');

            }

        }

        return palabraOculta.toString();

    }

    public void playerTurn(Player player, Palabra palabra, String palabraProgreso, StringBuilder letrasFalsas) {

        System.out.println("Adivina la palabra:\n" + palabraProgreso);
        System.out.println("¿Qué quieres hacer en tu turno, " + player.getName() + "?");
        System.out.println("1. Elegir carácter\n2. Resolver");
        String hangMenu = sch.nextLine();
        int caseInPoint;

        switch (hangMenu) {

            case "1":

                do {
                    
                    System.out.println("Elige carácter: ");
                    String letraElegida = sch.nextLine();
                    letraElegida = letraElegida.toUpperCase();

                    caseInPoint = tryLetter(letraElegida, palabra, palabraProgreso, letrasFalsas);

                    palabraProgreso = executeResult(player, letraElegida, caseInPoint, palabraProgreso, palabra);

                } while (caseInPoint == 1);

                break;

            case "2":
                
                System.out.println("Introduce tu respuesta: ");
                String respuesta = sch.nextLine();

                compararPalabra(respuesta, palabra, player);

                break;

            default:
                break;
            
        }

    }

    public int tryLetter(String letraElegida, Palabra palabra, String palabraProgreso, StringBuilder letrasFalsas) {

        int caseHappen;

        if (letraElegida.length() > 1) {

            System.out.println("Has introducido más de un carácter, inténtalo de nuevo.");
            caseHappen = 1;

        } else if (letrasFalsas.toString().contains(letraElegida)) {

            System.out.println("Este carácter ya es visible.\n"
                                + "Pierdes una vida.\n");
            caseHappen = 2;

        } else if (palabra.getPalabra().contains(letraElegida)) {

            System.out.println("El carácter está en la palabra oculta.");
            caseHappen = 3;

        } else {

            System.out.println("El carácter no está en la palabra oculta.\n"
                                + "Pierdes una vida.\n");

            letrasFalsas.append(letraElegida + ", ");

            caseHappen = 4;

        }

        return caseHappen;

    }

    public String executeResult(Player player, String letraElegida, int caseInPoint, String palabraProgreso, Palabra palabra) {

        switch (caseInPoint) {

            case 1:
                
                break;

            case 2:

                player.setLives(player.getLives() - 1);
                break;

            case 3:

                char[] palabraProgresoArray = palabraProgreso.toCharArray();

                for (int i = 0; i < palabra.getPalabra().length(); i++) {

                    if (palabra.getPalabra().charAt(i) == letraElegida.charAt(0)) {

                        palabraProgresoArray[i] = letraElegida.charAt(0);

                    }

                }

                palabraProgreso = new String(palabraProgresoArray);
                break;
                
            case 4:

                player.setLives(player.getLives() - 1);
                break;

            default:
                break;

        }

        return palabraProgreso;

    }

    public void compararPalabra(String resultado, Palabra palabra, Player player) {

        if (resultado.equals(palabra.getPalabra())) {

            System.out.println("¡La respuesta es correcta!");
            palabra.setSolved(true);

        } else {

            System.out.println("La respuesta no es correcta.\n"
                                + "Pierdes dos vidas.\n");
            player.setLives(player.getLives() - 2);

        }
    }
    
}
