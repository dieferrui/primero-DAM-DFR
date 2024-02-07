package de_abajo_a_arriba;

import java.util.Scanner;
import java.util.Random;

public class Ciclo {
    
    private static final Scanner SC = new Scanner(System.in);
    private static Random random = new Random();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        String nombre;
        String claseNum;

        System.out.println("Dale nombre a tu personaje: ");
        nombre = SC.nextLine();

        PJSencillo personaje = new PJSencillo(nombre);

        System.out.println("Escoge una clase:\n1. Guerrero\n2. Mago\n3. Campeón");
        claseNum = SC.nextLine();

        switch (claseNum) {
            case "1": PJSencillo.eleccionPJ("Fighter", personaje); break;
            case "2": PJSencillo.eleccionPJ("Wizard", personaje); break;
            case "3": PJSencillo.eleccionPJ("Champion", personaje); break;
            default: PJSencillo.eleccionPJ("Fighter", personaje); break;
        }

        combatEncounter(personaje);

    }

    public static void combatEncounter(PJSencillo personaje) {

        do {

            String[] enemigos = {"Esqueleto", "Goblin", "Orco", "Gigante", "Dragón"};
            int eneIdx = random.nextInt(enemigos.length + 1);

            Enemigo enemigo = new Enemigo(enemigos[eneIdx]);
            
            System.out.println("Te has encontrado con un " + enemigo.getNombre());

            turnoJuego(personaje, enemigo);

        } while (personaje.getCurrentHP() > 0);

    }

    public static void turnoJuego(PJSencillo jugador, Enemigo enemigo) {

        do {
            
            boolean huye = turnoJugador(jugador, enemigo);
            turnoEnemigo(jugador, enemigo, huye);

        } while (enemigo.getCurrentHP() > 0 && jugador.getCurrentHP() > 0);

    }

    public static boolean turnoJugador(PJSencillo jugador, Enemigo enemigo) {

        int action = 3;
        String eleccion;
        boolean huir = false;

        do { 
            
            System.out.println("Te quedan " + action + " acciones...\n1. Atacar (1A)\n2. Huir(1A)");
            eleccion = SC.nextLine();
            sb.append(jugador.getAtkMod());

            switch (eleccion) {

                case "1": 
                    
                    int tirada = TirarDados.attackRoll("1d20" + sb);

                    if (tirada > (enemigo.getArmorClass() + 10)) {

                        int tiradaDanio = TirarDados.damageRoll(jugador.getArma().danio, true);
                        enemigo.setCurrentHP(enemigo.getCurrentHP() - tiradaDanio);
                        System.out.println("Has infligido " + tiradaDanio + " de daño crítico al enemigo.");

                    } else if (tirada > enemigo.getArmorClass()) {

                        int tiradaDanio = TirarDados.damageRoll(jugador.getArma().danio, false);
                        enemigo.setCurrentHP(enemigo.getCurrentHP() - tiradaDanio);
                        System.out.println("Has infligido " + tiradaDanio + " de daño al enemigo.");

                    } else {

                        System.out.println("Has fallado.");

                    }

                    action -= 1;
                    break;

                case "2":
                    
                    int huida = TirarDados.attackRoll("1d20");

                    if (huida >= 15) {

                        huir = true;
                        System.out.println("Escapas con éxito");

                    } else {

                        System.out.println("El enemigo bloquea el paso!");

                    }

                    action -= 1;
                    break;
                
                default:
                    
                    break;

            }

        } while (action > 0);
        
        sb.delete(0, 1);
        return huir;

    }

    public static void turnoEnemigo(PJSencillo jugador, Enemigo enemigo, boolean huido) {

        sb.append(enemigo.getAtkMod());

        if (!huido) {

            enemigo.setHP(0);
        
        } else if (enemigo.getHP() <= 0) {

            System.out.println("Has recibido " + enemigo.getXP() + " de experiencia.");

        } else {

            int tiradaEnemigo = TirarDados.attackRoll("1d20" + sb);

            if (tiradaEnemigo > (jugador.getArmorClass() + 10)) {

                int tiradaDanioEnemigoC = TirarDados.damageRoll(enemigo.getDanio(), true);
                jugador.setCurrentHP(jugador.getCurrentHP() - tiradaDanioEnemigoC);
                System.out.println("El enemigo te ha infligido " + tiradaDanioEnemigoC + " de daño crítico.");

            } else if (tiradaEnemigo > enemigo.getArmorClass()) {

                int tiradaDanioEnemigo = TirarDados.damageRoll(enemigo.getDanio(), false);
                jugador.setCurrentHP(jugador.getCurrentHP() - tiradaDanioEnemigo);
                System.out.println("El enemigo te ha infligido " + tiradaDanioEnemigo + " de daño.");

            }
        }
    }
}
