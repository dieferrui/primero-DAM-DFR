import java.util.Scanner;
import java.util.Arrays;

public class OrdenaArrayAlfa {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca longitud de Array: ");
        int longitud = sc.nextInt();
        String[] arrayAlfa = new String[longitud];

        System.out.println("Introduzca palabras para introducir al Array: ");
        for (int i = 0; i < arrayAlfa.length; i++) {
            arrayAlfa[i] = sc.next();
        }
        
        // Ordenar Alfabéticamente

        Arrays.sort(arrayAlfa);

        for (String i : arrayAlfa) {
            System.out.println(i);
        }

        sc.close();
    }
}
