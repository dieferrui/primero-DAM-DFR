import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
    
        int[] numeritos = {1, 2, 3, 6, 89, 23, 66, 102, 32, 420, 69};

        LinkedList<Integer> listaNums = new LinkedList<>();

        for (int num : numeritos) {

            listaNums.add(num);

        }

        listaNums.add(190);

        System.out.println(listaNums);


        int[] numberitos = new int[listaNums.size()];

        for (int i = 0; i < listaNums.size(); i++) {

            numberitos[i] = listaNums.get(i);

        }

        System.out.println(numberitos);
    }
}
