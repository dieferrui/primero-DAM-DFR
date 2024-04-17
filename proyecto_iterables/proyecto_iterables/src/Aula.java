import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Aula<Alumno> implements Iterable<Alumno> {

    private List<Alumno> alumnos = new ArrayList<>();

    public void anadirAlumno(Alumno alumno) {

        alumnos.add(alumno);

    }

    @Override
    public Iterator<Alumno> iterator() {

        return alumnos.iterator();
        
    }

    public List<Alumno> getAlumnos() {

        return alumnos;
        
    }
}
