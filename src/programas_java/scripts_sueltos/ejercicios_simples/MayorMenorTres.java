import java.util.Scanner;

public class MayorMenorTres {

    public static void main(String[] args) {

        Scanner entradaTec = new Scanner(System.in);
        
        System.out.print("Introduce el primer valor, A: ");
        int a = entradaTec.nextInt();
        
        System.out.print("Introduce el segundo valor, B: ");
        int b = entradaTec.nextInt();
        
        System.out.print("Introduce el tercer valor, C: ");
        int c = entradaTec.nextInt();
        
        if (a == b || a == c || b == c) {
            System.out.println("Error. Alguno de los valores introducidos son iguales.");
        } else {
            if (a > b) {
                if (b > c) {
                    System.out.println("A es el mayor y C es el menor.");
                } else {
                    if (a > c) {
                        System.out.println("A es el mayor y B es el menor.");
                    } else {
                        System.out.println("C es el mayor y B es el menor.");
                    }
                }
            } else {
                if (a > c) {
                    System.out.println("B es el mayor y C es el menor.");
                } else {
                    if (b > c) {
                        System.out.println("B es el mayor y A es el menor.");
                    } else {
                        System.out.println("C es el mayor y A es el menor.");
                    }
                }
            }
        }

        entradaTec.close();
    }
}
