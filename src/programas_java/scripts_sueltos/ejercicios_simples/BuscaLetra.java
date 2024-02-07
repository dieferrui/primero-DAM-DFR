import java.util.Scanner;

public class BuscaLetra {

    public static void main(String[] args) {

        int contador = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la frase en la que buscar: ");
        String frase = System.console().readLine().toLowerCase();

        System.out.println("Introduzca el carácter a buscar: ");
        char letra = sc.next().charAt(0);

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letra) {
                contador++;
            }
        }

        switch (contador) {
            case 0: System.out.print("No hay coincidencias."); break;
            case 1: System.out.print("Se ha encontrado una coincidencia del carácter '" + letra + "'."); break;
            default: System.out.print("Se han encontrado " + contador + " coincidencias del carácter '" + letra + "'."); break;
        }

        sc.close();
    }
}
