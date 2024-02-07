public class SentenciaRuptura {

    public static void main(String[] args) {

        for (int i = 10; i <= 20; i += 2) {
            if (i != 16) {
                System.out.println(i);
            }
        }
        System.out.println();

        for (int j = 10; j <= 20; j++) {
            if (j % 2 == 0 && j != 16) {
                System.out.println(j);
            }
        }
        System.out.println();
        
        int k = 10;
        while (true) {
            if (k % 2 == 0 && k != 16) {
                System.out.println(k);
                k++;
            } else if (k > 20) {
                break;
            } else {
                k++;
            }

        }
        System.out.println();

        int l = 10;
        while(true) {
            if (l != 16 && l <= 20) {
                System.out.println(l);
                l += 2;
            } else if (l > 20) {
                break;
            } else {
                l += 2;
            }
        }
    }
}
