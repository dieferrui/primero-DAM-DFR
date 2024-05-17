package diego;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import diego.componentes.*;
import diego.componentes.enums.*;

public class Main {

    protected static final Scanner SC = new Scanner(System.in);
    protected static final ControlComponentes CONTROL = new ControlComponentes();
    
    public static void main(String[] args) {

        String mainSelect;

        do {
            
            System.out.println("Ensamblador de tanques 0.1");
            System.out.println("¿Qué quieres hacer?\n1. Ensamblar tanque\n"
                            + "2. Manejo de archivos\n3. Comparador de vehículos\n"
                            + "4. Simulador de enfrentamiento\n5. Salir");
            mainSelect = SC.nextLine();

            switch (mainSelect) {

                case "1": ensamblador(); break;
                case "2": manejador(); break;
                case "3": comparador(); break;
                case "4": simulador(); break;
                default: break;
            }


        } while (!mainSelect.equals("5"));

        SC.close();

    }

    public static void manejador() {

        String manejoSelect;

        do {
            
            System.out.println("Menú manejo de archivos");
            System.out.println("¿Qué quieres hacer?\n1. Visualizar lista de vehículos\n"
                            + "2. Eliminar vehículos\n3. Mostrar datos de vehículo\n"
                            + "4. Mostrar datos de vehículo\n");
            manejoSelect = SC.nextLine();
            String nomArchivo;
            Tanque tanqueMostrado;

            switch (manejoSelect) {

                case "1":
                    TanquesManager.listarTanques();
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
                    tanqueMostrado.mostrarDatosCompletos();

                    break;

                default: break;
            }


        } while (!manejoSelect.equals("4"));

    }

    public static void ensamblador() {

        boolean finalizado = Boolean.FALSE;
        String paisSelect;
        
        do {
            
            System.out.println("Ensamblador de vehículos.");
            
            paisSelect = selectorPais();

            montajeGeneral(paisSelect);

        } while (!finalizado);

    }

    public static String selectorPais() {

        boolean contiene = Boolean.FALSE;
        String paisSelect;

        System.out.println("Seleccione el país de origen del vehículo (Introduzca el prefijo indicado)");

        int n = 1;

        for (Paises pais : Paises.values()) {

            System.out.println(n + ". " + pais.getNombre() + "\n");
            n++;

        }

        do {

            paisSelect = SC.nextLine();
            contiene = Paises.contiene(paisSelect);

            if (!contiene) {

                System.out.println("El identificador de país proporcionado no existe, inténtelo de nuevo.");

            }

        } while (!contiene);

        return paisSelect;

    }

    public static void montajeGeneral(String pais) {

        boolean cargaSobrepasada = Boolean.TRUE;
        String nombre;
        String res;
        int numTripulantes = 2;

        Chassis chasis;
        Torreta torreta;
        Armamento arma;
        Motor motor;
        Tripulante[] tripulacion;

        do {

            double controlCargaMax;
            double controlCarga = 0;

            System.out.println("Paso 0: Introduzca un nombre para el vehículo: ");
            nombre = SC.nextLine();
            
            System.out.println("Paso 1: Seleccione el chasis del vehículo: ");
            chasis = seleccionarChasis(pais);
            controlCargaMax = chasis.getCargaMaxima();
            controlCarga += chasis.getPeso();

            System.out.println("Paso 2: Seleccione el motor del vehículo: ");
            motor = seleccionarMotor(pais);
            controlCarga += motor.getPeso();

            System.out.println("Paso 3: Seleccione el compartimento de combate del vehículo: ");
            torreta = seleccionarTorreta(pais);
            controlCarga += torreta.getPeso();

            System.out.println("Paso 4: Seleccione el armamento del vehículo: ");
            arma = seleccionarArmamento(pais);
            controlCarga += arma.getPeso();

            System.out.println("Paso 5: Seleccione el número de tripulantes (mínimo 2): ");
            tripulacion = agregarTripulantes(numTripulantes);

            if (controlCarga < controlCargaMax) {

                cargaSobrepasada = Boolean.FALSE;

            } else {

                System.out.println("La carga máxima del vehículo ha sido sobrepasada.");

            }

        } while (cargaSobrepasada);

        Tanque tanque = new Tanque(nombre, chasis, torreta, motor, arma, tripulacion);

        System.out.println("Este es el vehículo creado: ");
        tanque.mostrarDatosCompletos();

        do {
            
            System.out.println("¿Desea guardar el vehículo?\n1. Sí\n2. No");
            res = SC.nextLine();

            if (res.equals("1")) {

                TanquesManager.guardarTanque(tanque, nombre);

            }
            
        } while (!res.equals("1") && !res.equals("2"));

    }

    public static Chassis seleccionarChasis(String pais) {

        System.out.println("Chasis disponibles para selección (elija chasis por clave completa):");
        Chassis chasisSelect = null;
        String elegir;

        for (Map.Entry<String, Chassis> chasis : CONTROL.mapaChasis.entrySet()) {

            if (chasis.getKey().startsWith(pais)) {
            
                System.out.println(chasis.getKey() + ": " + chasis.getValue().getDesignacion() + 
                                ", Carga máxima: " + chasis.getValue().getCargaMaxima());

            }

        }

        do {

            elegir = SC.nextLine();

            chasisSelect = CONTROL.mapaChasis.get(elegir);

            if (chasisSelect == null) {

                System.out.println("El chasis especificado no existe.");

            }

        } while (chasisSelect == null);

        return chasisSelect;

    }

    public static Motor seleccionarMotor(String pais) {

        System.out.println("Motores disponibles para selección (elija motor por clave completa):");
        Motor motorSelect = null;
        String elegir;

        for (Map.Entry<String, Motor> motor : CONTROL.mapaMotores.entrySet()) {

            if (motor.getKey().startsWith(pais)) {
            
                System.out.println(motor.getKey() + ": " + motor.getValue().getDesignacion() + 
                                ", Peso: " + motor.getValue().getPeso());

            }

        }

        do {

            elegir = SC.nextLine();

            motorSelect = CONTROL.mapaMotores.get(elegir);

            if (motorSelect == null) {

                System.out.println("El motor especificado no existe.");

            }

        } while (motorSelect == null);

        return motorSelect;

    }

    public static Torreta seleccionarTorreta(String pais) {

        System.out.println("Compartimentos disponibles para selección (elija por clave completa):");
        Torreta torreSelect = null;
        String elegir;

        for (Map.Entry<String, Torreta> torre : CONTROL.mapaTorretas.entrySet()) {

            if (torre.getKey().startsWith(pais)) {
            
                System.out.println(torre.getKey() + ": " + torre.getValue().getDesignacion() + 
                                ", Peso: " + torre.getValue().getPeso());

            }

        }

        do {

            elegir = SC.nextLine();

            torreSelect = CONTROL.mapaTorretas.get(elegir);

            if (torreSelect == null) {

                System.out.println("El compartimento especificado no existe.");

            }

        } while (torreSelect == null);

        return torreSelect;

    }

    public static Armamento seleccionarArmamento(String pais) {

        System.out.println("Armas disponibles para selección (elija arma por clave completa):");
        Armamento armaSelect = null;
        String elegir;

        for (Map.Entry<String, Armamento> arma : CONTROL.mapaArmas.entrySet()) {

            if (arma.getKey().startsWith(pais)) {
            
                System.out.println(arma.getKey() + ": " + arma.getValue().getDesignacion() + 
                                ", Peso: " + arma.getValue().getPeso());

            }

        }

        do {

            elegir = SC.nextLine();

            armaSelect = CONTROL.mapaArmas.get(elegir);

            if (armaSelect == null) {

                System.out.println("El arma especificada no existe.");

            }

        } while (armaSelect == null);

        return armaSelect;

    }

    public static Tripulante[] agregarTripulantes(int numTripulantes) {

        Random random = new Random();
        int expMax;
        int expMin;

        if (numTripulantes < 2) {
            numTripulantes = 2;
        }

        String exp = elegirExperiencia();

        switch (exp) {

            case "1":
                expMax = 40;
                expMin = 1;
                break;

            case "2":
                expMax = 70;
                expMin = 40;
                break;

            default:
                expMax = 100;
                expMin = 55;
                break;
        }

        ArrayList<Tripulante> tripulantes = new ArrayList<>();

        if (numTripulantes >= 1) tripulantes.add(new Tripulante(RolTripulante.COMANDANTE, random.nextInt((expMax - expMin) + 1) + expMin));
        if (numTripulantes >= 2) tripulantes.add(new Tripulante(RolTripulante.CONDUCTOR, random.nextInt((expMax - expMin) + 1) + expMin));
        if (numTripulantes >= 3) tripulantes.add(new Tripulante(RolTripulante.ARTILLERO, random.nextInt((expMax - expMin) + 1) + expMin));
        if (numTripulantes >= 4) tripulantes.add(new Tripulante(RolTripulante.CARGADOR, random.nextInt((expMax - expMin) + 1) + expMin));
        if (numTripulantes >= 5) tripulantes.add(new Tripulante(RolTripulante.OPERADOR_DE_RADIO, random.nextInt((expMax - expMin) + 1) + expMin));

        for (int i = 6; i <= numTripulantes; i++) {

            tripulantes.add(new Tripulante(RolTripulante.TRIPULANTE_AUXILIAR, random.nextInt((expMax - expMin) + 1) + expMin));

        }

        return tripulantes.toArray(new Tripulante[0]);
    }

    public static String elegirExperiencia() {

        String elegir;

        do {
            
            System.out.println("Elija el nivel de experiencia de la tripulación:");
            System.out.println("1. Novatos\n2. Experimentados\n3. Veteranos\n");

            elegir = SC.nextLine();

        } while (!elegir.equals("1") && !elegir.equals("2") && !elegir.equals("3"));

        return elegir;

    }

    public static String comparador() {

        return "WIP";
        // TODO implementar comparador de vehículos

    }

    public static String simulador() {

        return "WIP";
        // TODO implementar comparador de vehículos
        
    }
}