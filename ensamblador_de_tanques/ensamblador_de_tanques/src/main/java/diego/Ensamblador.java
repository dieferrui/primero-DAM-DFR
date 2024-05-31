package diego;

import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
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

    private static final Random RANDOM = new Random();

    private static final String LIG = "ligero";
    private static final String MED = "medio";
    private static final String PES = "pesado";

    public static void ensamblarTanque() {

        boolean finalizado;
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

            paisSelect = (SCB.nextLine()).toUpperCase();
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

        Set<Chassis> setChasis = new TreeSet<>();

        for (Map.Entry<String, Chassis> chasis : CONTROL.mapaChasis.entrySet()) {

            for (Paises paisComponente : chasis.getValue().getUsuarios()) {
            
                if (paisComponente.getNombre().equals(pais)) {

                    setChasis.add(chasis.getValue());

                }

            }

        }

        for (Chassis chasis : setChasis) {

            System.out.println(chasis.getID() + ": " + chasis.getDesignacion() + 
                                ", Carga máxima: " + chasis.getCargaMaxima() + "kg , Blindaje (mm): " + 
                                chasis.getBlindajeFrontal() + "/" + chasis.getBlindajeLateral() + 
                                "/" + chasis.getBlindajeTrasero());

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

        Set<Motor> setMotor = new TreeSet<>();

        for (Map.Entry<String, Motor> motor : CONTROL.mapaMotores.entrySet()) {

            for (Paises paisComponente : motor.getValue().getUsuarios()) {
            
                if (paisComponente.getNombre().equals(pais)) {

                    setMotor.add(motor.getValue());
                    
                }

            }

        }

        for (Motor motor : setMotor) {

            System.out.println(motor.getID() + ": " + motor.getDesignacion() + 
                                ", Potencia: " + motor.getPotencia() + "CV, Peso: " + motor.getPeso() + "kg");

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

        Set<Armamento> setArma = new TreeSet<>();

        for (Map.Entry<String, Armamento> arma : CONTROL.mapaArmas.entrySet()) {

            for (Paises paisComponente : arma.getValue().getUsuarios()) {
            
                if (paisComponente.getNombre().equals(pais)) {

                    setArma.add(arma.getValue());
                    
                }

            }

        }

        for (Armamento arma : setArma) {

            System.out.println(arma.getID() + ": " + arma.getDesignacion() + 
                                ", Penetración (mm): " + arma.getPenetracionCorta() + "/" + arma.getPenetracionMedia() + 
                                "/" + arma.getPenetracionLarga() + ", Calibre: " + arma.getCalibre() + 
                                "mm , Peso: " + arma.getPeso() + "kg");

        }

        do {

            elegir = SCB.nextLine();

            armaSelect = CONTROL.mapaArmas.get(elegir);

            if (armaSelect == null) {

                System.out.println("El armamento especificado no existe.");

            }

        } while (armaSelect == null);

        return armaSelect;

    }

    public static Torreta seleccionarTorreta(String pais) {

        System.out.println("Paso 3: Seleccione el compartimento de combate del vehículo");
        System.out.println("Compartimentos disponibles para selección (elija compartimento por clave completa):");
        Torreta torreSelect = null;
        String elegir;

        Set<Torreta> setTorre = new TreeSet<>();

        for (Map.Entry<String, Torreta> torre : CONTROL.mapaTorretas.entrySet()) {

            for (Paises paisComponente : torre.getValue().getUsuarios()) {
            
                if (paisComponente.getNombre().equals(pais)) {

                    setTorre.add(torre.getValue());
                    
                }

            }

        }

        for (Torreta torre : setTorre) {

            System.out.println(torre.getID() + ": " + torre.getDesignacion() + 
                                ", Blindaje (mm): " + torre.getBlindajeFrontal() + "/" + torre.getBlindajeLateral() + 
                                "/" + torre.getBlindajeTrasero() + ", Peso: " + torre.getPeso() + "kg");

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

        int numTripulantes;
        int expMax;
        int expMin;

        do {
            
            System.out.println("Paso 5: Seleccione el número de tripulantes (mínimo 2). Cada tripulante añade 100kg al peso del vehículo: ");

            try {

                numTripulantes = Integer.parseInt(SCB.nextLine());

            } catch (NumberFormatException e) {
                    
                System.out.println("Por favor, introduzca un número válido de tripulantes.");
                numTripulantes = 0;
    
            }
        
        } while (numTripulantes < 2);

        Experiencia experiencia = elegirExperiencia();
        expMin = experiencia.getMinExp();
        expMax = experiencia.getMaxExp();

        ArrayList<Tripulante> tripulantes = new ArrayList<>();

        if (numTripulantes >= 1) tripulantes.add(new Tripulante(RolTripulante.COMANDANTE, RANDOM.nextInt((expMax - expMin) + 1) + expMin));
        if (numTripulantes >= 2) tripulantes.add(new Tripulante(RolTripulante.CONDUCTOR, RANDOM.nextInt((expMax - expMin) + 1) + expMin));
        if (numTripulantes >= 3) tripulantes.add(new Tripulante(RolTripulante.ARTILLERO, RANDOM.nextInt((expMax - expMin) + 1) + expMin));
        if (numTripulantes >= 4) tripulantes.add(new Tripulante(RolTripulante.CARGADOR, RANDOM.nextInt((expMax - expMin) + 1) + expMin));
        if (numTripulantes >= 5) tripulantes.add(new Tripulante(RolTripulante.OPERADOR_DE_RADIO, RANDOM.nextInt((expMax - expMin) + 1) + expMin));

        for (int i = 6; i <= numTripulantes; i++) {

            tripulantes.add(new Tripulante(RolTripulante.TRIPULANTE_AUXILIAR, RANDOM.nextInt((expMax - expMin) + 1) + expMin));

        }

        return tripulantes.toArray(new Tripulante[0]);
    }

    public static Experiencia elegirExperiencia() {

        String elegir;
        String[] resArray = {"1", "2", "3"};
        List<String> resValida = new ArrayList<>(Arrays.asList(resArray));

        do {

            System.out.println("Elija el nivel de experiencia de la tripulación:");
            System.out.println("1. Novatos\n2. Experimentados\n3. Veteranos");
            elegir = SCB.nextLine();

        } while (!resValida.contains(elegir));
    
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

            if (tanque.getChasis().getCargaMaxima() > 45000) {

                clase.append(PES);

            } else {

                clase.append(LIG);

            }

            tanque.setClase(clase.toString());

        } else if (tanque.getArma().getClase() == ClaseArmamento.AUTOCANNON) {

            clase.append("IFV ");

            if (tanque.getChasis().getCargaMaxima() > 32000) {

                clase.append(PES);

            } else {

                clase.append(LIG);

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

            if (tanque.getChasis().getCargaMaxima() >= 45000) {

                clase.append(PES);

            } else if (tanque.getChasis().getCargaMaxima() >= 18000) {

                clase.append(MED);

            } else {

                clase.append(LIG);

            }
        }

        return clase.toString();

    }
}
