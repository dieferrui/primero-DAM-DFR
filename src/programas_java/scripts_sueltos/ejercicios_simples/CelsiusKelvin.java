import java.util.Scanner;

public class CelsiusKelvin {

    public static void main(String[] args) {

        Scanner entradaTec = new Scanner(System.in);

        System.out.print("Introduzca la cantidad de grados Celsius a convertir: ");
        double gradCel = entradaTec.nextDouble();

        double gradKel = Math.round(1000.d * (gradCel + 273.15)) / 1000.d;

        System.out.println("El resultado es " + gradKel + "K.");

        entradaTec.close();
    }
}
