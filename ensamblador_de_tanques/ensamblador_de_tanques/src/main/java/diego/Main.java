package diego;

import diego.componentes.Tripulante;
import diego.componentes.enums.RolTripulante;

public class Main {

    public static void main(String[] args) {

        System.out.println("Ensamblador de Tanques");

        ControlComponentes control = new ControlComponentes();

        // Ensamblar vehículo de prueba
        Tanque tanque = new Tanque("Tanque de prueba", control.mapaChasis.get("CHS-GE-000"),
                                            control.mapaTorretas.get("TUR-GE-000"),
                                            control.mapaMotores.get("ENG-GE-000"),
                                            control.mapaArmas.get("GUN-GE-000"),
                                            new Tripulante[]{new Tripulante(RolTripulante.COMANDANTE, 100),
                                                            new Tripulante(RolTripulante.CONDUCTOR, 100),
                                                            new Tripulante(RolTripulante.ARTILLERO, 100),
                                                            new Tripulante(RolTripulante.CARGADOR, 100)});

        System.out.println(tanque.mostrarDatosCompletos());

    }
}