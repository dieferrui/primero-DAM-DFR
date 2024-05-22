package diego;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import org.apache.log4j.Logger;

public class TanquesManager {

    private static final String CARPETA = "ensamblador_de_tanques\\src\\main\\java\\diego\\tanques_guardados";
    private static Logger log = Logger.getLogger(TanquesManager.class.getName());

    public static void guardarTanque(Tanque tanque, String nomArchivo) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA + "\\" + nomArchivo + ".dat"))) {

            oos.writeObject(tanque);

        } catch (IOException e) {

            log.error("Error al guardar un vehículo");
            System.out.println("No se ha podido guardar el vehículo.");

        }
    }

    public static Tanque cargarTanque(String nomArchivo) {

        Tanque tanqueARetornar = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARPETA + "\\" + nomArchivo + ".dat"))) {

            tanqueARetornar = (Tanque) ois.readObject();
            
        } catch (IOException e) {

            log.error("Error de entrada/salida al cargar un vehículo");
            System.out.println("No se ha podido cargar el vehículo.");

        } catch (ClassNotFoundException e) {

            log.error("Error al cargar un vehículo, clase no encontrada");
            System.out.println("No se ha podido cargar el vehículo.");

        }

        return tanqueARetornar;
 
    }

    public static String borrarTanque(String nomArchivo) {

        File archivo = new File(CARPETA + "\\" + nomArchivo + ".dat");
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

        File carpeta = new File(CARPETA);
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
}
