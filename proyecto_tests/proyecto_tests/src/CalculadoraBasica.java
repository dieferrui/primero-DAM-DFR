import java.util.Scanner;

public class CalculadoraBasica {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int operando1, operando2;
        char operador;
        
        System.out.println("Calculadora Básica");
        System.out.print("Ingrese el primer número: ");
        operando1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        operando2 = scanner.nextInt();
        System.out.print("Ingrese el operador (+, -, *, /): ");
        operador = scanner.next().charAt(0);
        
        int resultado = operacion(operador, operando1, operando2);

        System.out.println("Resultado: " + resultado);
        scanner.close();
    }

    public static int operacion(char signo, int operando1, int operando2) {

        int resultado = 0;

        switch(signo) {

            case '+':
                resultado = operando1 + operando2;
                break;

            case '-':
                resultado = operando1 - operando2;
                break;

            case '*':
                resultado = operando1 * operando2;
                break;

            case '/':
                if (operando2 != 0) {

                    resultado = operando1 / operando2;

                } else {

                    System.out.println("Error: División por cero.");
                    return resultado;

                }

                break;

            default:
                System.out.println("Operador inválido.");
                return resultado;
        }

        return resultado;
    }
}

