import java.util.Scanner;

public class CalculoImc {

    public static void main(String[] args) {

        Scanner entradaTec = new Scanner(System.in);
        
        System.out.println("Introduce tu peso en Kg: ");
        float pesoEntra = entradaTec.nextInt();
        
        System.out.println("Introduce tu estatura en metros: ");
        float alturaEntra = entradaTec.nextFloat();
        
        double imc = pesoEntra / (Math.pow(alturaEntra, 2.0));
        double result = Math.round(imc * 100) / 100;
        System.out.println("Tu IMC es " + result + ".");
        
        entradaTec.close();
    }
}
