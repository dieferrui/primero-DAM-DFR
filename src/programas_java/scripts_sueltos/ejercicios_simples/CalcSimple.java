import java.util.Scanner;

public class CalcSimple {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String opera = "";
        double resultado = 0d;

        System.out.print("Introduzca el primer número: ");
        double num1 = Double.parseDouble(sc.nextLine());
        
        System.out.print("Introduzca el segundo número: ");
        double num2 = Double.parseDouble(sc.nextLine());
        
        System.out.print("Introduzca la operación que desea realizar (suma, resta, multiplicacion, division): ");
        opera = sc.nextLine();

        switch (opera) {
            case "suma":
                resultado = num1 + num2;
                break;
            case "resta":
                resultado = num1 - num2;
                break;
            case "multiplicacion":
                resultado = num1 * num2;
                break;
            case "division":
                resultado = num1 / num2;
                break;
            default:
                System.out.println("Operación no válida");
                break;
        }
        
        System.out.println("El resultado es: " + resultado);

        sc.close();
    }
}
