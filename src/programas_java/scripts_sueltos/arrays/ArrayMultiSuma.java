public class ArrayMultiSuma {

    public static void main(String[] args) {

        // Generamos Array vacío (con espacios para los sumatorios)

        int[][] granArray = new int[5][];
        
        for (int i = 0; i < 5; i++) {
            granArray[i] = new int[6];
        }


        // Damos valores aleatorios entre 0 y 9 a cada espacio que necesite valores

        for (int fil = 0; fil < 4; fil++) {
            for (int col = 0; col < 5; col++) {
                granArray[fil][col] = (int)(Math.random() * 10);
            }
        }

        System.out.println();

        // Calculamos los sumatorios y los ponemos en su posición

        int totalFila = 0;
        int total = 0;

        for (int fil2 = 0; fil2 < 4; fil2 ++) {
            for (int col2 = 0; col2 < 5; col2++) {
                totalFila += granArray[fil2][col2];

                if (col2 == 4) {
                    granArray[fil2][5] = totalFila;
                    total += totalFila;
                    totalFila = 0;
                }
            }
        }

        int totalColumna = 0;

        for (int col3 = 0; col3 < 5; col3++) {
            for (int fil3 = 0; fil3 < 4; fil3++) {
                totalColumna += granArray[fil3][col3];

                if (fil3 == 3) {
                    granArray[4][col3] = totalColumna;
                    totalColumna = 0;
                }
            }
        }

        granArray[4][5] = total;

        // Pintamos el array

        for (int k = 0; k < granArray.length; k++) {
            for (int l = 0; l < granArray[k].length; l++) {
                if (l == (granArray[k].length) - 1) {
                    System.out.print(granArray[k][l]);
                } else {
                    System.out.print(granArray[k][l]);
                    System.out.print(" - ");
                }
                    
            }
            System.out.println();
        }
    }
}
