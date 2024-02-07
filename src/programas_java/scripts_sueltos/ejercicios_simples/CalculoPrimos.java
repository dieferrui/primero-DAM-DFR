public class CalculoPrimos {

    public static void main(String[] args) {

        boolean selectSalir = false;

        while (!selectSalir) {
            System.out.println("Elija una opcion:\n 1. Comprobar numero primo\n 2. Salir");
            int menu = Integer.parseInt(System.console().readLine());

            switch (menu) {
                case 1:
                    int contador = 0;

                    System.out.println("Introduzca el numero a comprobar:");
                    int num = Integer.parseInt(System.console().readLine());

                    if (num <= 0) {
                        System.out.println("El numero introducido no es primo");

                    } else {
                        for (int i = num; i >= 1; i--) {
                            if (num % i == 0) {
                                contador++;

                            }
                        }

                        if (contador > 2) {
                            System.out.println("El numero introducido no es primo.");

                        } else {
                            System.out.println("El numero introducido es primo.");

                        }
                    }

                    System.out.println();
                    break;
                        
                case 2:
                    selectSalir = true;
                    break;
            }
        }
    }
}
