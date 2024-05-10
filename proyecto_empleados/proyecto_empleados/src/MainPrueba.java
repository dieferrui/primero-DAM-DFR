import java.util.HashMap;
import java.util.Map;

public class MainPrueba {

    public static void main(String[] args) {
        
        Map<Integer, Empleado> empleados = new HashMap<>();

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

    }
}
