package empresa_agro;

public class Fresco extends Producto {
    
    private String fechaEnvasado;
    private String codPais;

    public Fresco(int diasCaducidad, String numLote, String fechaEnvasado, String codPais) {

        super(diasCaducidad, numLote);
        this.fechaEnvasado = fechaEnvasado;
        this.codPais = codPais;

    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((fechaEnvasado == null) ? 0 : fechaEnvasado.hashCode());
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
        Fresco other = (Fresco) obj;
        if (fechaEnvasado == null) {
            if (other.fechaEnvasado != null)
                return false;
        } else if (!fechaEnvasado.equals(other.fechaEnvasado))
            return false;
        if (codPais == null) {
            if (other.codPais != null)
                return false;
        } else if (!codPais.equals(other.codPais))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Fresco [fechaEnvasado=" + fechaEnvasado + ", codPais=" + codPais + "]";
    }

}
