package diego.componentes;

import java.io.Serializable;
import java.util.ArrayList;

import diego.enums_general.Paises;

public class Componente implements Serializable {

    private String ID;
    private String designacion;
    private ArrayList<Paises> usuarios;
    private double peso;

    public Componente(String ID, String designacion, ArrayList<Paises> usuarios, double peso) {

        this.ID = ID;
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

    public String getID() {
        return ID;
    }

}
