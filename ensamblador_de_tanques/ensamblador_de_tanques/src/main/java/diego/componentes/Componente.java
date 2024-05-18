package diego.componentes;

import java.io.Serializable;
import diego.*;

import java.util.ArrayList;

public class Componente implements Serializable {

    private String designacion;
    private ArrayList<Paises> usuarios;
    private double peso;

    public Componente(String designacion, ArrayList<Paises> usuarios, double peso) {

        this.designacion = designacion;
        this.usuarios = usuarios;
        this.peso = peso;

    }

    public String getDesignacion() {
        return designacion;
    }

    public ArrayList<Paises> getUsuarios() {
        return usuarios;
    }

    public double getPeso() {
        return peso;
    }

}
