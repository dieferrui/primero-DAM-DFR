import java.util.Scanner;

public class MayorDos {

    public static void main(String[] args) {

        Scanner entradaTec = new Scanner(System.in);
        
        System.out.println("Introduce el primer valor, x: ");
        int x = entradaTec.nextInt();
        
        System.out.println("Introduce el segundo valor, y: ");
        int y = entradaTec.nextInt();
        
        if (x == y) {
            System.out.println("Error. Los valores introducidos son iguales.");
        } else {
            if (x >= y) {
                System.out.println("El valor de x es mayor.");
            } else {
            System.out.println("El valor de y es mayor.");
            }
        }

        entradaTec.close();
    }
}
