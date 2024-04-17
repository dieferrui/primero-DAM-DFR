import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class IteraLista {

    public static void iterarNormal() {

        ArrayList<Integer> arrayInts = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < 100; i++) {

            int num = random.nextInt(100);
            arrayInts.add(num);

        }

        Iterator iterando = arrayInts.iterator();

        while (iterando.hasNext()) {

            System.out.println(iterando.next());

        }
    }
}
