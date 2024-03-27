import java.util.Scanner;

public class CalculadoraBasica {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        char operador;
        
        System.out.println("Calculadora Básica");
        System.out.print("Ingrese el primer número: ");
        num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        num2 = scanner.nextDouble();
        System.out.print("Ingrese el operador (+, -, *, /): ");
        operador = scanner.next().charAt(0);
        
        double resultado = 0;

        switch(operador) {

            case '+':
                resultado = num1 + num2;
                break;

            case '-':
                resultado = num1 - num2;
                break;

            case '*':
                resultado = num1 * num2;
                break;

            case '/':
                if (num2 != 0) {

                    resultado = num1 / num2;

                } else {

                    System.out.println("Error: División por cero.");
                    scanner.close();
                    return;

                }

                break;
                
            default:
                System.out.println("Operador inválido.");
                scanner.close();
                return;
        }
        
        System.out.println("Resultado: " + resultado);
        scanner.close();
    }
}

