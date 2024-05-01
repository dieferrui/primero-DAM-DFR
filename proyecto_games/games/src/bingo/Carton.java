package bingo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Carton {

    Random random = new Random();

    private int[] fila1 = new int[9];
    private int[] fila2 = new int[9];
    private int[] fila3 = new int[9];
    int aciertos;

    private final String ZERO = "0";
    private final String NULL_VAL = "--";

    public Carton() {

        int[] numElegidos = generarNumeros();

        fila1 = repartirNumeros(numElegidos, 1);
        fila2 = repartirNumeros(numElegidos, 2);
        fila3 = repartirNumeros(numElegidos, 3);

    }

    public int[] generarNumeros() {

        int[] numElegidos = new int[15];
        Set<Integer> numControl = new HashSet<>(15);
        int numero = 1;

        for (int i = 0; i < 15; i++) {

            do {

                numero = random.nextInt(91);

                if (numero == 0) {
                    numero = 1;
                }

            } while (numControl.contains(numero));

            numControl.add(numero);
            numElegidos[i] = numero;
            
        }

        return numElegidos;

    }

    public int[] repartirNumeros(int[] numRepartir, int fila) {

        int[] numeros = new int[5];
        int[] numReturn = new int[9];
        Set<Integer> posiciones = new HashSet<>();
        int numeroPos = 0;

        switch (fila) {
            
            case 1: numeros = Arrays.copyOfRange(numRepartir, 0, 5); break;

            case 2: numeros = Arrays.copyOfRange(numRepartir, 5, 10); break;

            case 3: numeros = Arrays.copyOfRange(numRepartir, 10, 15); break;

        }

        for (int i = 0; i < 5; i++) {

            do {

                numeroPos = random.nextInt(9);

            } while (posiciones.contains(numeroPos));

            posiciones.add(numeroPos);
            
            numReturn[numeroPos] = numeros[i];
            
        }

        return numReturn;

    }

    public int[] getFila1() {
        return fila1;
    }

    public void setFila1(int[] fila1) {
        this.fila1 = fila1;
    }

    public int[] getFila2() {
        return fila2;
    }

    public void setFila2(int[] fila2) {
        this.fila2 = fila2;
    }

    public int[] getFila3() {
        return fila3;
    }

    public void setFila3(int[] fila3) {
        this.fila3 = fila3;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    @Override
    public String toString() {

        String fil1;
        String fil2;
        String fil3;
        StringBuilder sb = new StringBuilder("[");

        Set<String> digitosSingulares = new HashSet<>(Set.of("1", "2", "3", "4", "5", "6", "7", "8", "9"));

        for (int i = 0; i < 9; i++) {

            String valorNum = String.valueOf(fila1[i]);

            if (valorNum.equals(ZERO)) {

                valorNum = NULL_VAL;

            } else if (digitosSingulares.contains(valorNum)) {

                valorNum = ZERO + valorNum;
                
            }

            sb.append(valorNum + " ");

        }

        sb.append("]");
        fil1 = sb.toString();

        sb.delete(0, 999);
        sb.append("[");

        for (int i = 0; i < 9; i++) {

            String valorNum = String.valueOf(fila2[i]);

            if (valorNum.equals(ZERO)) {

                valorNum = NULL_VAL;

            } else if (digitosSingulares.contains(valorNum)) {

                valorNum = ZERO + valorNum;
                
            }

            sb.append(valorNum + " ");

        }

        sb.append("]");
        fil2 = sb.toString();

        sb.delete(0, 999);
        sb.append("[");

        for (int i = 0; i < 9; i++) {

            String valorNum = String.valueOf(fila3[i]);

            if (valorNum.equals(ZERO)) {

                valorNum = NULL_VAL;

            } else if (digitosSingulares.contains(valorNum)) {

                valorNum = ZERO + valorNum;
                
            }

            sb.append(valorNum + " ");

        }

        sb.append("]");
        fil3 = sb.toString();

        sb.delete(0, 999);

        return fil1 + "\n" + fil2 + "\n" + fil3+ "\n";

    }
    
}
