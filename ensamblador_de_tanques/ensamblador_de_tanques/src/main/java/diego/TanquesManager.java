package diego;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

public class TanquesManager {

    private TanquesManager() {
        // Nadie puede instanciar esta clase
    }

    private static final String CARPETA_TANQUES = "ensamblador_de_tanques\\src\\main\\java\\diego\\tanques_guardados";
    private static final String CARPETA_RES = "ensamblador_de_tanques\\src\\main\\java\\diego\\resultados_simulacion";
    private static Logger log = Logger.getLogger(TanquesManager.class.getName());

    public static void guardarTanque(Tanque tanque, String nomArchivo) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA_TANQUES + "\\" + nomArchivo + ".dat"))) {

            oos.writeObject(tanque);

        } catch (IOException e) {

            log.error("Error al guardar un vehículo");
            System.out.println("No se ha podido guardar el vehículo.");

        }
    }

    public static Tanque cargarTanque(String nomArchivo) {

        Tanque tanqueARetornar = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARPETA_TANQUES + "\\" + nomArchivo + ".dat"))) {

            tanqueARetornar = (Tanque) ois.readObject();
            
        } catch (IOException e) {

            log.error("Error de entrada/salida al cargar un vehículo");
            System.out.println("No se ha podido cargar el vehículo.");
            System.exit(0);

        } catch (ClassNotFoundException e) {

            log.error("Error al cargar un vehículo, clase no encontrada");
            System.out.println("No se ha podido cargar el vehículo.");
            System.exit(0);

        }

        return tanqueARetornar;
 
    }

    public static String borrarTanque(String nomArchivo) {

        File archivo = new File(CARPETA_TANQUES + "\\" + nomArchivo + ".dat");
        boolean exito = false;

        if (archivo.exists()) {

            exito = archivo.delete();

        }

        if (exito) {

            return "Borrado con éxito.";

        } else {

            return "Fallo al borrar. Asegúrese que el nombre del archivo coincide con el nombre introducido.";
            
        }

    }

    public static String listarTanques() {

        File carpeta = new File(CARPETA_TANQUES);
        StringBuilder sb = new StringBuilder();

        File[] archivos = carpeta.listFiles();

        if (archivos == null || archivos.length == 0) {

            System.out.println("No hay vehículos guardados.");
            return "";

        }

        ArrayList<File> elementos = new ArrayList<>(Arrays.asList(archivos));

        sb.append("Listado de tanques disponibles:\n");
        Collections.sort(elementos);
        Iterator<File> it = elementos.iterator();
        int n = 1;

        while (it.hasNext()) {

            File archivo = it.next();
            String nombre = archivo.getName();
            sb.append(n + ". ");
            sb.append(nombre.substring(0, nombre.length() - 4)).append("\n");
            n++;

        }

        return sb.toString();
    }

    public static void guardarResultado(String nomArch, String contenido) {

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormat = fechaActual.format(formatter);

        String nombreCompleto = fechaFormat + " " + nomArch;

        File nuevoResultado = new File(CARPETA_RES, nombreCompleto + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nuevoResultado))) {

            writer.write(contenido);

        } catch (IOException e) {

            log.error("Error al guardar un resultado");
            System.out.println("No se ha podido guardar el resultado.");

        }
    }

    public static String listarResultados() {

        File carpeta = new File(CARPETA_RES);
        StringBuilder sb = new StringBuilder();

        File[] archivos = carpeta.listFiles();

        if (archivos == null || archivos.length == 0) {

            System.out.println("No hay resultados de batallas.");
            return "";

        }

        ArrayList<File> elementos = new ArrayList<>(Arrays.asList(archivos));

        sb.append("Listado de resultados:\n");
        Collections.sort(elementos);
        Iterator<File> it = elementos.iterator();
        int n = 1;

        while (it.hasNext()) {

            File archivo = it.next();
            String nombre = archivo.getName();
            sb.append(n + ". ");
            sb.append(nombre.substring(0, nombre.length() - 4)).append("\n");
            n++;

        }

        return sb.toString();
    }

    public static String leerResultado(String nomArchivo) {

        File archivo = new File(CARPETA_RES + "\\" + nomArchivo + ".txt");
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = reader.readLine()) != null) {

                sb.append(linea).append("\n");

            }

        } catch (IOException e) {

            log.error("Error al leer un resultado");
            System.out.println("No se ha podido leer el resultado.");
            System.exit(0);

        }

        return sb.toString();
    }
}
