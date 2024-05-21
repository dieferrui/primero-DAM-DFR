package diego;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Map;

import diego.componentes.*;
import diego.componentes.enums.*;
import diego.enums_general.Experiencia;
import diego.enums_general.Paises;

public class Ensamblador {

    private static final Scanner SCB = new Scanner(System.in);
    protected static final ControlComponentes CONTROL = new ControlComponentes();

    public static void ensamblarTanque() {

        boolean finalizado = Boolean.FALSE;
        String paisSelect;
        Tanque tanque = new Tanque();
        
        do {
            
            System.out.println("Ensamblador de vehículos.");
            
            paisSelect = selectorPais();

            finalizado = montajeGeneral(paisSelect, tanque);

        } while (!finalizado);

    }

    public static String selectorPais() {

        boolean contiene = Boolean.FALSE;
        String paisSelect;

        System.out.println("Introduzca el prefijo de la nación (por ejemplo, GER para Alemania): ");

        int n = 1;

        for (Paises pais : Paises.values()) {

            System.out.println(n + ". " + pais.getNombre());
            n++;

        }

        do {

            paisSelect = SCB.nextLine();
            contiene = Paises.contiene(paisSelect);

            if (!contiene) {

                System.out.println("El identificador de país proporcionado no existe, inténtelo de nuevo.");

            }

        } while (!contiene);

        return paisSelect;

    }

    public static boolean montajeGeneral(String pais, Tanque tanque) {

        boolean cargaSobrepasada = Boolean.TRUE;
        boolean finalizado = Boolean.TRUE;
        String nombre;
        String res;

        Chassis chasis;
        Torreta torreta;
        Armamento arma;
        Motor motor;
        Tripulante[] tripulacion;

        do {

            double controlCargaMax;
            double controlCarga = 0;

            System.out.println("Paso 0: Introduzca un nombre para el vehículo: ");
            nombre = SCB.nextLine();
            tanque.setNombre(nombre);
            
            chasis = seleccionarChasis(pais);
            tanque.setChasis(chasis);
            controlCargaMax = chasis.getCargaMaxima();
            controlCarga += chasis.getPeso();

            motor = seleccionarMotor(pais);
            tanque.setMotor(motor);
            controlCarga += motor.getPeso();

            torreta = seleccionarTorreta(pais);
            tanque.setTorreta(torreta);
            controlCarga += torreta.getPeso();

            arma = seleccionarArmamento(pais);
            tanque.setArma(arma);
            controlCarga += arma.getPeso();

            tripulacion = agregarTripulantes();
            tanque.setTripulacion(tripulacion);
            controlCarga += tripulacion.length * Tripulante.getPeso();

            tanque.getChasis().setCargaActual(controlCarga);
            tanque.setRelacionPotencia(motor.getPotencia() / (controlCarga / 1000));

            tanque.setClase(devolverClase(tanque));

            if (controlCarga < controlCargaMax) {

                cargaSobrepasada = Boolean.FALSE;

            } else {

                System.out.println("La carga máxima del vehículo ha sido sobrepasada (" + (controlCarga - controlCargaMax) + "kg). Inténtelo de nuevo.");

            }

        } while (cargaSobrepasada);

        System.out.println("Este es el vehículo creado: ");
        System.out.println(tanque.mostrarDatosCompletos());

        do {
            
            System.out.println("¿Desea guardar el vehículo?\n1. Sí\n2. No");
            res = SCB.nextLine();

            if (res.equals("1")) {

                TanquesManager.guardarTanque(tanque, nombre);

            }
            
        } while (!res.equals("1") && !res.equals("2"));

        return finalizado;

    }

    public static Chassis seleccionarChasis(String pais) {

        System.out.println("Paso 1: Seleccione el chasis del vehículo");
        System.out.println("Chasis disponibles para selección (elija chasis por clave completa):");
        Chassis chasisSelect = null;
        String elegir;

        for (Map.Entry<String, Chassis> chasis : CONTROL.mapaChasis.entrySet()) {

            for (Paises paisComponente : chasis.getValue().getUsuarios()) {
            
                if (paisComponente.getNombre().equals(pais)) {
                    
                    System.out.println(chasis.getKey() + ": " + chasis.getValue().getDesignacion() + 
                                ", Carga máxima: " + chasis.getValue().getCargaMaxima() + "kg , Blindaje (mm): " + 
                                chasis.getValue().getBlindajeFrontal() + "/" + chasis.getValue().getBlindajeLateral() + 
                                "/" + chasis.getValue().getBlindajeTrasero());
                }

            }

        }

        do {

            elegir = SCB.nextLine();

            chasisSelect = CONTROL.mapaChasis.get(elegir);

            if (chasisSelect == null) {

                System.out.println("El chasis especificado no existe.");

            }

        } while (chasisSelect == null);

        return chasisSelect;

    }

    public static Motor seleccionarMotor(String pais) {

        System.out.println("Paso 2: Seleccione el motor del vehículo");
        System.out.println("Motores disponibles para selección (elija motor por clave completa):");
        Motor motorSelect = null;
        String elegir;

        for (Map.Entry<String, Motor> motor : CONTROL.mapaMotores.entrySet()) {

            for (Paises paisComponente : motor.getValue().getUsuarios()) {
            
                if (paisComponente.getNombre().equals(pais)) {
                    
                    System.out.println(motor.getKey() + ": " + motor.getValue().getDesignacion() + 
                                ", Potencia: " + motor.getValue().getPotencia() + "CV, Peso: " + motor.getValue().getPeso() + "kg");
                }

            }

        }

        do {

            elegir = SCB.nextLine();

            motorSelect = CONTROL.mapaMotores.get(elegir);

            if (motorSelect == null) {

                System.out.println("El motor especificado no existe.");

            }

        } while (motorSelect == null);

        return motorSelect;

    }

    public static Armamento seleccionarArmamento(String pais) {

        System.out.println("Paso 4: Seleccione el armamento del vehículo");
        System.out.println("Armamentos disponibles para selección (elija por clave completa):");
        Armamento armaSelect = null;
        String elegir;

        for (Map.Entry<String, Armamento> arma : CONTROL.mapaArmas.entrySet()) {

            for (Paises paisComponente : arma.getValue().getUsuarios()) {
            
                if (paisComponente.getNombre().equals(pais)) {
                    
                    System.out.println(arma.getKey() + ": " + arma.getValue().getDesignacion() + 
                                ", Penetración (mm): " + arma.getValue().getPenetracionCorta() + "/" + arma.getValue().getPenetracionMedia() + 
                                "/" + arma.getValue().getPenetracionLarga() + ", Calibre: " + arma.getValue().getCalibre() + 
                                "mm , Peso: " + arma.getValue().getPeso() + "kg");
                }

            }

        }

        do {

            elegir = SCB.nextLine();

            armaSelect = CONTROL.mapaArmas.get(elegir);

            if (armaSelect == null) {

                System.out.println("El compartimento especificado no existe.");

            }

        } while (armaSelect == null);

        return armaSelect;

    }

    public static Torreta seleccionarTorreta(String pais) {

        System.out.println("Paso 3: Seleccione el compartimento de combate del vehículo");
        System.out.println("Compartimentos disponibles para selección (elija arma por clave completa):");
        Torreta torreSelect = null;
        String elegir;

        for (Map.Entry<String, Torreta> torre : CONTROL.mapaTorretas.entrySet()) {

            for (Paises paisComponente : torre.getValue().getUsuarios()) {
            
                if (paisComponente.getNombre().equals(pais)) {
                    
                    System.out.println(torre.getKey() + ": " + torre.getValue().getDesignacion() + 
                                ", Blindaje (mm): " + torre.getValue().getBlindajeFrontal() + "/" + torre.getValue().getBlindajeLateral() + 
                                "/" + torre.getValue().getBlindajeTrasero() + ", Peso: " + torre.getValue().getPeso() + "kg");
                }

            }

        }

        do {

            elegir = SCB.nextLine();

            torreSelect = CONTROL.mapaTorretas.get(elegir);

            if (torreSelect == null) {

                System.out.println("La torreta especificada no existe.");

            }

        } while (torreSelect == null);

        return torreSelect;

    }

    public static Tripulante[] agregarTripulantes() {

        Random random = new Random();
        int numTripulantes;
        int expMax;
        int expMin;

        do {
            
            System.out.println("Paso 5: Seleccione el número de tripulantes (mínimo 2): ");

            try {

                numTripulantes = Integer.parseInt(SCB.nextLine());

            } catch (NumberFormatException e) {
                    
                System.out.println("Por favor, introduzca un número válido de tripulantes (cada tripulante añade 100kg al peso del vehículo).");
                numTripulantes = 0;
    
            }
        
        } while (numTripulantes < 2);

        Experiencia experiencia = elegirExperiencia();
        expMin = experiencia.getMinExp();
        expMax = experiencia.getMaxExp();

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

    public static Experiencia elegirExperiencia() {

        String elegir;

        do {

            System.out.println("Elija el nivel de experiencia de la tripulación:");
            System.out.println("1. Novatos\n2. Experimentados\n3. Veteranos");
            elegir = SCB.nextLine();

        } while (!elegir.equals("1") && !elegir.equals("2") && !elegir.equals("3"));
    
        switch (elegir) {

            case "1": return Experiencia.NOVATOS;
            case "2": return Experiencia.EXPERIMENTADOS;
            default: return Experiencia.VETERANOS;

        }
    }
    
    private static String devolverClase(Tanque tanque) {

        StringBuilder clase = new StringBuilder();

        if ((tanque.getArma().getCalibre()) > (tanque.getChasis().getCargaMaxima() * 3) || tanque.getTorreta().getTipoTorreta() == TipoTorreta.SUPERESTRUCTURA) {

            clase.append("Cazacarros ");

            if (tanque.getChasis().getCargaMaxima() > 50000) {

                clase.append("pesado");

            } else {

                clase.append("ligero");

            }

            tanque.setClase(clase.toString());

        } else if (tanque.getArma().getClase() == ClaseArmamento.AUTOCANNON) {

            clase.append("IFV ");

            if (tanque.getChasis().getCargaMaxima() > 50000) {

                clase.append("pesado");

            } else {

                clase.append("ligero");

            }

            tanque.setClase(clase.toString());

        } else if (tanque.getArma().getClase() == ClaseArmamento.HOWITZER && tanque.getChasis().getCargaMaxima() < 20000) {

            if (tanque.getTorreta().getTipoTorreta() == TipoTorreta.SUPERESTRUCTURA) {

                clase.append("Obús autopropulsado");

            } else {

                clase.append("Atrillería autopropulsada");

            }

            tanque.setClase(clase.toString());

        } else {

            clase.append("Tanque ");

            if (tanque.getChasis().getCargaMaxima() >= 50000) {

                clase.append("pesado");

            } else if (tanque.getChasis().getCargaMaxima() >= 20000) {

                clase.append("medio");

            } else {

                clase.append("ligero");

            }
        }

        return clase.toString();

    }
}
