package diego;

public class SimuladorEnfrentamientos {

    public Simulador prepararEnfrentamiento () {
        
        System.out.println("---- Simulador de combates ----");
        System.out.println("El simulador de combates toma dos vehículos\n" +
                            "existentes de la base de datos y los enfrenta\n" +
                            "en un escenario de combate controlado.\n");

        return new Simulador();

    }

    public void enfrentarVehiculos(Simulador simulador) {

        System.out.println(simulador.devolverDatos());

    }
}
