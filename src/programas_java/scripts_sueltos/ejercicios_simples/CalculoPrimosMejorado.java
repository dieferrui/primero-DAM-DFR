public class CalculoPrimosMejorado {

    public static void main(String[] args) {

        boolean selectSalir = false;

        while (!selectSalir) {
            System.out.println("Elija una opcion:\n 1. Comprobar numero primo\n 2. Salir");
            int menu = Integer.parseInt(System.console().readLine());

            switch (menu) {
            case 1:
            boolean isPrime = true;  
            System.out.println("Introduzca el numero a comprobar:");
                int num = Integer.parseInt(System.console().readLine());

                if (num <= 0) {
                    System.out.println("El numero introducido no es primo");

                } else {
                    for (int i = 2; i < Math.ceil(num / 2); i++) {
                        if (num % i == 0) {
                            isPrime = false;
                            break;

                        }
                    }
                }

                if (isPrime) {
                    System.out.println("El numero introducido es primo");

                } else {
                    System.out.println("El numero introducido no es primo");
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
