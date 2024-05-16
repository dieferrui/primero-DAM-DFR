package diego.componentes;

import diego.*;
import java.text.DecimalFormat;

public class Chassis extends Componente {

    private static final String MILL = "mm";

    private String designacion;
    private Paises[] usuarios;
    private double peso;

    private double cargaMaxima;
    private double cargaActual;
    private double[] carga = {cargaMaxima, cargaActual};

    private int blindajeFrontal;
    private int blindajeLateral;
    private int blindajeTrasero;
    private int[] blindaje = {blindajeFrontal, blindajeLateral, blindajeTrasero};

    // El constructor sólo se usará por el administrador de la app para añadir componentes
    public Chassis(String designacion, Paises[] usuarios, double peso, double[] carga, 
                    int[] blindaje) {

        super(designacion, usuarios, peso);

        this.carga = carga;
        this.cargaMaxima = carga[0];
        this.cargaActual = carga[1];

        this.blindaje = blindaje;
        this.blindajeFrontal = blindaje[0];
        this.blindajeLateral = blindaje[1];
        this.blindajeTrasero = blindaje[2];

    }

    // Getters (se incluyen todas las características individuales)

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public double getCargaActual() {
        return cargaActual;
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

    // Setters (sólo se incluyen las características que se pueden modificar)
    public void setCargaActual(double cargaActual) {
        this.cargaActual = cargaActual;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(peso);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cargaMaxima);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + blindajeFrontal;
        result = prime * result + blindajeLateral;
        result = prime * result + blindajeTrasero;
        result = prime * result + ((designacion == null) ? 0 : designacion.hashCode());
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
        if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
            return false;
        if (Double.doubleToLongBits(cargaMaxima) != Double.doubleToLongBits(other.cargaMaxima))
            return false;
        if (blindajeFrontal != other.blindajeFrontal)
            return false;
        if (blindajeLateral != other.blindajeLateral)
            return false;
        if (blindajeTrasero != other.blindajeTrasero)
            return false;
        return true;
    }

    public String mostrarDatos() {

        DecimalFormat df = new DecimalFormat("#.#");
        String pesoFormat = df.format(peso/1000);
        
        return "Chasis con designación " + designacion + ":\n" +
                "Peso: " + pesoFormat + "t\n" +
                "Carga máxima: " + cargaMaxima + "Kg\n" +
                "Blindaje frontal: " + blindajeFrontal + MILL + "\n" +
                "Blindaje lateral: " + blindajeLateral + MILL + "\n" +
                "Blindaje trasero: " + blindajeTrasero + MILL;
    }

}
