import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class App {

    private static Random random = new Random();
    public static void main(String[] args) {
        
        tryNumeros();
        System.out.println("--------------------------------------------------");
        tryListaCanciones();
        
    }

    public static void tryNumeros() {

        int[] numeros = new int[50];

        for (int i = 0; i < numeros.length; i++) {

            numeros[i] = random.nextInt(10) + 1;

        }

        Set<Integer> treeNumeros = new TreeSet<>();

        for (int i = 0; i < numeros.length; i++) {

            treeNumeros.add(numeros[i]);

        }

        System.out.println("Conjunto de números inicial:");
        System.out.println(Arrays.toString(numeros));

        System.out.println("Conjunto de números únicos: ");
        System.out.println(treeNumeros.toString());

        System.out.println("¿La lista contiene el número cinco? " + treeNumeros.contains(5));

        treeNumeros.add(0);
        treeNumeros.add(15);
        treeNumeros.add(25);

        System.out.println("Conjunto de números:");
        System.out.println(treeNumeros.toString());

        treeNumeros.remove(5);

        System.out.println("Conjunto de números:");
        System.out.println(treeNumeros.toString());

    }

    public static void tryListaCanciones() {

        Set<String> canciones = new LinkedHashSet<>();

        canciones.add("Assuming We Survive - Say My Name");
        canciones.add("Adept - At Least Give Me My Dreams Back, You Negligent Wh...");
        canciones.add("Adept - The Ballad of Planet Earth");
        canciones.add("Hell or Highwater - I Want It All");
        canciones.add("Adept - Black Veins");
        canciones.add("Onlap - Fading");
        canciones.add("Assuming We Survive - Catch 22");
        canciones.add("Assuming We Survive - Make It Out Alive");
        
        System.out.println("Lista de canciones inicial: ");
        System.out.println(canciones.toString());

        System.out.println("Tratamos de añadir canciones ya en el Set:");
        canciones.add("Adept - At Least Give Me My Dreams Back, You Negligent Wh...");
        canciones.add("Adept - The Ballad of Planet Earth");
        System.out.println(canciones.toString());

        System.out.println("Eliminamos alguna canción: ");
        canciones.remove("Hell or Highwater - I Want It All");
        canciones.remove("Onlap - Fading");
        System.out.println(canciones.toString());

    }
}
