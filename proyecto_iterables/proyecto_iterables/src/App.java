import java.util.ArrayList;
import java.util.Iterator;

public class App {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> arrayInts = new ArrayList<>();
        
        @SuppressWarnings("rawtypes")
        Iterator iterando = arrayInts.iterator();

        for (int i = 0; i < 100; i++) {

            arrayInts.add(i);

        }

        while (iterando.hasNext()) {

            System.out.println(iterando.next());

        }

        Alumno diego = new Alumno("Diego", "123F", 10);
        Alumno filca = new Alumno("Filca", "456G", 8);
        Alumno castilla = new Alumno("Alejandro", "789H", 8);
        ColeccionAlumnos damCheste = new ColeccionAlumnos();

        damCheste.anadirAlumno(diego);
        damCheste.anadirAlumno(filca);
        damCheste.anadirAlumno(castilla);

        for (Object alumno : damCheste.getAlumnos()) {

            System.out.println(alumno.toString());
            
        }
    }
}