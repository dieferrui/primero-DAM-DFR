package diego;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import diego.componentes.*;
import diego.componentes.enums.*;
import diego.enums_general.Paises;

public class ControlComponentes {

    private static final String ARCHIVO_CHASIS = "ensamblador_de_tanques\\src\\main\\java\\diego\\componentes_guardados\\chasis.csv";
    private static final String ARCHIVO_MOTORES = "ensamblador_de_tanques\\src\\main\\java\\diego\\componentes_guardados\\motores.csv";
    private static final String ARCHIVO_TORRES = "ensamblador_de_tanques\\src\\main\\java\\diego\\componentes_guardados\\torres.csv";
    private static final String ARCHIVO_ARMAS = "ensamblador_de_tanques\\src\\main\\java\\diego\\componentes_guardados\\armas.csv";

    protected Map<String, Chassis> mapaChasis = new HashMap<>();
    protected Map<String, Armamento> mapaArmas = new HashMap<>();
    protected Map<String, Motor> mapaMotores = new HashMap<>();
    protected Map<String, Torreta> mapaTorretas = new HashMap<>();

    // El constructor crea una instancia con los componentes especificados
    public ControlComponentes() {

        agregarComponentes();

    }

    public void agregarComponentes() {

        // Agregar chasis desde CSV
        try {

            BufferedReader brChasis = new BufferedReader(new FileReader(ARCHIVO_CHASIS));
            brChasis.readLine();
            String linea;

            while ((linea = brChasis.readLine()) != null) {

                String[] datosChasis = linea.split(";");

                Chassis chasis = new Chassis(

                    datosChasis[1], // Designación
                    generarPaises(datosChasis[2]), // Usuarios
                    Double.parseDouble(datosChasis[3]), // Peso
                    Double.parseDouble(datosChasis[4]), // Carga
                    generarBlindajes(datosChasis[5]) // Blindaje

                );

                mapaChasis.put(datosChasis[0], chasis);

            }

            brChasis.close();

        } catch (FileNotFoundException e) {

            // LOGGER.error("ERROR: El fichero no ha sido encontrado" + e.getMessage());
            System.out.println("El fichero chasis no ha sido encontrado");

        } catch (IOException e) {

            // LOGGER.error(ex.getMessage());
            System.out.println("Error de lectura/escritura en el fichero motores");

        }

        // Agregar motores desde CSV
        try {

            BufferedReader brMotor = new BufferedReader(new FileReader(ARCHIVO_MOTORES));
            brMotor.readLine();
            String linea;

            while ((linea = brMotor.readLine()) != null) {

                String[] datosMotor = linea.split(";");

                Motor motor = new Motor(

                    datosMotor[1], // Designación
                    generarPaises(datosMotor[2]), // Usuarios
                    Double.parseDouble(datosMotor[3]), // Peso
                    Double.parseDouble(datosMotor[4]), // Velocidad Máxima
                    Integer.parseInt(datosMotor[5]) // Potencia

                );

                mapaMotores.put(datosMotor[0], motor);

            }

            brMotor.close();

        } catch (FileNotFoundException e) {

            // LOGGER.error("ERROR: El fichero no ha sido encontrado" + e.getMessage());
            System.out.println("El fichero de motores no ha sido encontrado");

        } catch (IOException e) {

            // LOGGER.error(ex.getMessage());
            System.out.println("Error de lectura/escritura en el fichero motores");

        }

        // Agregar torretas desde CSV
        try {

            BufferedReader brTorres = new BufferedReader(new FileReader(ARCHIVO_TORRES));
            brTorres.readLine();
            String linea;

            while ((linea = brTorres.readLine()) != null) {

                String[] datosTorre = linea.split(";");

                Torreta torre = new Torreta(

                    datosTorre[1], // Designación
                    generarPaises(datosTorre[2]), // Usuarios
                    Double.parseDouble(datosTorre[3]), // Peso
                    TipoTorreta.valueOf(datosTorre[4]), // Tipo de torreta
                    generarRestricciones(datosTorre[5]), // Restricciones de tiro
                    generarBlindajes(datosTorre[6]) // Blindaje

                );

                mapaTorretas.put(datosTorre[0], torre);

            }

            brTorres.close();

        } catch (FileNotFoundException e) {

            // LOGGER.error("ERROR: El fichero no ha sido encontrado" + e.getMessage());
            System.out.println("El fichero de torretas no ha sido encontrado");

        } catch (IOException e) {

            // LOGGER.error(ex.getMessage());
            System.out.println("Error de lectura/escritura en el fichero torretas");

        }

        // Agregar armas desde CSV
        try {

            BufferedReader brArmas = new BufferedReader(new FileReader(ARCHIVO_ARMAS));
            brArmas.readLine();
            String linea;

            while ((linea = brArmas.readLine()) != null) {

                String[] datosArma = linea.split(";");

                Armamento arma = new Armamento(

                    datosArma[1], // Designación
                    generarPaises(datosArma[2]), // Usuarios
                    Double.parseDouble(datosArma[3]), // Peso
                    ClaseArmamento.valueOf(datosArma[4]), // Clase de armamento
                    generarBlindajes(datosArma[5]), // Penetración
                    Integer.parseInt(datosArma[6]), // Calibre
                    Municion.valueOf(datosArma[7]) // Tipo de munición

                );

                mapaArmas.put(datosArma[0], arma);

            }

            brArmas.close();

        } catch (FileNotFoundException e) {

            // LOGGER.error("ERROR: El fichero no ha sido encontrado" + e.getMessage());
            System.out.println("El fichero de torretas no ha sido encontrado");

        } catch (IOException e) {

            // LOGGER.error(ex.getMessage());
            System.out.println("Error de lectura/escritura en el fichero torretas");

        }
    }

    public ArrayList<Paises> generarPaises(String paisesChasis) {

        ArrayList<Paises> listaPaises = new ArrayList<>();

        String[] paisesArray = paisesChasis.split(",");

        for (String pais : paisesArray) {

            listaPaises.add(Paises.valueOf(pais));

        }

        return listaPaises;

    }

    public int[] generarBlindajes(String blindajes) {

        int[] blindajesArray = new int[3];

        String[] blindajesString = blindajes.split(",");

        for (int i = 0; i < blindajesString.length; i++) {

            blindajesArray[i] = Integer.parseInt(blindajesString[i]);

        }

        return blindajesArray;

    }

    public double[] generarRestricciones(String restricciones) {

        double[] restriccionesArray = new double[3];

        String[] restriccionesString = restricciones.split(",");

        for (int i = 0; i < restriccionesString.length; i++) {

            restriccionesArray[i] = Double.parseDouble(restriccionesString[i]);

        }

        return restriccionesArray;

    }
}
