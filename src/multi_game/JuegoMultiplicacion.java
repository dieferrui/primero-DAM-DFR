package multi_game;

import java.util.Scanner;

public class JuegoMultiplicacion {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Juego juego = new Juego();

        System.out.print("Cuantos jugadores van a jugar: \n" +
                "1.- Dos jugadores.\n" +
                "2.- Tres jugadores.\n" +
                "\n" +
                "Escoja una opcion: ");
        escogerCantidadJugadores(juego);

        System.out.println();

        juego.generarYResponderMultiplicacion();

        sc.close();
    }

    /*
    TODO: En vez de crear dos métodos dentro de escogerCantidadJugadores, 
    crea uno que reciba la instancia del juego y un int (núm. jugadores), 
    y así te ahorras un método
     */
    
    public static void escogerCantidadJugadores(Juego juego) {
        int opcion;

        do {
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    agregarDosJugadores(juego);
                    break;
                case 2:
                    agregarTresJugadores(juego);
                    break;
                default:
                    System.out.println("Introduzca un numero correcto");
                    break;
            }
        } while (opcion != 1 && opcion != 2);
    }

    public static void agregarDosJugadores(Juego juego) {
        juego.agregarJugadores("Jugador 1");
        juego.agregarJugadores("Jugador 2");
    }

    public static void agregarTresJugadores(Juego juego) {
        juego.agregarJugadores("Jugador 1");
        juego.agregarJugadores("Jugador 2");
        juego.agregarJugadores("Jugador 3");
    }
}