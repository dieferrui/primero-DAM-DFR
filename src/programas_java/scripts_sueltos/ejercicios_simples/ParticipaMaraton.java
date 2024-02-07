import java.util.Scanner;

public class ParticipaMaraton {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Por favor, introduzca su edad: ");
        int edad = scan.nextInt();

        if (edad < 18) {
            System.out.println("No puede participar.");
        } else {
            if (edad > 35) {
                System.out.print("Introduzca su último tiempo de finalización de maratón, en minutos (si no ha participado, introduzca el número 226): ");
                int tiempo = scan.nextInt();
                
                if (tiempo > 225) {
                    System.out.println("Persona no seleccionada.");
                } else {
                    System.out.println("Persona seleccionada.");
                }
            } else {
                System.out.print("Introduzca su último tiempo de finalización de maratón, en minutos (si no ha participado, introduzca el número 226): ");
                int tiempo = scan.nextInt();

                if (tiempo > 190) {
                    System.out.println("Persona no seleccionada.");
                } else {
                    System.out.println("Persona seleccionada.");
                }
            }
        }

        scan.close();
    }
}
