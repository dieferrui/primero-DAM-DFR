import java.util.Scanner;

public class InvertirArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca longitud de Array: ");
        int longitud = sc.nextInt();
        int[] arrayNum = new int[longitud];

        System.out.println("Introduzca valores de Array: ");
        for (int i = 0; i < arrayNum.length; i++) {
            arrayNum[i] = sc.nextInt();
        }

        System.out.println("Su Array es la siguiente: ");
        for (int i = 0; i < arrayNum.length; i++) {
            if (i >= arrayNum.length - 1) {
                System.out.print(arrayNum[i]);
            } else {
                System.out.print(arrayNum[i]);
                System.out.print(", ");
            }
            
        }
        System.out.println();

        // Invertir Array
        int[] arrayInv = new int[longitud];

        for (int j = 0; j < arrayNum.length; j++) {
            arrayInv[j] = arrayNum[(arrayNum.length - 1) - j];
        }

        System.out.println("Su Array invertida es la siguiente: ");
        for (int i = 0; i < arrayNum.length; i++) {
            if (i >= arrayNum.length - 1) {
                System.out.print(arrayInv[i]);
            } else {
                System.out.print(arrayInv[i]);
                System.out.print(", ");
            }
            
        }
        
        sc.close();
    }
}
