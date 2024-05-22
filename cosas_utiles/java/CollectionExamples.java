import java.util.*;

public class CollectionExamples {

    public static void main(String[] args) {

        // List interface implementations

        // ArrayList
        List<String> arrayList = new ArrayList<>();
        // Elegí List porque necesito una colección ordenada que permita elementos duplicados.
        // Elegí ArrayList porque ofrece acceso rápido a los elementos por índice y es eficiente para búsquedas y modificaciones de elementos.
        
        arrayList.add("Element1");
        arrayList.add("Element2");

        // Iterator for ArrayList
        Iterator<String> arrayListIterator = arrayList.iterator();
        // Elegí Iterator porque es una forma fácil de recorrer la colección.

        while (arrayListIterator.hasNext()) {
            System.out.println(arrayListIterator.next());
        }

        // LinkedList
        List<String> linkedList = new LinkedList<>();
        // Elegí List porque necesito una colección ordenada que permita elementos duplicados.
        // Elegí LinkedList porque permite inserciones y eliminaciones rápidas en cualquier posición de la lista.

        linkedList.add("Element1");
        linkedList.add("Element2");

        // Iterator for LinkedList
        Iterator<String> linkedListIterator = linkedList.iterator();
        // Elegí Iterator porque es una forma fácil de recorrer la colección.

        while (linkedListIterator.hasNext()) {
            System.out.println(linkedListIterator.next());
        }

        // Set interface implementations

        // HashSet
        Set<String> hashSet = new HashSet<>();
        // Elegí Set porque necesito una colección que no permita elementos duplicados.
        // Elegí HashSet porque permite tiempos constantes promedio para operaciones de inserción, eliminación y búsqueda.

        hashSet.add("Element1");
        hashSet.add("Element2");

        // Iterator for HashSet
        Iterator<String> hashSetIterator = hashSet.iterator();
        /// Elegí Iterator porque es una forma fácil de recorrer la colección.

        while (hashSetIterator.hasNext()) {
            System.out.println(hashSetIterator.next());
        }

        // LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();
        // Elegí Set porque necesito una colección que no permita elementos duplicados.
        // Elegí LinkedHashSet porque mantiene el orden de inserción de los elementos.

        linkedHashSet.add("Element1");
        linkedHashSet.add("Element2");

        // Iterator for LinkedHashSet
        Iterator<String> linkedHashSetIterator = linkedHashSet.iterator();
        // Elegí Iterator porque es una forma fácil de recorrer la colección.

        while (linkedHashSetIterator.hasNext()) {
            System.out.println(linkedHashSetIterator.next());
        }

        // TreeSet
        Set<String> treeSet = new TreeSet<>();
        // Elegí Set porque necesito una colección que no permita elementos duplicados.
        // Elegí TreeSet porque mantiene los elementos ordenados de forma natural.

        treeSet.add("Element1");
        treeSet.add("Element2");

        // Iterator for TreeSet
        Iterator<String> treeSetIterator = treeSet.iterator();
        // Elegí Iterator porque es una forma fácil de recorrer la colección.

        while (treeSetIterator.hasNext()) {
            System.out.println(treeSetIterator.next());
        }

        // Map interface implementations

        // HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        // Elegí Map porque necesito una colección que asocie claves a valores.
        // Elegí HashMap porque permite tiempos constantes promedio para operaciones de inserción, eliminación y búsqueda de claves.

        hashMap.put("Key1", 1);
        hashMap.put("Key2", 2);

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // LinkedHashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        // Elegí Map porque necesito una colección que asocie claves a valores.
        // Elegí LinkedHashMap porque mantiene el orden de inserción de las claves.

        linkedHashMap.put("Key1", 1);
        linkedHashMap.put("Key2", 2);

        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // TreeMap
        Map<String, Integer> treeMap = new TreeMap<>();
        // Elegí Map porque necesito una colección que asocie claves a valores.
        // Elegí TreeMap porque mantiene las claves ordenadas de forma natural.

        treeMap.put("Key1", 1);
        treeMap.put("Key2", 2);

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // Queue interface implementations

        // LinkedList as Queue
        Queue<String> queue = new LinkedList<>();
        // Elegí Queue porque necesito una colección que permita insertar elementos al final y extraerlos del principio.
        // Elegí LinkedList porque permite inserciones y eliminaciones rápidas y eficientes en ambos extremos.

        queue.add("Element1");
        queue.add("Element2");

        // Iterator for Queue
        Iterator<String> queueIterator = queue.iterator();
        // Elegí Iterator porque es una forma fácil de recorrer la colección.

        while (queueIterator.hasNext()) {
            System.out.println(queueIterator.next());
        }

        // Deque interface implementations

        // ArrayDeque
        Deque<String> deque = new ArrayDeque<>();
        // Elegí Deque porque necesito una colección que permita insertar y extraer elementos desde ambos extremos.
        // Elegí ArrayDeque porque es más eficiente en memoria y rendimiento que LinkedList para implementaciones de pila y cola.

        deque.addFirst("Element1");
        deque.addLast("Element2");

        // Iterator for Deque
        Iterator<String> dequeIterator = deque.iterator();
        // Elegí Iterator porque es una forma fácil de recorrer la colección.

        while (dequeIterator.hasNext()) {
            System.out.println(dequeIterator.next());
        }
    }
}
