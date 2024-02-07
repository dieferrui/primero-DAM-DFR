public class CantidadesReceta {

    public static void main(String[] args) {

        final int COLIFLOR = 100;
        final double CEBOLLETAS = 1 / 6d;
        final double ZANAHORIAS = 3 / 6d;
        final double POLLO = 500 / 6d;
        final double PINYONES = 25 / 6d;
        final double PASAS = 75 / 6d;
        final double CALDO = 220 / 6d;
        final double CURRY = 1.5 / 6d;

        System.out.println("Indique para cuántas personas será la receta: ");
        int comensales = Integer.parseInt(System.console().readLine());
        if (comensales < 1) {
            comensales = 1;
        }

        System.out.printf("Para %d personas, las cantidades de ingredientes son las siguientes: \n", comensales);
        System.out.printf("-%d gr de coliflor\n", COLIFLOR * comensales);
        System.out.printf("-%.1f cebolletas\n", Math.max(0.5, CEBOLLETAS * comensales));
        System.out.printf("-%.0f zanahorias\n", Math.ceil(Math.max(1.0, ZANAHORIAS * comensales)));
        System.out.printf("-%d gr de pechuga de pollo\n", (int)(POLLO * comensales));
        System.out.printf("-%d gr de piñones\n", Math.max(10, (int)(PINYONES * comensales)));
        System.out.printf("-%d gr de pasas\n", Math.max(20, (int)(PASAS * comensales)));
        System.out.printf("-%d ml de caldo\n", (int)(comensales* CALDO));
        System.out.printf("-%.1f cucharaditas de curry\n", Math.max(0.5, CURRY * comensales));

    }
}
