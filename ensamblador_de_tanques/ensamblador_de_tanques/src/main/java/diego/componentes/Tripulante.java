package diego.componentes;

import diego.componentes.enums.RolTripulante;
import java.io.Serializable;

public class Tripulante implements Serializable {

    private RolTripulante rol;
    private int experiencia;

    public Tripulante(RolTripulante rol, int experiencia) {

        this.rol = rol;
        this.experiencia = experiencia;

    }

    public RolTripulante getRol() {
        return rol;
    }

    public int getExperiencia() {
        return experiencia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rol == null) ? 0 : rol.hashCode());
        result = prime * result + experiencia;
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
        Tripulante other = (Tripulante) obj;
        if (rol != other.rol)
            return false;
        if (experiencia != other.experiencia)
            return false;
        return true;
    }

}
