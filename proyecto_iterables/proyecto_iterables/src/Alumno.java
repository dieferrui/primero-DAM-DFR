public class Alumno {
    
    private String nombre;
    private String nia;
    private int edad;
    private String curso;
    private double notaMedia;

    public Alumno(String nombre, String nia, int edad, String curso, double notaMedia) {

        this.nombre = nombre;
        this.nia = nia;
        this.edad = edad;
        this.curso = curso;
        this.notaMedia = notaMedia;

    }

    @Override
    public String toString() {

        return "Alumno/Nombre=" + nombre + "/NIA=" + nia + "/Edad=" + edad + "/Curso=" + curso + "/NotaMedia=" + notaMedia;

    }

    
}
