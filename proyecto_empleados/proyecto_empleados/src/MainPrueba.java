import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainPrueba {

    static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        
        Map<Integer, Empleado> empleados = new HashMap<>();
        String mainSelect;
        
        Empleado emple1 = new Empleado("Juanfencio", "Conserje");
        Empleado emple2 = new Empleado("Fulgencio", "Secretario");
        Empleado emple3 = new Empleado("Frigencio", "Secretario");
        Empleado emple4 = new Empleado("Armagencio", "Informático");
        Empleado emple5 = new Empleado("Baromencio", "Informático");
        Empleado emple6 = new Empleado("Carmencio", "Informático");
        Empleado emple7 = new Empleado("Purlencio", "Informático");
        Empleado emple8 = new Empleado("Salafencio", "Informático");
        Empleado emple9 = new Empleado("Turlencio", "Administrativo");
        Empleado emple10 = new Empleado("Jefonencio", "Directivo");

        empleados.put(10, emple1);
        empleados.put(20, emple2);
        empleados.put(21, emple3);
        empleados.put(30, emple4);
        empleados.put(31, emple5);
        empleados.put(32, emple6);
        empleados.put(33, emple7);
        empleados.put(34, emple8);
        empleados.put(40, emple9);
        empleados.put(90, emple10);

        do {
            
            System.out.println("Sistema de gestión de empleados");
            System.out.println("Qué desea hacer?\n1. Ver empleados\n"
                            + "2. Agregar empleados\n3. Eliminar empleados\n4. Salir");
            mainSelect = SC.nextLine();

            switch (mainSelect) {

                case "1": verEmpleados(empleados); break;
                case "2": agregarEmpleado(empleados); break;
                case "3": eliminarEmpleado(empleados); break;
                default: break;
            }


        } while (!mainSelect.equals("4"));

    }

    public static void verEmpleados(Map<Integer, Empleado> empleados) {

        System.out.println("Lista de empleados:");

        for (Map.Entry<Integer, Empleado> empleado : empleados.entrySet()) {
            System.out.println("ID " + empleado.toString());
        }

        System.out.println();

    }

    public static void agregarEmpleado(Map<Integer, Empleado> empleados) {

        int id = 0;
 
        try {

            do {
                
                System.out.println("Introduzca el ID del empleado:");
                id = Integer.parseInt(SC.nextLine());

                if (empleados.containsKey(id)) {
                    System.out.println("El ID ya existe.");
                }

            } while (empleados.containsKey(id));

        } catch (NumberFormatException e) {
                
            System.out.println("El ID debe ser un número entero.");
    
        }

        System.out.println("Introduzca el nombre del empleado:");
        String nombre = SC.nextLine();

        System.out.println("Introduzca la posición del empleado:");
        String posicion = SC.nextLine();

        Empleado empleado = new Empleado(nombre, posicion);
        empleados.put(id, empleado);

        

        System.out.println();

    }

    public static void eliminarEmpleado(Map<Integer, Empleado> empleados) {

        try {
            
            System.out.println("Introduzca el ID del empleado a eliminar:");
            int id = Integer.parseInt(SC.nextLine());

            empleados.remove(id);

        } catch (NumberFormatException e) {

            System.out.println("El ID debe ser un número entero.");

        } catch (NullPointerException e) {

            System.out.println("El ID no puede ser nulo.");

        }

        System.out.println();

    }
}
