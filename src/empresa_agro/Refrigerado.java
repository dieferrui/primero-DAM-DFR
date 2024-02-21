package empresa_agro;

public class Refrigerado extends Producto {
    
    private String codOrganismo;

    public Refrigerado(int diasCaducidad, String numLote, String codOrganismo) {

        super(diasCaducidad, numLote);
        this.codOrganismo = codOrganismo;

    }

    public String getCodOrganismo() {
        return codOrganismo;
    }

    public void setCodOrganismo(String codOrganismo) {
        this.codOrganismo = codOrganismo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((codOrganismo == null) ? 0 : codOrganismo.hashCode());
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
        Refrigerado other = (Refrigerado) obj;
        if (codOrganismo == null) {
            if (other.codOrganismo != null)
                return false;
        } else if (!codOrganismo.equals(other.codOrganismo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Refrigerado [codOrganismo=" + codOrganismo + "]";
    }

}
