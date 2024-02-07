public class SumaEntero {

    public static void main(String[] args) {
        
        whileDo();
        doWhile();
        forLoop();
    }

    public static void whileDo() {

        int cont = 0;
        int total = 0;

        while (cont <= 10) {
            total += cont;
            cont++;
        }

        System.out.println(total);
    }

    public static void doWhile() {

        int cont = 0;
        int total = 0;

        do {
            total += cont;
            cont++;
        } while (cont <= 10);

        System.out.println(total);
    }

    public static void forLoop() {

        int total = 0;
        
        for (int i = 0; i <= 10; i++) {
            total += i;
        }

        System.out.println(total);
    }
}
