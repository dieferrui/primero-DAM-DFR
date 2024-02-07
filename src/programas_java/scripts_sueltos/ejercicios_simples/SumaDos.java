import java.util.Scanner;

public class SumaDos {

    public static void main(String[] args) {

        Scanner inputInt = new Scanner(System.in);
        System.out.println("Introduce primer íntegro: ");
        int primerInt = inputInt.nextInt();
        System.out.println("Introduce segundo íntegro: ");
        int segunInt = inputInt.nextInt();
        int resultado = primerInt + segunInt;
        System.out.println("El resultado es " + resultado + ".");
        inputInt.close();
    }
}
