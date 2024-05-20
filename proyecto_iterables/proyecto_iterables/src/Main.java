import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws Exception {

        // Ejercicio 1
        IteraLista.iterarNormal();

        System.out.println();

        // Ejercicio 2
        Aula alumnos = new Aula<>();
        
        alumnos.anadirAlumno(new Alumno("Alexandr", "456B", 19, "DAM", 9));
        alumnos.anadirAlumno(new Alumno("Alejandro", "789C", 19, "DAM", 8));
        alumnos.anadirAlumno(new Alumno("Nacho", "066D", 19, "DAM", 9));
        alumnos.anadirAlumno(new Alumno("Diego", "123A", 27, "DAM", 10));

        Iterator iterador = alumnos.iterator();

        while (iterador.hasNext()) {

            System.out.println(iterador.next());

        }
    }
}
