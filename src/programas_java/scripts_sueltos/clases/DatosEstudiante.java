public class DatosEstudiante {
    
    public static void main(String[] args) {

        Estudiante kebab = new Estudiante("Kebab Amigo", "Cocina", 21);
        Estudiante shur = new Estudiante("El sebs", "Jardinería", 19);
        Estudiante diegoF = new Estudiante("Diego Fernandez", "DAM", 26);

        Estudiante.displayInfo(diegoF.nombre, diegoF.grado, diegoF.edad);
        System.out.println();
        Estudiante.displayInfo(kebab.nombre, kebab.grado, kebab.edad);
        System.out.println();
        Estudiante.displayInfo(shur.nombre, shur.grado, shur.edad);
        System.out.println();
    }

    static class Estudiante {

        String nombre;
        String grado;
        int edad;
        
        public Estudiante(String nombre, String grado, int edad) {

            this.nombre = nombre;
            this.grado = grado;
            this.edad = edad;
        }

        public static void displayInfo(String nombre, String grado, int edad) {
            
            System.out.printf("El estudiante %s, de %d años de edad, cursa el grado de %s.", nombre, edad, grado);
        }
    }
}
