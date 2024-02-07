public class SerieNumerica {

    public static void main(String[] args) {

        System.out.println("Dada la serie numérica a[n] = a[1] + 3 (n - 1), ¿Cuántos números de la secuencia desea mostrar (mínimo 10)? ");
        int valor = Integer.parseInt(System.console().readLine());
        System.out.println("El valor introducido es: " + valor);

        if (valor < 10) {
            System.out.println("Valor introducido inválido. Saliendo...");
        } else {
            int total = 0;

            for (int i = 1; i <= (3 * valor); i += 3) {
                total += i;
                if (i == ((3 * valor) - 2)) {
                    System.out.print(i + " = " + total);
                } else {
                    System.out.print(i + " + ");
                }
            }
        }
    }
}
