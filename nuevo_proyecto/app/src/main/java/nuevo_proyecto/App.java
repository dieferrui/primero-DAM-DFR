/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package nuevo_proyecto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        
        
        Set<MiClase> set = new HashSet<>();

        set.add(new MiClase(1, "Murcia"));
        set.add(new MiClase(3, "Granada"));
        set.add(new MiClase(1, "Segovia"));
        set.add(new MiClase(11, "Vigo"));
        set.add(new MiClase(10, "Sevilla"));
        set.add(new MiClase(1, "Murcia"));
        set.add(new MiClase(12, "Valencia"));

        // System.out.println(set.toString());

        MiClase obje = new MiClase(3, "Granada");

        for (MiClase obj : set) {

            if (obj.equals(obje)) {

                obj.setNum(33);

            }
        }

        // System.out.println(set.toString());

        obje = new MiClase(33, "Granada");

        if (set.contains(obje)) {

            // System.out.println("El objeto " + obje + " está en el conjunto");

        } else {

            // System.out.println("El objeto " + obje + " no está en el conjunto");

        }
        

        Set<MiClase> nuevoSet = Set.of(new MiClase(1, "Murcia"), new MiClase(3, "Granada"), new MiClase(11, "Vigo"));
        // System.out.println(nuevoSet.toString());

        Set<MiClase> nuevoConjunto = Collections.unmodifiableSet(set);
        // System.out.println(nuevoConjunto);

        /*
        nuevoSet.add(new MiClase(33, "Granada")); // UnsupportedOperationException
        System.out.println(nuevoSet.toString());

        nuevoConjunto.add(new MiClase(18, "Valencia")); // UnsupportedOperationException
        System.out.println(nuevoConjunto.toString());
        */

        set.add(new MiClase(17, "Badajoz"));
        // System.out.println(nuevoConjunto.toString());

        MiClase cord = new MiClase(21, "Cordoba");
        MiClase alme = new MiClase(22, "Almeria");
        MiClase mala = new MiClase(23, "Malaga");

        Set<MiClase> conj1 = new HashSet();
        conj1.add(cord); conj1.add(alme); conj1.add(mala);

        Set<MiClase> conj2 = Set.of(cord, alme, mala);
        Set<MiClase> conj3 = Collections.unmodifiableSet(conj1);

        cord.setTxt("Lugo");

        System.out.println(conj1.toString());
        System.out.println(conj2.toString());
        System.out.println(conj3.toString());

    }
}
