import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Felicidades {

    public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);

            LocalDate fechaHoy = LocalDate.now();
            int añosHoy = fechaHoy.getYear();
            LocalDate nextCum;
            Period edad;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            int añosEdad = 0;
            long diasFaltan = 0;
            long diasPasados = 0;
            long horasFaltan = 0;

            System.out.println("Introduzca su fecha de nacimiento con el formato (dd-mm-yyyy): ");
            String fechaUsuario = scan.next();
            LocalDate fechaNacimiento = LocalDate.parse(fechaUsuario, dtf);

            // Calculamos la edad del usuario y se la damos.
            edad = Period.between(fechaNacimiento, fechaHoy);
            añosEdad = edad.getYears();
            System.out.println("A día de hoy tienes " + edad.getYears() + " años.");

            // Calculamos la fecha de cumpleaños del usuario.
            LocalDate fechaCum = fechaNacimiento.plusYears(añosEdad);
            int añosCum = fechaCum.getYear();

            if (fechaCum.isEqual(fechaHoy)) {
                System.out.println("Hoy es tu cumpleaños. ¡Feliz cumpleaños!");

            } else if (añosCum == añosHoy) {
                nextCum = fechaCum.plusYears(1);
                diasPasados = Math.abs(ChronoUnit.DAYS.between(fechaCum, fechaHoy));
                diasFaltan = Math.abs(ChronoUnit.DAYS.between(nextCum, fechaHoy));
                System.out.printf("Tu cumpleaños ha sido hace %d días.", diasPasados);
                System.out.println();
                System.out.printf("Faltan %d días para tu cumpleaños.", diasFaltan);

            } else {
                nextCum = fechaCum.plusYears(1);
                diasFaltan = Math.abs(ChronoUnit.DAYS.between(fechaHoy, nextCum));
                horasFaltan = diasFaltan * 24;
                System.out.printf("Faltan %d días, es decir, %d horas, para tu cumpleaños", diasFaltan, horasFaltan);

            }

        scan.close();
    }
}
