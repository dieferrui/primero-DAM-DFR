import java.util.Scanner;


public class HorasPagadas {

    public static void main(String[] args) {

        Scanner entradaTec = new Scanner(System.in);
       
        System.out.println("Introduce las horas trabajadas: ");
        int horasTrabajo = entradaTec.nextInt();
       
        System.out.println("Introduce el pago por hora: ");
        float pagoHoras = entradaTec.nextFloat();
       
        float resultado = horasTrabajo * pagoHoras;
        System.out.println("Tu paga es de " + resultado + "$.");
        
        entradaTec.close();
    }
}
