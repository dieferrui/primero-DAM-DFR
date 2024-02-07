import java.util.Scanner;

public class VolumenCono {

    public static void main(String[] args) {

        Scanner entradaTec = new Scanner(System.in);

        System.out.print("Introduzca la altura del cono, h (en metros): ");
        double h = entradaTec.nextFloat();

        System.out.print("Introduzca el radio de la base del cono, r (en metros): ");
        double r = entradaTec.nextFloat();

        double solucion = (1.0d / 3.0d) * Math.PI * Math.pow(r, 2) * h;

        System.out.println("El volumen del cono es de " + Math.round(solucion * 100) / 100.0d + " metros cúbicos.");
        entradaTec.close();
    }
}
