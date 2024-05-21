package diego;

import java.util.Scanner;

public class Main {

    protected static final Scanner SC = new Scanner(System.in);
    
    public static void main(String[] args) {

        String mainSelect;

        do {
            
            System.out.println("Ensamblador de tanques 0.2");
            System.out.println("¿Qué quieres hacer?\n1. Ensamblar tanque\n"
                            + "2. Manejo de archivos\n3. Simulador de enfrentamiento\n4. Salir");
            mainSelect = SC.nextLine();

            switch (mainSelect) {

                case "1": Ensamblador.ensamblarTanque(); break;
                case "2": manejador(); break;
                case "3": simulador(); break;
                default: break;
            }


        } while (!mainSelect.equals("4"));

    }

    public static void manejador() {

        String manejoSelect;

        do {
            
            System.out.println("\nMenú manejo de archivos");
            System.out.println("¿Qué quieres hacer?\n1. Visualizar lista de vehículos\n"
                            + "2. Eliminar vehículos\n3. Mostrar datos de vehículo\n"
                            + "4. Atrás\n");
            manejoSelect = SC.nextLine();
            String nomArchivo;
            Tanque tanqueMostrado;

            switch (manejoSelect) {

                case "1":
                    System.out.println(TanquesManager.listarTanques());
                    System.out.println();
                    break;

                case "2":
                    System.out.println("Introduzca el nombre del archivo que desea borrar: ");
                    nomArchivo = SC.nextLine();

                    String respuesta = TanquesManager.borrarTanque(nomArchivo);
                    System.out.println(respuesta);
                    break;

                case "3":
                    System.out.println("Introduzca el nombre del archivo que desea mostrar: ");
                    nomArchivo = SC.nextLine();

                    tanqueMostrado = TanquesManager.cargarTanque(nomArchivo);
                    System.out.println(tanqueMostrado.mostrarDatosCompletos());

                    break;

                default: break;
            }


        } while (!manejoSelect.equals("4"));

    }

    public static void simulador() {

        SimuladorEnfrentamientos simulacion = new SimuladorEnfrentamientos();

        Simulador simil = simulacion.prepararEnfrentamiento();
        String resultado = simulacion.enfrentarVehiculos(simil);

        System.out.println(resultado);
        
    }
}