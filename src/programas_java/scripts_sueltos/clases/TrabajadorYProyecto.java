import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorYProyecto {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int numTrabajadores;

        System.out.println("¿De cuántos trabajadores vamos a manejar la información?");
        numTrabajadores = sc.nextInt();

    }

    static class Trabajador {

        private String nombre;
        private int edad;
        private int sueldo;
        private Proyecto proyecto;

        public Trabajador(String nombre, int edad, int sueldo, Proyecto proyecto) {
            this.nombre = nombre;
            this.edad = edad;
            this.sueldo = sueldo;
            this.proyecto = proyecto;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public void setSueldo(int sueldo) {
            this.sueldo = sueldo;
        }

        public void setProyecto(Proyecto proyecto) {
            this.proyecto = proyecto;
        }

    }

    static class Proyecto {

        private String nombre;
        private String descripcion;

        public Proyecto(String nombre, String descripcion) {

            this.nombre = nombre;
            this.descripcion = descripcion;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEdad(String descripcion) {
            this.descripcion = descripcion;
        }
    }

    public static List<String> generaTrabajadores(int numTrabajadores) {

        ArrayList<String> listaTrabajadores = new ArrayList<String>();
        String descripcionTrabajador;

        for (int i = 0; i < numTrabajadores; i++) {
            
            definirDatos(i);

            descripcionTrabajador = "" + trabajador.getNombre() + trabajador.getEdad() + trabajador.getSueldo() + trabajador.getProyecto().getNomProy() + trabajador.getProyecto().getDesc() + "";
            
            listaTrabajadores.add() 
        }
    }

    private static Trabajador definirDatos(int i) {

        String nomTrabajador;
        int edadTrabajador;
        int sueldoTrabajador;
        Proyecto proyectoTrabajador;
        
        System.out.println("Vamos a definir los datos del trabajador " + (i + 1) + " .");
            
        System.out.println("Introduzca el nombre del trabajador: ");
        nomTrabajador = sc.nextLine();

        System.out.println("¿Cuál es la edad de este trabajador?");
        edadTrabajador = sc.nextInt();

        System.out.println("¿Cuál es el sueldo de este trabajador?");
        sueldoTrabajador = sc.nextInt();

        System.out.println("Vamos a detallar el proyecto en el que está trabajando este trabajador:");
        proyectoTrabajador = definirProyecto();

        Trabajador trabajador = new Trabajador(nomTrabajador, edadTrabajador, sueldoTrabajador, proyectoTrabajador);

        return trabajador;
    }

    private static Proyecto definirProyecto() {

        String nomProyecto;
        String descripProyecto;

        System.out.println("Introduzca el nombre del proyecto: ");
        nomProyecto = sc.nextLine();

        System.out.println("Introduzca la descripción del proyecto: ");
        descripProyecto = sc.nextLine();

        Proyecto proyecto = new Proyecto(nomProyecto, descripProyecto);

        return proyecto;
    }
}
