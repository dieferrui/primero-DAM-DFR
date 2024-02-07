package Descent.Funcionalidades;

import Descent.Objetos.*;
import java.util.Scanner;

public class CicloDeJuego {

    private static Scanner sc = new Scanner(System.in);

    public static void iniciarJuego() {

        System.out.println("Los rumores dicen que al Este, cerca de la frontera, existe una\n"
                        + "mazmorra legendaria, llena de riquezas. Muchos han sido los que\n"
                        + "han entrado en busca de fama y fortuna, pero ninguno ha llegado\n"
                        + "a encontrar el final. Aún así, aquí estás, delante de sus puertas.\n"
                        + "Bienvenido a DESCENT.\n");

        Personaje player = Personaje.crearPersonaje();

        player.toString();

        cicloPrincipal(player);

    }

    public static void cicloPrincipal(Personaje player) {

        int depth = 0;
        Nivel nextLevel = null;

        for (depth = 0; depth < 9999; depth++) {

            if (depth == 0) {
                
                nextLevel = Nivel.generarNivel(depth, player.getLevel());
            
            } else {

                try {

                    nextLevel = Nivel.generarNivel(depth, player.getLevel(), nextLevel);

                } catch (Exception e) {

                    System.out.println("Ha ocurrido un error al general el nivel");
                    
                }
            }

            /*
            do {
                
                System.out.println(nextLevel.getDescription());

                System.out.println("Press 1 to continue...");

                continuar = sc.nextLine();

            } while (!continuar.equals("1"));
            */
        }
    }
}
