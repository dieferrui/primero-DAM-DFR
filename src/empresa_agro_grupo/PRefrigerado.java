import java.time.LocalDate;

public class PRefrigerado extends Producto {

    private String codAl;

    public PRefrigerado(LocalDate fechaCad, String numeroLote, String codAl) {

        super(fechaCad, numeroLote);
        this.codAl = codAl;

    }

    public String getCodAl() {
        return codAl;
    }

    public void setCodAl(String codAl) {
        this.codAl = codAl;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Código org. alimentario: ");
        sb.append(codAl);
        
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((codAl == null) ? 0 : codAl.hashCode());
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
        PRefrigerado other = (PRefrigerado) obj;
        if (codAl == null) {
            if (other.codAl != null)
                return false;
        } else if (!codAl.equals(other.codAl))
            return false;
        return true;
    }

}
