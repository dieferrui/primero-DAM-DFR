package practica.demo_vehiculo;

/**
 * Superclase que engloba todos los vehículos que tienen ruedas.
 */
public class Vehiculo {
    protected int nRuedas;
    protected int nAsientos;
    protected String tipoTraccion;
    private boolean packFumador;
    private boolean tapiceriaCuero;
    private String tipoTapiceria;

    public Vehiculo(int nRuedas, int nAsientos) {
        this.nRuedas = nRuedas;
        this.nAsientos = nAsientos;
    }

    public Vehiculo(int nRuedas, String tipoTraccion) {
        this.nRuedas = nRuedas;
        this.tipoTraccion = tipoTraccion;
    }



    public int getnRuedas() {
        return nRuedas;
    }

    public void setnRuedas(int nRuedas) {
        this.nRuedas = nRuedas;
    }

    public int getnAsientos() {
        return nAsientos;
    }

    public void setnAsientos(int nAsientos) {
        this.nAsientos = nAsientos;
    }

    public String getTipoTraccion() {
        return tipoTraccion;
    }

    public void setTipoTraccion(String tipoTraccion) {
        this.tipoTraccion = tipoTraccion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + nRuedas;
        result = prime * result + nAsientos;
        result = prime * result + ((tipoTraccion == null) ? 0 : tipoTraccion.hashCode());
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
        Vehiculo other = (Vehiculo) obj;
        if (nRuedas != other.nRuedas)
            return false;
        if (nAsientos != other.nAsientos)
            return false;
        if (tipoTraccion == null) {
            if (other.tipoTraccion != null)
                return false;
        } else if (!tipoTraccion.equals(other.tipoTraccion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vehiculo [nRuedas=" + nRuedas + ", nAsientos=" + nAsientos + ", tipoTraccion=" + tipoTraccion + "]";
    }

    

}
