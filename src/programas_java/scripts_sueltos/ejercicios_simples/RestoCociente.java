import java.util.Scanner;

public class RestoCociente {

    public static void main(String[] args) {

        Scanner entradaTec = new Scanner(System.in);
        
        System.out.println("Introduce el primer valor, n: ");
        int n = entradaTec.nextInt();
        
        System.out.println("Introduce el segundo valor, m: ");
        int m = entradaTec.nextInt();
        
        int cociente = Math.floorDiv(n, m);
        int resto = n % m;
        System.out.println("El resto es " + resto + ".");
        System.out.println("El cociente es " + cociente + ".");
        
        entradaTec.close();
    }
}
