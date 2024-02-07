import java.util.Arrays;

public class ComparacionImprobable {

    public static void main(String[] args) {

        boolean sonIguales;
        int contador = 0;

        do {

            // Genera las líneas y columnas de los arrays entre 2 y 9

            double notRandy = Math.max(2, Math.random() * 10);
            int randy = (int)notRandy;

            
            // Declara, genera y pinta array 1

            int[][] arrayNum = new int[randy][];

            for (int i = 0; i < randy; i++) {
                arrayNum[i] = new int[randy];
                
                for (int j = 0; j < randy; j++) {
                    arrayNum[i][j] = (int)(Math.random() * 10);
                }
            }

            for (int k = 0; k < arrayNum.length; k++) {
                for (int l = 0; l < arrayNum[k].length; l++) {
                    if (l == (arrayNum[k].length) - 1) {
                        System.out.print(arrayNum[k][l]);
                    } else {
                        System.out.print(arrayNum[k][l]);
                        System.out.print(" - ");
                    }
                    
                }
                System.out.println();
            }

            System.out.println();

            
            // Declara, genera y pinta array 2

            int[][] arrayNum2 = new int[randy][];

            for (int m = 0; m < randy; m++) {
                arrayNum2[m] = new int[randy];
                
                for (int n = 0; n < randy; n++) {
                    arrayNum2[m][n] = (int)(Math.random() * 10);
                }
            }

            for (int r = 0; r < arrayNum.length; r++) {
                for (int t = 0; t < arrayNum2[r].length; t++) {
                    if (t == (arrayNum2[r].length) - 1) {
                        System.out.print(arrayNum2[r][t]);
                    } else {
                        System.out.print(arrayNum2[r][t]);
                        System.out.print(" - ");
                    }
                    
                }
                System.out.println();
            }
            System.out.println();


            // Compara los arrays y reinicia el bucle si no son iguales

            sonIguales = Arrays.deepEquals(arrayNum, arrayNum2);
            System.out.println(sonIguales);
            contador++;
            System.out.println();
            System.out.println();

        } while (!sonIguales);


        // Cuenta el número de veces que se ha realizado el bucle

        System.out.printf("Intentos realizados: %d.", contador);
    }
}
