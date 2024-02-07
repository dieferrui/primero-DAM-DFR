import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        CajaMagica caja = new CajaMagica();
        String nombreAventurero;
        String nombreObjeto;
        int opciones;

        do {
            System.out.println("Dime el nombre de tu personaje, o deja el nombre en blanco para que huya: ");
            nombreAventurero = System.console().readLine();
            System.out.println();
            
            if (!nombreAventurero.isEmpty()) {

                Aventurero aventurero = new Aventurero(nombreAventurero);
                
                do {
                    System.out.println("Tu personaje encuentra una misteriosa caja. ¿Deseas interactuar con la caja?");
                    System.out.println("1. Ver contenidos de la caja.\n2. Sacar/Meter objetos en la caja.\n3. No hacer nada.");
                    opciones = sc.nextInt();
                    
                    switch (opciones) {
                        case 1: aventurero.abrirCaja(caja); break;
                        case 2:
                            System.out.println("Especifica qué objeto tiene tu personaje en la mano, o deja en blanco si no tienes ninguno: ");
                            nombreObjeto = System.console().readLine();

                            Objeto objeto = new Objeto(nombreObjeto);

                            if (nombreObjeto.isEmpty()) {
                                objeto = null;
                            }

                            aventurero.usarCaja(caja, objeto);
                            break;
                        case 3: break;
                        default: break;
                    }
                } while (opciones != 3);
            }
            
        } while (!nombreAventurero.isEmpty());

        sc.close();
    }
}
