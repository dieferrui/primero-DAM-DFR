package diego;

import diego.componentes.*;
import diego.componentes.enums.*;
import diego.enums_general.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Simulador {

    private static final Scanner SC = new Scanner(System.in);

    private Tanque tanque1;
    private Tanque tanque2;
    private Deteccion deteccion;
    private Distancia distancia;
    private Terreno terreno;
    private Situacion situacion;

    public Simulador() {

        TanquesManager.listarTanques();

        this.tanque1 = seleccionarVehiculo(1);

        TanquesManager.listarTanques();

        this.tanque2 = seleccionarVehiculo(2);

        if (tanque1.equals(tanque2)) {

            System.out.println("No puedes enfrentar dos vehículos iguales.");
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
            tanque = TanquesManager.cargarTanque(SC.nextLine());

        } while (tanque == null);

        return tanque;
    }

    public static Distancia seleccionarDistancia() {

        Distancia distancia = null;
        
        do {

            System.out.println("Selecciona la distancia del combate:\n" + 
                                "1. Cercana\n" +
                                "2. Media\n" +
                                "3. Larga\n");
            
            
            try {

                distancia = Distancia.values()[SC.nextInt() - 1];

            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Por favor, introduce un número de opción válido.");

            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduce un número.");

            }

        } while (distancia == null);

        return distancia;

    }

    public static Terreno seleccionarTerreno() {

        Terreno terreno = null;
        
        do {

            System.out.println("Selecciona el terreno del combate:\n" + 
                                "1. Desierto\n" +
                                "2. Bosque\n" +
                                "3. Montaña\n" +
                                "4. Ciudad\n" +
                                "5. Llanura");
            
            
            try {

                terreno = Terreno.values()[SC.nextInt() - 1];

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

            System.out.println("Selecciona en qué momento de han detectado los vehículos entre sí:\n" + 
                                "1. Los vehículos se detectan antes de que empiece el enfrentamiento\n" +
                                "2. Los vehículos no se detectan hasta que el enfrentamiento es inevitable\n" + 
                                "3. El primer vehículo detecta al otro antes de que empiece el enfrentamiento");
            
            try {

                deteccion = Deteccion.values()[SC.nextInt() - 1];

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

            System.out.println("Selecciona la situación de los vehículos al iniciar el combate:\n" + 
                                "1. Neutra\n" +
                                "2. El primer vehículo está en una posición defensiva\n" +
                                "3. El primer vehículo está atacando una posición defendida por el segundo");
            
            try {

                situacion = Situacion.values()[SC.nextInt() - 1];

            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Por favor, introduce un número de opción válido.");

            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduce un número.");

            }

        } while (situacion == null);

        return situacion;

    }

    public String devolverDatos() {
            
        return "Vehículo 1: " + tanque1.getNombre() + "\n" +
                "Vehículo 2: " + tanque2.getNombre() + "\n" +
                "Distancia: " + distancia + "\n" +
                "Terreno: " + terreno + "\n" +
                "Detección: " + deteccion + "\n" +
                "Situación: " + situacion;

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
