package empresa_agro_grupo;

import java.time.LocalDate;

public class Producto {

    private LocalDate fechaCad;
    private String numeroLote;

    public Producto(LocalDate fechaCad, String numeroLote) {

        this.fechaCad = fechaCad;
        this.numeroLote = numeroLote;

    }

    public LocalDate getFechaCad() {
        return fechaCad;
    }

    public void setFechaCad(LocalDate fechaCad) {
        this.fechaCad = fechaCad;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fechaCad == null) ? 0 : fechaCad.hashCode());
        result = prime * result + ((numeroLote == null) ? 0 : numeroLote.hashCode());
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
        Producto other = (Producto) obj;
        if (fechaCad == null) {
            if (other.fechaCad != null)
                return false;
        } else if (!fechaCad.equals(other.fechaCad))
            return false;
        if (numeroLote == null) {
            if (other.numeroLote != null)
                return false;
        } else if (!numeroLote.equals(other.numeroLote))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Producto [fechaCad=" + fechaCad + ", numeroLote=" + numeroLote + "]";
    }

}
