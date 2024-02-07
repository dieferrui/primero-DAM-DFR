
public class EjerDepuracion {
    
    public static void main(String[] args) {

        ejerUno();
        ejerDos();
        ejerTres();
        ejerCuatro();
        ejerCinco();
        ejer1();
        ejer2();
        ejer3();
        ejer4();
    }

    public static void ejerUno() {
        
        int numero = 5;
        System.out.println("El número es: " + numero);
    }

    public static void ejerDos() {
        
        int numero1 = 10;
        int numero2 = 5;
        int suma = numero1 - numero2;
        System.out.println("La resta de " + numero1 + " y " + numero2 + " es: " + suma);
    }

    public static void ejerTres() {

        int[] numeros = {1, 2, 3};
        System.out.println("El tercer número es: " + numeros[2]);
    }

    public static void ejerCuatro() {

        int contador = 0;
        while (contador >= 0 && contador < 10) {
            System.out.println("Contador: " + contador);
            contador++;
        }
    }

    public static void ejerCinco() {

        String texto1 = "Hola"; String texto2 = "hola"; 
            if (texto1.equals(texto2)) { System.out.println("Las cadenas son iguales"); 
            } else {
            System.out.println("Las cadenas son diferentes");
        } 
    }

    public static void ejer1() {

        int numero1 = 10;
        int numero2 = 5;
        
        int resultado = numero1 * numero2;
        System.out.println("La multiplicación de " + numero1 + " y " + numero2 + " es: " + resultado);
    }

    public static void ejer2() {

        int[] numeros = {1, 2, 3};
        System.out.println("El tercer número es: " + numeros[2]);
    }

    public static void ejer3() {

        int numero = 10;
        int contador = 0;
        
        while (contador < numero) {
            contador++;
        }
    }

    public static void ejer4() {

        String cadena = "Ejemplo";
        
        for (int i = 0; i <= (cadena.length() - 1); i++) {
            char c = cadena.charAt(i);
            System.out.println("Carácter en la posición " + i + ": " + c);
        }
    }
}
