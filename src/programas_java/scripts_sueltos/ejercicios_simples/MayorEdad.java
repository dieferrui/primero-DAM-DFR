import java.util.Scanner;

public class MayorEdad {

    public static void main(String[] args) {

        Scanner entradaTec = new Scanner(System.in);
        System.out.print("Introduce tu edad en número entero: ");
        int edad = entradaTec.nextInt();
        if (edad >= 18) {
            System.out.println("Eres mayor de edad.");
        } else {
            System.out.println("Eres menor de edad.");
        }
        entradaTec.close();
    }
}
