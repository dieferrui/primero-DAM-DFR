package multi_game;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Jugador> jugadores;
    private int resultadoMultiplicacion;

    public Juego() {
        jugadores = new ArrayList<>();
    }

    public void agregarJugadores(String nombre) {
        jugadores.add(new Jugador(nombre));
    }

    public void generarYResponderMultiplicacion() {
        Random random = new Random();

        do {
            
            int operando1 = random.nextInt(50) + 1;
            int operando2 = random.nextInt(50) + 1;

            resultadoMultiplicacion = operando1 * operando2;

            System.out.println("El resultado de " + operando1 + " x " + operando2 + " es: ");

            jugadoresResponden();

            if (jugadores.size() == 1) {
                decidirGanador();
                break;
            }
        } while (!jugadores.isEmpty());
    }

    public void jugadoresResponden() {
        for (Jugador jugador : jugadores) {
            System.out.print(jugador.getNombre() + ": ");
            jugador.setRespuesta(sc.nextInt());
        }

        comprobarResultado();

        sc.close();
    }

    public void comprobarResultado() {
        Iterator<Jugador> iterator = jugadores.iterator();

        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();

            if (resultadoMultiplicacion == jugador.getRespuesta()) {
                System.out.println("El " + jugador.getNombre() + " ha acertado el resultado, continua");
            } else {
                System.out.println("El " + jugador.getNombre() + " no ha acertado el resultado, será eliminado");
                iterator.remove();
            }
        }
    }

    public void decidirGanador() {
        if (!jugadores.isEmpty()) {
            Jugador ganador = jugadores.get(0);
            System.out.println();
            System.out.println("El ganador es el " + ganador.getNombre());
        }
    }
}