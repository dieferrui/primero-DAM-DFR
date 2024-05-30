package diego;

import java.util.Scanner;

public class Main {

    protected static final Scanner SC = new Scanner(System.in);
    
    public static void main(String[] args) {

        String mainSelect;

        do {
            
            System.out.println("Ensamblador de tanques 1.0");
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

// TODO 1: Añadir angulos de depresión y elevación a cálculos de potencia de ataque
// TODO 2: Añadir componentes extra al ensamblador de tanques (enums):
    /*
     * Lanzadores de granadas de humo externos (más pesados, mayor cobertura)
     * Lanzadores de granadas internos (más ligeros, menos usos)
     * Blindaje espaciado (mayor protección si el oponente usa HE o HEAT)
     * Blindaje adicional (mayor protección a cambio de más peso)
     * Blindaje improvisado (protección adicional ligera)
     * Filtros mejorados (mayor movilidad en desierto y urbano)
     * Ametralladora media montada (mejora ligera de potencia de ataque)
     * Ametralladora pesada montada (mejora ligera de potencia y ventaja extra contra oponentes de menos de 10t)
     * Pala de bulldozer (el blindaje de la torreta consigue más peso en el cálculo)
     */
// TODO 3: Implementar sistema para guardar, visualizar y eliminar los resultados de simulación (en .txt)
// TODO 5: Implementar comparators para filtrar la lista de vehículos en TanquesManager