import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws Exception {

        IteraLista.iterarNormal();

        Aula alumnos = new Aula<>();
        Iterator iterador = alumnos.iterator();

        alumnos.anadirAlumno(new Alumno("Diego", "123A", 27, "DAM", 10));
        alumnos.anadirAlumno(new Alumno("Alexandr", "456B", 19, "DAM", 9));
        alumnos.anadirAlumno(new Alumno("Alejandro", "789C", 19, "DAM", 8));
        alumnos.anadirAlumno(new Alumno("Nacho", "066D", 19, "DAM", 9));


        while (iterador.hasNext()) {

            System.out.println(iterador.next());
            
        }
    }
}
