import java.util.*;

public class CollectionExamples {

    public static void main(String[] args) {

        // List interface implementations

        // ArrayList
        List<String> arrayList = new ArrayList<>();
        // Elegí List porque necesito una colección ordenada que permita elementos duplicados.
        // Elegí ArrayList porque ofrece acceso rápido a los elementos por índice y es eficiente para búsquedas y modificaciones de elementos.

        // LinkedList
        List<String> linkedList = new LinkedList<>();
        // Elegí List porque necesito una colección ordenada que permita elementos duplicados.
        // Elegí LinkedList porque permite inserciones y eliminaciones rápidas en cualquier posición de la lista.

        // Set interface implementations

        // HashSet
        Set<String> hashSet = new HashSet<>();
        // Elegí Set porque necesito una colección que no permita elementos duplicados.
        // Elegí HashSet porque permite tiempos constantes promedio para operaciones de inserción, eliminación y búsqueda.

        // LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();
        // Elegí Set porque necesito una colección que no permita elementos duplicados.
        // Elegí LinkedHashSet porque mantiene el orden de inserción de los elementos.

        // TreeSet
        Set<String> treeSet = new TreeSet<>();
        // Elegí Set porque necesito una colección que no permita elementos duplicados.
        // Elegí TreeSet porque mantiene los elementos ordenados de forma natural.

        // Map interface implementations

        // HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        // Elegí Map porque necesito una colección que asocie claves a valores.
        // Elegí HashMap porque permite tiempos constantes promedio para operaciones de inserción, eliminación y búsqueda de claves.

        // LinkedHashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        // Elegí Map porque necesito una colección que asocie claves a valores.
        // Elegí LinkedHashMap porque mantiene el orden de inserción de las claves.

        // TreeMap
        Map<String, Integer> treeMap = new TreeMap<>();
        // Elegí Map porque necesito una colección que asocie claves a valores.
        // Elegí TreeMap porque mantiene las claves ordenadas de forma natural.

    }
}
