public class Alumno {
    
    private String nombre;
    private String dni;
    private double notaMedia;

    public Alumno(String nombre, String dni, double notaMedia) {

        this.nombre = nombre;
        this.dni = dni;
        this.notaMedia = notaMedia;

    }

    @Override
    public String toString() {

        return "Alumno/Nombre=" + nombre + "/DNI=" + dni + "/NotaMedia=" + notaMedia;
        
    }

    
}
