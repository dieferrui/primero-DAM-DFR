package com.diego;

public class OpMatematicas {

    private java.util.ArrayList<Integer> numeros;

    public OpMatematicas(int[] datos) {

        if (datos == null || datos.length == 0) {

            throw new IllegalArgumentException();

        }

        this.numeros = new java.util.ArrayList<>();

        for (int elemento : datos) {

            numeros.add(elemento);

        }

    }

    public int getSuma() {

        int suma = 0;

        for (int elemento : numeros) {

            suma += elemento;

        }

        return suma;
    }

    public int getMinimo() {

        int min = Integer.MAX_VALUE;

        for (int elemento : numeros) {

            if (elemento < min) {

                min = elemento;

            }
        }

        return min;

    }

    public int getMaximo() {

        int max = Integer.MIN_VALUE;

        for (int elemento : numeros) {

            if (elemento > max) {

                max = elemento;

            }
        }
        
        return max;

    }

    public int getIndiceDe (int numero) throws java.util.NoSuchElementException {

        int pos = 0;

        for (int elemento : numeros) {

            if (elemento == numero) {

                return pos;

            }

            pos++;

        }

        throw new java.util.NoSuchElementException(String.valueOf(numero));
    }

    public java.util.ArrayList<Integer> getNumeros() {
        return numeros;
    }

}