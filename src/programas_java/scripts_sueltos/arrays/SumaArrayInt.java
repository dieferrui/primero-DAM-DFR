import java.util.Scanner;

public class SumaArrayInt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca longitud de Array: ");
        int longitud = sc.nextInt();
        int[] arrayNum = new int[longitud];

        System.out.println("Introduzca valores de Array: ");
        for (int i = 0; i < arrayNum.length; i++) {
            arrayNum[i] = sc.nextInt();
        }

        // Sumar valores

        int suma = 0;

        for (int i : arrayNum) {
            suma = suma += i;
        }

        System.out.printf("La suma es %d.", suma);

        sc.close();
    }
}