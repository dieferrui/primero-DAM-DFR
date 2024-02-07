public class EcoEco {

    public static void main(String[] args) {

        final String SALIR = "salir";
        
        while (true) {
            System.out.println("Introduzca la expresión a duplicar, o \"salir\" para cerrar el programa: ");
            String frase = System.console().readLine();

            if (SALIR.equalsIgnoreCase(frase)) {
                break;
            } else {
                System.out.println(frase + " " + frase);
                continue;
            }
        }
    }
}
