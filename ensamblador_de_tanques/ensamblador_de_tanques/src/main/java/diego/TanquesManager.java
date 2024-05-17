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
