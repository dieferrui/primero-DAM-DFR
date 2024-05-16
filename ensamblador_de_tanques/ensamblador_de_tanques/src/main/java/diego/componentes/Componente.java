package diego.componentes;

import java.io.Serializable;
import diego.*;

public abstract class Componente implements Serializable {

    private String designacion;
    private Paises[] usuarios;
    private double peso;

    protected Componente(String designacion, Paises[] usuarios, double peso) {

        this.designacion = designacion;
        this.usuarios = usuarios;
        this.peso = peso;

    }

    public abstract String mostrarDatos();

    public String getDesignacion() {
        return designacion;
    }

    public Paises[] getUsuarios() {
        return usuarios;
    }

    public double getPeso() {
        return peso;
    }

}
