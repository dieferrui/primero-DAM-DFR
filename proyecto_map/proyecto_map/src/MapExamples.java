import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {

    public static void main(String[] args) {

        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new TreeMap<>();
        Map<String, Integer> map3 = new LinkedHashMap<>();

        map1.put("Zagreus", 24);
        map1.put("Hades", 678);
        map1.put("Thanatos", 1912);
        map1.put("Megaera", 1874);
        map1.put("Hypnos", 1912);

        map2.put("Diego", 27);
        map2.put("Filca", 18);
        map2.put("Castilla", 18);
        map2.put("Nacho", 19);
        map2.put("Angel", 19);

        map3.put("Mickey", 92);
        map3.put("Donald", 85);
        map3.put("Goofy", 85);
        map3.put("Pluto", 91);
        map3.put("Minnie", 92);

        System.out.println("--- HashMap ---");
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        System.out.println("--- TreeMap ---");
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        System.out.println("--- LinkedHashMap ---");
        for (Map.Entry<String, Integer> entry : map3.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        System.out.println("Getting value for key Hades: " + map1.get("Hades"));
        System.out.println("Getting value for key Filca: " + map2.get("Filca"));
        System.out.println("Getting value for key Goofy: " + map3.get("Goofy"));
        System.out.println();

        System.out.println("Contains key Hades? " + map1.containsKey("Hades"));
        System.out.println("Contains key Filca? " + map2.containsKey("Filca"));
        System.out.println("Contains key Goofer? " + map3.containsKey("Goofer"));
        System.out.println();

        map1.remove("Hades"); System.out.println("Removed Hades from map1.");
        map2.remove("Filca"); System.out.println("Removed Filca from map2.");
        map3.remove("Goofy"); System.out.println("Removed Goofy from map3.");
        System.out.println();

        System.out.println("--- HashMap ---");
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        System.out.println("--- TreeMap ---");
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        System.out.println("--- LinkedHashMap ---");
        for (Map.Entry<String, Integer> entry : map3.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        System.out.println("Size of HashMap: " + map1.size());
        System.out.println("Size of TreeMap: " + map2.size());
        System.out.println("Size of LinkedHashMap: " + map3.size());
        System.out.println();

        // Ejercicio 2

        List<String> palabras = List.of("Sangre", "Oscuridad", "Sangre", "Corazon", "Sangre", "Corazon", "Huesos");
        cuentaPalabras(palabras);

    }

    public static String getAge(String name, Map<String, Integer> map) {

        if (map.containsKey(name)) {

            return name + " is " + map.get(name) + " years old.";

        } else {

            return name + " is not in the map.";

        }
    }

    public static void cuentaPalabras(List<String> palabras) {

        Map<String, Integer> mapa = new TreeMap<>();

        for (String palabra : palabras) {

            if (mapa.containsKey(palabra)) {

                mapa.put(palabra, mapa.get(palabra) + 1);

            } else {

                mapa.put(palabra, 1);

            }

        }

        System.out.println("Conteo de las palabras de la lista: ");
        for (Map.Entry<String, Integer> par : mapa.entrySet()) {

            System.out.println(par.getKey() + " -> " + par.getValue());

        }
    }
}
