public class EntradasCine {

    public static void main(String[] args) {
        
        boolean checked = false;
        int entradas = 0;
        int dia = 0;
        int elComandanteFidel = 0;
        
        while (!checked) {

            try {
                System.out.println("Cines \"El Comandante\" le da la bienvenida a su web de compra. Permitame hacer algunas preguntas antes de empezar:");
        
                System.out.println("Para cuantas personas quiere adquirir entradas?");
                entradas = Integer.parseInt(System.console().readLine());

                System.out.println("Para que dia de la semana desea entradas?\nIntroduzca el numero de dia del 1 al 7:");
                dia = Integer.parseInt(System.console().readLine());
                
                if (dia == 3) {
                    System.out.println("Hoy es el dia del espectador: el precio de la entrada es de 5 euros.");

                } else if (dia == 4) {
                    System.out.println("Hoy es el dia de la pareja: si compra dos entradas, solo le costaran 11 euros.");
                } else {
                    System.out.println("Hoy cada entrada le sale a 8 euros");
                }

                System.out.println("Por ultimo, indique si posee tarjeta de fidelidad:\n 1. Si\n 2. No");
                elComandanteFidel = Integer.parseInt(System.console().readLine());

                if (elComandanteFidel == 1) {
                    System.out.println("El comandante le da la bienvenida, camarada. Disfrute de su descuento en la factura.");
                }

                checked = true;

            } catch (NumberFormatException e) {
                System.out.println("El valor introducido no es valido: debe introducir un numero entre la seleccion disponible.");

            }
            
        }

        System.out.println("Gracias, sus respuestas se estan procesando...");
        CalculaPrecio(entradas, dia, elComandanteFidel);
    }

    public static void CalculaPrecio(int entradas, int dia, int elComandanteFidel) {
        
        int precioBase = 8;
        double precioFinal = 0d;

        if (dia == 3) {
            precioBase = 5;
            
            if (elComandanteFidel == 1) {
                precioFinal = (precioBase * entradas) * 0.9;

            } else {
                precioFinal = precioBase * entradas;

            }
        
        } else if (dia == 4 && entradas == 2) {
            if (elComandanteFidel == 1) {
                precioFinal = 11 * 0.9;

            } else {
                precioFinal = 11;

            }

        } else {
            if (elComandanteFidel == 1) {
                precioFinal = (precioBase * entradas) * 0.9;

            } else {
                precioFinal = precioBase * entradas;

            }
        }

        System.out.printf("El precio de sus entradas es de %.2f euros.", precioFinal);
    }
}
