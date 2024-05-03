public class Estudiante implements Comparable<Estudiante> {

    private String nombre;
    private String apellidos;
    private String fechaNac;
    private double notaMedia;

    public Estudiante(String nombre, String apellidos, String fechaNac, double notaMedia) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.notaMedia = notaMedia;

    }

    @Override
    public int compareTo(Estudiante otroEstudiante) {

        int comparacionApellidos = this.apellidos.compareTo(otroEstudiante.apellidos);

        if (comparacionApellidos == 0) {
            
            return this.nombre.compareTo(otroEstudiante.nombre);

        } else {

            return comparacionApellidos;

        }

    }

    @Override
    public String toString() {

        return "Estudiante " + nombre + " " + apellidos + " {Fecha Nacimiento: " + fechaNac + ", Nota Media: " + notaMedia + "}";

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public double getNotaMedia() {
        return notaMedia;
    }
    
}
