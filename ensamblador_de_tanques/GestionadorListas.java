package programacion.tercera_evaluacion.ejercicio_final;

// TODO Reutilizar esta clase para cargar mis propios datos

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestionadorListas {
    private static final String rutaFicheroLucha = "src/programacion/tercera_evaluacion/ejercicio_final/luchadores.csv";
    static Logger LOGGER = LogManager.getRootLogger();
    static ArrayList<Luchador> listaLuchadores = new ArrayList<>();
    static ArrayList<Luchador> listaLuchadoresFlyWeight = new ArrayList<>();
    static ArrayList<Luchador> listaLuchadoresBantamWeight = new ArrayList<>();
    static ArrayList<Luchador> listaLuchadoresFeatherWeight = new ArrayList<>();
    static ArrayList<Luchador> listaLuchadoresLightWeight = new ArrayList<>();
    static ArrayList<Luchador> listaLuchadoresWelterWeight = new ArrayList<>();
    static ArrayList<Luchador> listaLuchadoresMiddleWeight = new ArrayList<>();
    static ArrayList<Luchador> listaLuchadoresLightHeavyWeight = new ArrayList<>();
    static ArrayList<Luchador> listaLuchadoresHeavyWeight = new ArrayList<>();


    public static ArrayList<Luchador> getListaLuchadores() {
        return listaLuchadores;
    }

    public static void setListaLuchadores(ArrayList<Luchador> listaLuchadores) {
        GestionadorListas.listaLuchadores = listaLuchadores;
    }

    public static ArrayList<Luchador> getListaLuchadoresFlyWeight() {
        return listaLuchadoresFlyWeight;
    }

    public static void setListaLuchadoresFlyWeight(ArrayList<Luchador> listaLuchadoresFlyWeight) {
        GestionadorListas.listaLuchadoresFlyWeight = listaLuchadoresFlyWeight;
    }

    public static ArrayList<Luchador> getListaLuchadoresBantamWeight() {
        return listaLuchadoresBantamWeight;
    }

    public static void setListaLuchadoresBantamWeight(ArrayList<Luchador> listaLuchadoresBantamWeight) {
        GestionadorListas.listaLuchadoresBantamWeight = listaLuchadoresBantamWeight;
    }

    public static ArrayList<Luchador> getListaLuchadoresFeatherWeight() {
        return listaLuchadoresFeatherWeight;
    }

    public static void setListaLuchadoresFeatherWeight(ArrayList<Luchador> listaLuchadoresFeatherWeight) {
        GestionadorListas.listaLuchadoresFeatherWeight = listaLuchadoresFeatherWeight;
    }

    public static ArrayList<Luchador> getListaLuchadoresLightWeight() {
        return listaLuchadoresLightWeight;
    }

    public static void setListaLuchadoresLightWeight(ArrayList<Luchador> listaLuchadoresLightWeight) {
        GestionadorListas.listaLuchadoresLightWeight = listaLuchadoresLightWeight;
    }

    public static ArrayList<Luchador> getListaLuchadoresWelterWeight() {
        return listaLuchadoresWelterWeight;
    }

    public static void setListaLuchadoresWelterWeight(ArrayList<Luchador> listaLuchadoresWelterWeight) {
        GestionadorListas.listaLuchadoresWelterWeight = listaLuchadoresWelterWeight;
    }

    public static ArrayList<Luchador> getListaLuchadoresMiddleWeight() {
        return listaLuchadoresMiddleWeight;
    }

    public static void setListaLuchadoresMiddleWeight(ArrayList<Luchador> listaLuchadoresMiddleWeight) {
        GestionadorListas.listaLuchadoresMiddleWeight = listaLuchadoresMiddleWeight;
    }

    public static ArrayList<Luchador> getListaLuchadoresLightHeavyWeight() {
        return listaLuchadoresLightHeavyWeight;
    }

    public static void setListaLuchadoresLightHeavyWeight(ArrayList<Luchador> listaLuchadoresLightHeavyWeight) {
        GestionadorListas.listaLuchadoresLightHeavyWeight = listaLuchadoresLightHeavyWeight;
    }

    public static ArrayList<Luchador> getListaLuchadoresHeavyWeight() {
        return listaLuchadoresHeavyWeight;
    }

    public static void setListaLuchadoresHeavyWeight(ArrayList<Luchador> listaLuchadoresHeavyWeight) {
        GestionadorListas.listaLuchadoresHeavyWeight = listaLuchadoresHeavyWeight;
    }

    public static ArrayList cargarListasLuchadores() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(rutaFicheroLucha));
            bufferedReader.readLine();
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] datosLuchador = linea.split(";");

                Luchador luchador = new Luchador(datosLuchador[0],  // Division
                        Integer.parseInt(datosLuchador[1]),  // Rank
                        datosLuchador[2],  // Nombre
                        Integer.parseInt(datosLuchador[3]),  // Edad
                        Double.parseDouble(datosLuchador[4]),  // Peso
                        Double.parseDouble(datosLuchador[5]),  // Altura
                        Integer.parseInt(datosLuchador[6]),  // Victorias
                        Integer.parseInt(datosLuchador[7]),  // Derrotas
                        Integer.parseInt(datosLuchador[8]),  // Alcance
                        datosLuchador[9],  // Estilo
                        Double.parseDouble(datosLuchador[10]),  // Golpes Lanzados Por Minuto
                        Integer.parseInt(datosLuchador[11]),  // Precision Golpeo
                        Integer.parseInt(datosLuchador[12]),  // Alcance Pierna
                        Double.parseDouble(datosLuchador[13]),  // Golpes Significativos Absorbidos Por Minuto
                        Double.parseDouble(datosLuchador[14]),  // Promedio Derribos
                        Integer.parseInt(datosLuchador[15]),  // Defensa Derribos
                        Double.parseDouble(datosLuchador[16]),  // Promedio Sumisiones
                        Integer.parseInt(datosLuchador[17]),  // Defensa Sumisiones
                        Integer.parseInt(datosLuchador[18]),  // Ratio Knockout
                        datosLuchador[19],
                        Integer.parseInt(datosLuchador[20])// Postura Luchador

                );
                luchador.setDivision(datosLuchador[0]);
                luchador.setRango(Integer.parseInt(datosLuchador[1]));
                luchador.setNombre(datosLuchador[2]);
                luchador.setEdad(Integer.parseInt(datosLuchador[3]));
                luchador.setPeso(Double.parseDouble(datosLuchador[4]));
                luchador.setAltura(Double.parseDouble(datosLuchador[5]));
                luchador.setVictorias(Integer.parseInt(datosLuchador[6]));
                luchador.setDerrotas(Integer.parseInt(datosLuchador[7]));
                luchador.setAlcance(Integer.parseInt(datosLuchador[8]));
                luchador.setEstilo(datosLuchador[9]);
                luchador.setGolpesLanzadosPorMinuto(Double.parseDouble(datosLuchador[10]));
                luchador.setPrecisionGolpeo(Integer.parseInt(datosLuchador[11]));
                luchador.setAlcancePierna(Integer.parseInt(datosLuchador[12]));
                luchador.setGolpesSignificativosAbsorbidosPorMinuto(Double.parseDouble(datosLuchador[13]));
                luchador.setPromedioDerribos(Double.parseDouble(datosLuchador[14]));
                luchador.setDefensaDerribos(Integer.parseInt(datosLuchador[15]));
                luchador.setPromedioSumisiones(Double.parseDouble(datosLuchador[16]));
                luchador.setDefensaSumisiones(Integer.parseInt(datosLuchador[17]));
                luchador.setRatioKnockout(Integer.parseInt(datosLuchador[18]));
                luchador.setPosturaLuchador(datosLuchador[19]);
                luchador.setVida(Integer.parseInt(datosLuchador[20]));

                if (luchador.getDivision().equalsIgnoreCase("flyweight")) {

                    listaLuchadoresFlyWeight.add(luchador);

                } else if (luchador.getDivision().equalsIgnoreCase("bantamweight")) {

                    listaLuchadoresBantamWeight.add(luchador);

                } else if (luchador.getDivision().equalsIgnoreCase("featherweight")) {

                    listaLuchadoresFeatherWeight.add(luchador);

                } else if (luchador.getDivision().equalsIgnoreCase("lightweight")) {

                    listaLuchadoresLightWeight.add(luchador);
                } else if (luchador.getDivision().equalsIgnoreCase("middleweight")) {

                    listaLuchadoresMiddleWeight.add(luchador);
                } else if (luchador.getDivision().equalsIgnoreCase("welterweight")) {

                    listaLuchadoresWelterWeight.add(luchador);
                } else if (luchador.getDivision().equalsIgnoreCase("light heavyweight")) {

                    listaLuchadoresLightHeavyWeight.add(luchador);
                } else if (luchador.getDivision().equalsIgnoreCase("heavyweight")) {

                    listaLuchadoresHeavyWeight.add(luchador);
                }


                listaLuchadores.add(luchador);

            }
            bufferedReader.close();

            setListaLuchadores(listaLuchadores);
            setListaLuchadoresFlyWeight(listaLuchadoresFlyWeight);
            setListaLuchadoresBantamWeight(listaLuchadoresBantamWeight);
            setListaLuchadoresFeatherWeight(listaLuchadoresFeatherWeight);
            setListaLuchadoresLightWeight(listaLuchadoresLightWeight);
            setListaLuchadoresMiddleWeight(listaLuchadoresMiddleWeight);
            setListaLuchadoresWelterWeight(listaLuchadoresWelterWeight);
            setListaLuchadoresLightHeavyWeight(listaLuchadoresLightHeavyWeight);
            setListaLuchadoresHeavyWeight(listaLuchadoresHeavyWeight);

        } catch (FileNotFoundException e) {

            LOGGER.error("ERROR: El fichero no ha sido encontrado" + e.getMessage());
        } catch (
                IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return listaLuchadores;
    }
}
