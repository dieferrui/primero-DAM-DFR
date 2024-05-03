import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FileManager {

    public static LinkedList<Estudiante> generarListaEstudiantes() {

        LinkedList<Estudiante> estudiantes = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("estudiantes.txt"))) {
            
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                String nombreEst = datos[0].trim();
                String apellidosEst = datos[1].trim();
                String fechaNacEst = datos[2].trim();
                double notaMediaEst = Double.parseDouble(datos[3].trim());

                Estudiante estudiante = new Estudiante(nombreEst, apellidosEst, fechaNacEst, notaMediaEst);
                estudiantes.add(estudiante);
            }

        } catch (IOException e) {
            
            e.printStackTrace();
        
        }

        return estudiantes;
        
    }
}
