import java.util.Scanner;

public class RecursividadTriangulo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número entero para la altura del triángulo: ");
        int n = sc.nextInt();

        pintaFilas(n);
    }

    public static void pintaFilas(int n) {

        if (n == 1) {
            pintaAsteriscos(n);
    
        } else {
            pintaFilas(n - 1);
            pintaAsteriscos(n);

        }
    }

    public static void pintaAsteriscos(int n) {

        if (n > 0) {
            System.out.print("*");
            pintaAsteriscos(n - 1);

        } else {
            System.out.println();

        }
    }
}
