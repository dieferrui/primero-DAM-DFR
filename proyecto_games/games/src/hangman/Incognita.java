package hangman;

import java.util.*;
import java.io.*;

public class Incognita {
    
    private static Random random = new Random();
    private boolean isSolved = false;
    private String texto;
    private String tipo;

    public Incognita(String texto, String tipo, boolean isSolved) {

        this.texto = texto;
        this.tipo = tipo;
        this.isSolved = isSolved;

    }

    public static Incognita[] getArrayIncognitas() {

        File directorioTipos = new File("proyecto_games\\games\\src\\hangman\\tipos");
        File[] tipos = directorioTipos.listFiles();

        int numTipos = tipos.length;
        Incognita[] incognitas = new Incognita[7];

        for (int i = 0; i < 7; i++) {

            File tipoSeleccionado = tipos[random.nextInt(numTipos)];
            String tipoArchivo = tipoSeleccionado.getName();
            String tipo = tipoArchivo.substring(0, tipoArchivo.lastIndexOf("."));

            /*
            Como no se puede reasignar un recurso dentro de un try-with-resources,
            y no podemos regresar el puntero del bufferedreader al principio del archivo,
            tengo que sacar los contenidos de las líneas del archivo para luego trabajar
            con ellos sin problema.
            */
            try (BufferedReader br = new BufferedReader(new FileReader(tipoSeleccionado))) {

                ArrayList<String> lineas = new ArrayList<>();
                String linea;

                while ((linea = br.readLine()) != null) {

                    lineas.add(linea);

                }

                int lineaAleatoria = random.nextInt(lineas.size());
                String texto = lineas.get(lineaAleatoria);

                Incognita incognita = new Incognita(texto, tipo, false);
                incognitas[i] = incognita;

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        return incognitas;

    }
    

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (isSolved ? 1231 : 1237);
        result = prime * result + ((texto == null) ? 0 : texto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Incognita other = (Incognita) obj;
        if (tipo != other.tipo)
            return false;
        if (texto == null) {
            if (other.texto != null)
                return false;
        } else if (!texto.equals(other.texto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Incognita [texto=" + texto + ", tipo=" + tipo + "]";
    }

}
