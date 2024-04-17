import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColeccionAlumnos<T> implements Iterable<T> {

    private List<T> alumnos = new ArrayList<>();

    public void anadirAlumno(T alumno) {

        alumnos.add(alumno);

    }

    @Override
    public Iterator<T> iterator() {

        return alumnos.iterator();
        
    }

    public List<T> getAlumnos() {

        return alumnos;
        
    }
}
