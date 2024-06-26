package diego;

import org.apache.log4j.Logger;
import diego.enums_general.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Simulador {

    private static final Scanner SCC = new Scanner(System.in);
    private static Logger log = Logger.getLogger(Simulador.class.getName());

    private Tanque tanque1;
    private Tanque tanque2;
    private Deteccion deteccion;
    private Distancia distancia;
    private Terreno terreno;
    private Situacion situacion;

    public Simulador() {

        if (TanquesManager.listarTanques().isEmpty()) {

            System.out.println("No hay vehículos disponibles para simular un combate.");
            log.info("El simulador no se ha podido iniciar porque no hay vehículos disponibles.");
            System.exit(0);

        }

        System.out.println(TanquesManager.listarTanques());

        this.tanque1 = seleccionarVehiculo(1);

        System.out.println(TanquesManager.listarTanques());

        this.tanque2 = seleccionarVehiculo(2);

        if (tanque1.equals(tanque2)) {

            System.out.println("No puedes enfrentar dos vehículos iguales.");
            log.info("El simulador no se ha podido iniciar porque los vehículos seleccionados son iguales.");
            System.exit(0);

        }

        this.distancia = seleccionarDistancia();
        this.terreno = seleccionarTerreno();
        this.deteccion = seleccionarDeteccion();
        this.situacion = seleccionarSituacion();

    }

    public static Tanque seleccionarVehiculo(int numVehiculo) {

        Tanque tanque;

        do {
            
            System.out.println("Introduce el nombre del " + (numVehiculo == 1 ? "primer" : "segundo")  + " vehículo:");
            tanque = TanquesManager.cargarTanque(SCC.nextLine());

        } while (tanque == null);

        return tanque;
    }

    public static Distancia seleccionarDistancia() {

        Distancia distancia = null;
        
        do {

            System.out.println("\nSelecciona la distancia del combate:\n" + 
                                "1. Cercana\n" +
                                "2. Media\n" +
                                "3. Larga");
            
            
            try {

                distancia = Distancia.values()[SCC.nextInt() - 1];

            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Por favor, introduce un número de opción válido.");
                log.info("Error en la selección de la distancia del combate.");

            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduce un número.");
                log.info("Error en la selección de la distancia del combate.");

            }

        } while (distancia == null);

        return distancia;

    }

    public static Terreno seleccionarTerreno() {

        Terreno terreno = null;
        
        do {

            System.out.println("\nSelecciona el terreno del combate:\n" + 
                                "1. Desierto\n" +
                                "2. Bosque\n" +
                                "3. Montaña\n" +
                                "4. Ciudad\n" +
                                "5. Llanura");
            
            
            try {

                terreno = Terreno.values()[SCC.nextInt() - 1];

            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Por favor, introduce un número de opción válido.");

            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduce un número.");

            }

        } while (terreno == null);

        return terreno;

    }

    public static Deteccion seleccionarDeteccion() {

        Deteccion deteccion = null;
        
        do {

            System.out.println("\nSelecciona en qué momento se han detectado los vehículos entre sí:\n" + 
                                "1. Los vehículos se detectan antes de que empiece el enfrentamiento\n" +
                                "2. Los vehículos no se detectan hasta que el enfrentamiento es inevitable\n" + 
                                "3. El primer vehículo detecta al otro antes de que empiece el enfrentamiento");
            
            try {

                deteccion = Deteccion.values()[SCC.nextInt() - 1];

            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Por favor, introduce un número de opción válido.");

            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduce un número.");

            }

        } while (deteccion == null);

        return deteccion;

    }

    public static Situacion seleccionarSituacion() {

        Situacion situacion = null;
        
        do {

            System.out.println("\nSelecciona la situación de los vehículos al iniciar el combate:\n" + 
                                "1. Neutra\n" +
                                "2. El primer vehículo está en una posición defensiva\n" +
                                "3. El primer vehículo está atacando una posición defendida por el segundo");
            
            try {

                situacion = Situacion.values()[SCC.nextInt() - 1];

            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Por favor, introduce un número de opción válido.");

            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduce un número.");

            }

        } while (situacion == null);

        return situacion;

    }

    public String devolverDatos() {

        String dist;
        String detec;
        String terr;
        String situ;

        switch (this.distancia) {
            case CORTA:
                dist = "Cercana, " + Distancia.CORTA.getMetros() + "m";
                break;
            case MEDIA:
                dist = "Media, " + Distancia.MEDIA.getMetros() + "m";
                break;
            default:
                dist = "Larga, " + Distancia.LARGA.getMetros() + "m";
                break;
        }

        switch (this.deteccion) {
            case NORMAL:
                detec = "Los vehículos se detectan antes de que empiece el enfrentamiento.";
                break;
            case SORPRESA:
                detec = "Los vehículos no se detectan hasta que el enfrentamiento es inevitable.";
                break;
            default:
                detec = "El primer vehículo detecta al otro antes de que empiece el enfrentamiento.";
                break;
        }

        switch (this.terreno) {
            case DESIERTO:
                terr = "Desértico";
                break;
            case BOSQUE:
                terr = "Boscoso";
                break;
            case MONTAÑA:
                terr = "Montañoso";
                break;
            case CIUDAD:
                terr = "Urbano";
                break;
            default:
                terr = "Llano";
                break;
        }

        switch (this.situacion) {
            case NEUTRA:
                situ = "Los dos vehículos se encuentran durante una patrulla.";
                break;
            case DEFENSIVA:
                situ = "El primer vehículo está defendiendo una posición.";
                break;
            default:
                situ = "El primer vehículo está atacando una posición defendida por el segundo.";
                break;
        }
            
        return "---------- Simulador iniciado ----------\n" +
                "Vehículo 1: " + this.tanque1.getNombre() + "\n" +
                "Vehículo 2: " + this.tanque2.getNombre() + "\n" +
                "Distancia de enfrentamiento: " + dist + "\n" +
                "Momento de la detección: " + detec + "\n" +
                "Terreno del enfrentamiento: " + terr + "\n" +
                "Situación de los vehículos: " + situ + "\n";

    }

    public Tanque getTanque1() {
        return tanque1;
    }

    public void setTanque1(Tanque tanque1) {
        this.tanque1 = tanque1;
    }

    public Tanque getTanque2() {
        return tanque2;
    }

    public void setTanque2(Tanque tanque2) {
        this.tanque2 = tanque2;
    }

    public Deteccion getDeteccion() {
        return deteccion;
    }

    public void setDeteccion(Deteccion deteccion) {
        this.deteccion = deteccion;
    }

    public Distancia getDistancia() {
        return distancia;
    }

    public void setDistancia(Distancia distancia) {
        this.distancia = distancia;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public Situacion getSituacion() {
        return situacion;
    }

    public void setSituacion(Situacion situacion) {
        this.situacion = situacion;
    }

}
