package diego;

import diego.componentes.*;
import diego.enums_general.*;
import java.text.DecimalFormat;

public class SimuladorEnfrentamientos {

    private double puntuacionTotal1;
    private double puntuacionTotal2;
    private double puntuacionReal1;
    private double puntuacionReal2;
    private double probabilidad1;
    private double[] potenciasFuego;
    private double[] puntosMovilidad;

    public SimuladorEnfrentamientos() {}
    
    public Simulador prepararEnfrentamiento () {
        
        System.out.println("---- Simulador de combates ----");
        System.out.println("El simulador de combates toma dos vehículos\n" +
                            "existentes de la base de datos y los enfrenta\n" +
                            "en un escenario de combate controlado.\n");

        return new Simulador();

    }

    public String enfrentarVehiculos(Simulador simulador) {

        System.out.println(simulador.devolverDatos());

        potenciasFuego = calcularPotenciaDeFuegoRelativa(simulador);

        System.out.println("En la simulación de tiro, el primer vehículo obtiene " + potenciasFuego[0] + " puntos de potencia de fuego,\n" +
                            "mientras que el segundo vehículo obtiene " + potenciasFuego[1] + " puntos de potencia de fuego.\n");

        if (potenciasFuego[0] == 0) {

            System.out.println("El primer vehículo no puede penetrar el blindaje del segundo vehículo con efectividad.");

        } else if (potenciasFuego[1] == 0) {

            System.out.println("El segundo vehículo no puede penetrar el blindaje del primer vehículo con efectividad.");

        }

        puntosMovilidad = calcularMovilidadEfectiva(simulador);

        System.out.println("En la simulación de movilidad, el primer vehículo obtiene " + puntosMovilidad[0] + " puntos de movilidad,\n" +
                            "mientras que el segundo vehículo obtiene " + puntosMovilidad[1] + " puntos de movilidad.\n");

        if (puntosMovilidad[0] > puntosMovilidad[1]) {

            System.out.println("El primer vehículo puede sacar cierta ventaja con su movilidad.");

        } else if (puntosMovilidad[1] > puntosMovilidad[0]) {

            System.out.println("El segundo vehículo es generalmente más móvil que el primero.");

        } else {

            System.out.println("Ambos vehículos tienen la misma movilidad.");

        }

        puntuacionTotal1 = potenciasFuego[0] + puntosMovilidad[0];
        puntuacionTotal2 = potenciasFuego[1] + puntosMovilidad[1];

        puntuacionReal1 = ajustarPorExperiencia(simulador.getTanque1().getTripulacion(), puntuacionTotal1);
        puntuacionReal2 = ajustarPorExperiencia(simulador.getTanque2().getTripulacion(), puntuacionTotal2);

        System.out.println("La puntuación total del primer vehículo es de " + puntuacionReal1 + ",\n" +
                            "mientras que la del segundo vehículo es de " + puntuacionReal2 + ".\n");

        probabilidad1 = puntuacionReal1 / (puntuacionReal1 + puntuacionReal2);
        DecimalFormat df = new DecimalFormat("#.##");
        String probabilidadFormat = df.format(probabilidad1);

        return "La probabilidad de que el/la " + simulador.getTanque1().getNombre() + 
                " gane el enfrentamiento contra el/la " + simulador.getTanque2().getNombre() + " es del " + probabilidadFormat + "%.";

    }

    // Este método calcula la efectividad del cañón de un tanque a la hora de penetrar el blindaje del enemigo dada la situación
    private double[] calcularPotenciaDeFuegoRelativa(Simulador simulador) {

        // Potencia de fuego relativa
        double potenciaTanque1 = 0;
        double potenciaTanque2 = 0;

        // Penetración usada
        int penTanque1 = devolverPenetracionPorDistancia(simulador.getTanque1(), simulador.getDistancia());
        int penTanque2 = devolverPenetracionPorDistancia(simulador.getTanque2(), simulador.getDistancia());

        // Blindaje nominal
        double[] blindajeNomTanque1 = devolverBlindajeNominal(simulador.getTanque1());
        double[] blindajeNomTanque2 = devolverBlindajeNominal(simulador.getTanque2());

        // Blindaje efectivo
        double blindajeEfectivoTanque1 = devolverBlindajeEfectivo(blindajeNomTanque1, simulador.getTerreno());
        double blindajeEfectivoTanque2 = devolverBlindajeEfectivo(blindajeNomTanque2, simulador.getTerreno());

        // Multiplicador de potencia de fuego relativo a la situación
        double multiPotencia1 = devolverMultiplicadorPotencia(simulador)[0];
        double multiPotencia2 = devolverMultiplicadorPotencia(simulador)[1];

        // Multiplicador de blindaje relativo a la situación
        double multiBlindaje1 = devolverMultiplicadorBlindaje(simulador)[0];
        double multiBlindaje2 = devolverMultiplicadorBlindaje(simulador)[1];

        /*
        Para calcular la potencia de fuego relativa, se asignan 50 puntos por cada mm de blindaje que el cañón pueda superar,
        o cero puntos si el blindaje consigue superar la penetración efectiva del cañón.
        */
        potenciaTanque1 = Math.max(Math.floor((penTanque1 * multiPotencia1) - (blindajeEfectivoTanque2 * multiBlindaje2)) * 50, 0);
        potenciaTanque2 = Math.max(Math.floor((penTanque2 * multiPotencia2) - (blindajeEfectivoTanque1 * multiBlindaje1)) * 50, 0);

        return new double[] {potenciaTanque1, potenciaTanque2};

    }

    private double[] devolverBlindajeNominal(Tanque tanque) {

        double[] blindajeNominal = new double[3];

        // La mayoría de vehículos tiene una superficie de impacto efectiva mayor en el chasis que en la torreta
        blindajeNominal[0] = ((tanque.getChasis().getBlindajeFrontal() * 0.75) + (tanque.getTorreta().getBlindajeFrontal() * 0.25));
        blindajeNominal[1] = ((tanque.getChasis().getBlindajeLateral() * 0.75) + (tanque.getTorreta().getBlindajeLateral() * 0.25));
        blindajeNominal[2] = ((tanque.getChasis().getBlindajeTrasero() * 0.75) + (tanque.getTorreta().getBlindajeTrasero() * 0.25));

        return blindajeNominal;
    }

    private double devolverBlindajeEfectivo(double[] blindajeNominal, Terreno terreno) {

        double blindajeEfectivo = 0;

        switch (terreno) {

            case DESIERTO:
                // En el desierto la movilidad es reducida, por lo que el blindaje frontal es más importante
                blindajeEfectivo = (blindajeNominal[0] * 0.75) + (blindajeNominal[1] * 0.15) + (blindajeNominal[2] * 0.1);
                break;

            case BOSQUE:
                // El el bosque la movilidad no es adecuada, pero las oportunidades de flanqueo son mayores debido a la reducción de la visibilidad
                blindajeEfectivo = (blindajeNominal[0] * 0.5) + (blindajeNominal[1] * 0.3) + (blindajeNominal[2] * 0.2);
                break;

            case MONTAÑA:
                // En la montaña las oportunidades de flanqueo son muy reducidas
                blindajeEfectivo = (blindajeNominal[0] * 0.9) + (blindajeNominal[1] * 0.05) + (blindajeNominal[2] * 0.05);
                break;

            case CIUDAD:
                // En la ciudad la movilidad tiende a ser menor, pero las oportunidades de flanqueo son mayores
                blindajeEfectivo = (blindajeNominal[0] * 0.65) + (blindajeNominal[1] * 0.2) + (blindajeNominal[2] * 0.15);
                break;

            default:
                // En la llanura la movilidad es mayor, por lo que el blindaje lateral es más importante
                blindajeEfectivo = (blindajeNominal[0] * 0.6) + (blindajeNominal[1] * 0.3) + (blindajeNominal[2] * 0.1);
        }

        return blindajeEfectivo;

    }

    private int devolverPenetracionPorDistancia(Tanque tanque, Distancia distancia) {

        int penTanque;

        switch (distancia) {

            case CORTA:
                penTanque = tanque.getArma().getPenetracionCorta();
                break;

            case MEDIA:
                penTanque = tanque.getArma().getPenetracionMedia();
                break;

            default:
                penTanque = tanque.getArma().getPenetracionLarga();
                break;
        }

        return penTanque;
    }

    private double[] devolverMultiplicadorPotencia(Simulador simulador) {

        double multiPotencia1 = 1;
        double multiPotencia2 = 1;

        switch (simulador.getDeteccion()) {

            case EMBOSCADA:
                multiPotencia1 = 1.3; // En la mayoría de enfrentamientos, el vehículo que dispara primero es el que gana el enfrentamiento
                multiPotencia2 = 1;
                break;

            default:
                multiPotencia1 = 1;
                multiPotencia2 = 1;
                break;
        }

        return new double[] {multiPotencia1, multiPotencia2};
    }

    private double[] devolverMultiplicadorBlindaje(Simulador simulador) {

        double multiBlindaje1 = 1;
        double multiBlindaje2 = 1;

        switch (simulador.getSituacion()) {

            case DEFENSIVA:
                multiBlindaje1 *= 1.2; // En una posición defensiva, el vehículo puede hacer un uso más eficiente de su blindaje
                multiBlindaje2 *= 0.9;
                break;

            case OFENSIVA:
                multiBlindaje1 *= 0.9; // Cuando se avanza al ataque, el uso efectivo del blindaje disminuye
                multiBlindaje2 *= 1.2;
                break;

            default:
                multiBlindaje1 *= 1;
                multiBlindaje2 *= 1;
                break;
        }

        return new double[] {multiBlindaje1, multiBlindaje2};
    }

    // Este método otorga puntos adicionales al vehículo dependiendo de sus estadísticas de movilidad y del terreno en el que se encuentra
    private double[] calcularMovilidadEfectiva(Simulador simulador) {

        double movilidadTanque1 = 0;
        double movilidadTanque2 = 0;

        /*
        Por lo general, la relación potencia/peso de un vehículo es un buen indicador de su movilidad, sobre todo
        en terrenos difíciles. La velocidad máxima se tiene en cuenta a un menor grado, aunque también otorga puntos.
        En una situación normal, la relación potencia/peso debería dar diez veces más puntos que la velocidad máxima.
        */
        switch (simulador.getTerreno()) {

            // En el desierto la relación potencia/peso es aún más importante
            case DESIERTO:
                movilidadTanque1 = (simulador.getTanque1().getRelacionPotencia() * 10) + (simulador.getTanque1().getMotor().getVelocidadMax() * 0.5);
                movilidadTanque2 = (simulador.getTanque2().getRelacionPotencia() * 10) + (simulador.getTanque2().getMotor().getVelocidadMax() * 0.5);
                break;

            // En el bosque la relación potencia/peso es más importante que la velocidad máxima
            case BOSQUE:
                movilidadTanque1 = (simulador.getTanque1().getRelacionPotencia() * 8) + (simulador.getTanque1().getMotor().getVelocidadMax() * 0.6);
                movilidadTanque2 = (simulador.getTanque2().getRelacionPotencia() * 8) + (simulador.getTanque2().getMotor().getVelocidadMax() * 0.6);
                break;

            // En la montaña la relación potencia/peso es más importante que la velocidad máxima, aunque esta también lo sea
            case MONTAÑA:
                movilidadTanque1 = (simulador.getTanque1().getRelacionPotencia() * 9) + (simulador.getTanque1().getMotor().getVelocidadMax() * 0.6);
                movilidadTanque2 = (simulador.getTanque2().getRelacionPotencia() * 9) + (simulador.getTanque2().getMotor().getVelocidadMax() * 0.6);
                break;

            // En la ciudad la relación potencia/peso es mucho más importante que la velocidad máxima
            case CIUDAD:
                movilidadTanque1 = (simulador.getTanque1().getRelacionPotencia() * 12) + (simulador.getTanque1().getMotor().getVelocidadMax() * 0.3);
                movilidadTanque2 = (simulador.getTanque2().getRelacionPotencia() * 12) + (simulador.getTanque2().getMotor().getVelocidadMax() * 0.3);
                break;

            // En la llanura la velocidad cobra más relevancia
            default:
                movilidadTanque1 = (simulador.getTanque1().getRelacionPotencia() * 6) + (simulador.getTanque1().getMotor().getVelocidadMax());
                movilidadTanque2 = (simulador.getTanque2().getRelacionPotencia() * 6) + (simulador.getTanque2().getMotor().getVelocidadMax());
                break;
        }

        return new double[] {movilidadTanque1, movilidadTanque2};
    }

    private double ajustarPorExperiencia(Tripulante[] tripulacion, double puntuacionTotal) {

        // La experiencia de la tripulación afecta a la efectividad de un vehículo en combate
        double expTotalTripulacion = 0;

        for (Tripulante tripulante : tripulacion) {

            expTotalTripulacion += (tripulante.getExperiencia() / 100);

        }

        double expMediaTripulacion = expTotalTripulacion / tripulacion.length;

        return puntuacionTotal * expMediaTripulacion;
        
    }
}
