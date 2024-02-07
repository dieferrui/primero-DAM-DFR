public class BilleteTren {

    public static void main(String[] args) {

        int tipoBillete = 0;
        int tarjeta = 0;
        int distancia = 0;
        double precioViaje = 0d;
        double precioFinal = 0d;
        final double DESC_TARJ = 0.75d;
        final double DESC_110 = 0.90d;
        final double DESC_50 = 0.95d;

        do {
            System.out.print("Introduzca la distancia (en km) entre el origen y destino: ");
            distancia = Integer.parseInt(System.console().readLine());
        } while (distancia <= 0);

        do {
            System.out.println("Introduzca su tipo de billete:\n1. Sencillo.\n2. Ida y vuelta.");
            tipoBillete = Integer.parseInt(System.console().readLine());

            switch (tipoBillete) {
                case 1: 
                    precioViaje = 0.33d * distancia; 
                    break;
                case 2: 
                    precioViaje = 0.26d * 2 * distancia; 
                    break;
                default: 
                    System.out.println("Tipo de billete inválido.");
            }
        } while (tipoBillete != 1 && tipoBillete != 2);

        do {
            System.out.println("¿Posee usted tarjeta interraíl?\n1. Sí.\n2. No.");
            tarjeta = Integer.parseInt(System.console().readLine());
        } while (tarjeta != 1 && tarjeta != 2);

        if (tarjeta == 1) {
            precioFinal = precioViaje * DESC_TARJ;
        } else if (precioViaje >= 110) {
            precioFinal = precioViaje * DESC_110;
        } else if (precioViaje >= 50) {
            precioFinal = precioViaje * DESC_50;
        } else {
            precioFinal = precioViaje;
        }

        System.out.printf("El precio de su billete es de %.2f euros.", precioFinal);
    }
}
