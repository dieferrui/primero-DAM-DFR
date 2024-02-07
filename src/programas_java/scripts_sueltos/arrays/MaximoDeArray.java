import java.util.Scanner;

public class MaximoDeArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca longitud de Array: ");
        int longitud = sc.nextInt();
        int[] arrayNum = new int[longitud];

        System.out.println("Introduzca valores de Array: ");
        for (int i = 0; i < arrayNum.length; i++) {
            arrayNum[i] = sc.nextInt();
        }

        // Encontrar máximo

        int maxValue = 0;
        for (int i : arrayNum) {
            maxValue = Math.max(maxValue, i);
        }

        System.out.printf("El valor máximo es %d.", maxValue);

        sc.close();
    }
}
