import java.time.LocalDate;

public class PFresco extends Producto {

    private LocalDate fechaEnv;
    private String codPais;

    public PFresco(LocalDate fechaCad, String numeroLote, LocalDate fechaEnv, String codPais) {

        super(fechaCad, numeroLote);
        this.fechaEnv = fechaEnv;
        this.codPais = codPais;

    }

    public LocalDate getFechaEnv() {
        return fechaEnv;
    }

    public void setFechaEnv(LocalDate fechaEnv) {
        this.fechaEnv = fechaEnv;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Fecha envasado: ");
        sb.append(fechaEnv).append("\n");
        sb.append("Código de país: ");
        sb.append(codPais);

        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((fechaEnv == null) ? 0 : fechaEnv.hashCode());
        result = prime * result + ((codPais == null) ? 0 : codPais.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PFresco other = (PFresco) obj;
        if (fechaEnv == null) {
            if (other.fechaEnv != null)
                return false;
        } else if (!fechaEnv.equals(other.fechaEnv))
            return false;
        if (codPais == null) {
            if (other.codPais != null)
                return false;
        } else if (!codPais.equals(other.codPais))
            return false;
        return true;
    }

}
