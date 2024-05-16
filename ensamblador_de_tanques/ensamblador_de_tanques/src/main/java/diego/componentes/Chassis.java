package diego.componentes;

import java.io.Serializable;

public class Chassis implements Serializable {

    private static final String MILL = "mm";

    private String designacion;
    private String pais;
    private String[] nomenclatura;

    private double cargaMaxima;
    private double cargaActual;
    private double[] carga = {cargaMaxima, cargaActual};

    private double espacioInterno;
    private double espacioOcupado;
    private double[] espacio = {espacioInterno, espacioOcupado};

    private int blindajeFrontal;
    private int blindajeLateral;
    private int blindajeTrasero;
    private int[] blindaje = {blindajeFrontal, blindajeLateral, blindajeTrasero};

    // El constructor sólo se usará por el administrador de la app para añadir componentes
    public Chassis(String[] nomenclatura, double[] carga, double[] espacio, int[] blindaje) {

        this.nomenclatura = nomenclatura;
        this.designacion = nomenclatura[0];
        this.pais = nomenclatura[1];

        this.carga = carga;
        this.cargaMaxima = carga[0];
        this.cargaActual = carga[1];

        this.espacio = espacio;
        this.espacioInterno = espacio[0];
        this.espacioOcupado = espacio[1];

        this.blindaje = blindaje;
        this.blindajeFrontal = blindaje[0];
        this.blindajeLateral = blindaje[1];
        this.blindajeTrasero = blindaje[2];

    }

    // Getters (se incluyen todas las características individuales)
    public String getPais() {
        return pais;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public double getEspacioInterno() {
        return espacioInterno;
    }

    public double getEspacioOcupado() {
        return espacioOcupado;
    }

    public int getBlindajeFrontal() {
        return blindajeFrontal;
    }

    public int getBlindajeLateral() {
        return blindajeLateral;
    }

    public int getBlindajeTrasero() {
        return blindajeTrasero;
    }

    public String getDesignacion() {
        return designacion;
    }

    // Setters (sólo se incluyen las características que se pueden modificar)
    public void setCargaActual(double cargaActual) {
        this.cargaActual = cargaActual;
    }

    public void setEspacioOcupado(double espacioOcupado) {
        this.espacioOcupado = espacioOcupado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((designacion == null) ? 0 : designacion.hashCode());
        result = prime * result + ((pais == null) ? 0 : pais.hashCode());
        long temp;
        temp = Double.doubleToLongBits(cargaMaxima);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(espacioInterno);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + blindajeFrontal;
        result = prime * result + blindajeLateral;
        result = prime * result + blindajeTrasero;
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
        Chassis other = (Chassis) obj;
        if (designacion == null) {
            if (other.designacion != null)
                return false;
        } else if (!designacion.equals(other.designacion))
            return false;
        if (pais == null) {
            if (other.pais != null)
                return false;
        } else if (!pais.equals(other.pais))
            return false;
        if (Double.doubleToLongBits(cargaMaxima) != Double.doubleToLongBits(other.cargaMaxima))
            return false;
        if (Double.doubleToLongBits(espacioInterno) != Double.doubleToLongBits(other.espacioInterno))
            return false;
        if (blindajeFrontal != other.blindajeFrontal)
            return false;
        if (blindajeLateral != other.blindajeLateral)
            return false;
        if (blindajeTrasero != other.blindajeTrasero)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Chassis [designacion=" + designacion + ", pais=" + pais + ", cargaMaxima=" + cargaMaxima
                + ", espacioInterno=" + espacioInterno + ", blindajeFrontal=" + blindajeFrontal + ", blindajeLateral="
                + blindajeLateral + ", blindajeTrasero=" + blindajeTrasero + "]";
    }

    public String mostrarDatos() {
        return "Chasis " + this.devolverOrigen(pais) + ", designación " + designacion + ":\n" +
                "Carga máxima: " + cargaMaxima + " Kg\n" +
                "Blindaje frontal: " + blindajeFrontal + " " + MILL + "\n" +
                "Blindaje lateral: " + blindajeLateral + " " + MILL + "\n" +
                "Blindaje trasero: " + blindajeTrasero + " " + MILL;
    }

    public String devolverOrigen(String pais) {

        switch (pais) {
            case "ALEMANIA":
                return "alemán";
            case "EEUU":
                return "estadounidense";
            case "UK":
                return "inglés";
            case "URSS":
                return "soviético";
            default:
                return "de potencia secundaria";
        }
    }
}
