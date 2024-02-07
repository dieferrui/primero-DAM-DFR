public class DiasDelMes {

    public static void main(String[] args) {

        System.out.print("Introduzca el número del mes del que desea saber los días: ");
        int mes = Integer.parseInt(System.console().readLine());

        System.out.print("Introduzca el año del mes especificado: ");
        int anno = Integer.parseInt(System.console().readLine());

        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            System.out.println("Este mes tiene 31 días.");
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            System.out.println("Este mes tiene 30 días");
        } else {
            if ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0) {
               System.out.println("Este mes tiene 29 días."); 
            } else {
                System.out.println("Este mes tiene 28 días.");
            }
        }
    }
}
