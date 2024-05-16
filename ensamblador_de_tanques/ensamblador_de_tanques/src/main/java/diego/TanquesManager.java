package diego;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class TanquesManager {

    private static final String CARPETA = "ensamblador_de_tanques\\src\\main\\java\\diego\\tanques_guardados";

    public static void guardarTanque(Tanque tanque, String nomArchivo) {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA + "\\" + nomArchivo + ".dat"));
            oos.writeObject(tanque);
            oos.close();

        } catch (IOException e) {

            e.printStackTrace();
            // Logger.error("Error al guardar tanque");
            System.out.println("No se ha podido guardar el vehículo.");

        }
    }

    public static Tanque cargarTanque(String nomArchivo) {

        Tanque tanqueARetornar = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARPETA + "\\" + nomArchivo + ".dat"))) {

            tanqueARetornar = (Tanque) ois.readObject();
            
        } catch (IOException e) {

            e.printStackTrace();
            // Logger.error("Error al leer el archivo del tanque");
            System.out.println("No se ha podido cargar el vehículo.");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
            // Logger.error("No se ha podido castear a tanque");
            System.out.println("No se ha podido cargar el vehículo.");

        }

        return tanqueARetornar;
 
    }

    public static void borrarTanque(String nomArchivo) {

        File archivo = new File(CARPETA + "\\" + nomArchivo + ".dat");

        if (archivo.exists()) {

            archivo.delete();

        } else {

            // Logger.error("No se ha encontrado el archivo");
            System.out.println("No se ha encontrado el archivo.");

        }

    }

    public static String listarTanques() {

        File carpeta = new File(CARPETA);
        StringBuilder sb = new StringBuilder();

        File[] archivos = carpeta.listFiles();
        ArrayList<File> elementos = new ArrayList<>(Arrays.asList(archivos));

        if (elementos.size() == 0) {

            // Logger.info("No hay tanques guardados");
            System.out.println("No hay vehículos guardados.");

        } else {

            sb.append("Listado de tanques disponibles:\n");

            Collections.sort(elementos);
            Iterator<File> it = elementos.iterator();

            while (it.hasNext()) {

                File archivo = it.next();
                String nombre = archivo.getName();
                sb.append(nombre.substring(0, nombre.length() - 4) + "\n");

            }

        }

        return sb.toString();

    }
}
