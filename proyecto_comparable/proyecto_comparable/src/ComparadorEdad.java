import java.util.Comparator;

class ComparadorEdad implements Comparator<Estudiante> {

    public int compare(Estudiante estudiante1, Estudiante estudiante2) {

        int compareDate = estudiante1.getFechaNac().compareTo(estudiante2.getFechaNac());

        if (compareDate == 0) {

            return estudiante1.getNombre().compareTo(estudiante2.getNombre());

        } else {

            return compareDate;

        }
    }
}