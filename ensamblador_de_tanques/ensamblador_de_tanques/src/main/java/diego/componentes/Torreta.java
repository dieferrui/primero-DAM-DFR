package diego.componentes;

import diego.*;
import diego.componentes.enums.TipoTorreta;

public class Torreta extends Componente {

    private static final String MILL = "mm";
    private static final String ANG = "º";

    private String designacion;
    private Paises[] usuarios;
    private double peso;

    private TipoTorreta tipoTorreta;

    private double anguloTiro;
    private double anguloElev;
    private double anguloDepr;
    private double[] restricciones;

    private double espacio;
    
    private int blindajeFrontal;
    private int blindajeLateral;
    private int blindajeTrasero;
    private int[] blindaje;

    // El constructor sólo se usará por el administrador de la app para añadir componentes
    public Torreta(String designacion, Paises[] usuarios, double peso, TipoTorreta tipoTorreta,
                    double[] restricciones, double espacio, int[] blindaje) {

        super(designacion, usuarios, peso);

        this.tipoTorreta = tipoTorreta;

        this.restricciones = restricciones;
        if (tipoTorreta == TipoTorreta.TORRETA) {
            this.anguloTiro = 360;
        } else {
            this.anguloTiro = restricciones[0];
        }

        this.anguloElev = restricciones[1];
        this.anguloDepr = restricciones[2];

        this.espacio = espacio;

        this.blindaje = blindaje;
        this.blindajeFrontal = blindaje[0];
        this.blindajeLateral = blindaje[1];
        this.blindajeTrasero = blindaje[2];

    }

    public TipoTorreta getTipoTorreta() {
        return tipoTorreta;
    }

    public double getAnguloTiro() {
        return anguloTiro;
    }

    public double getAnguloElev() {
        return anguloElev;
    }

    public double getAnguloDepr() {
        return anguloDepr;
    }

    public double getEspacio() {
        return espacio;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(peso);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((tipoTorreta == null) ? 0 : tipoTorreta.hashCode());
        temp = Double.doubleToLongBits(anguloTiro);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(anguloElev);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(anguloDepr);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(espacio);
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
        Torreta other = (Torreta) obj;
        if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
            return false;
        if (tipoTorreta != other.tipoTorreta)
            return false;
        if (Double.doubleToLongBits(anguloTiro) != Double.doubleToLongBits(other.anguloTiro))
            return false;
        if (Double.doubleToLongBits(anguloElev) != Double.doubleToLongBits(other.anguloElev))
            return false;
        if (Double.doubleToLongBits(anguloDepr) != Double.doubleToLongBits(other.anguloDepr))
            return false;
        if (Double.doubleToLongBits(espacio) != Double.doubleToLongBits(other.espacio))
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
        return "Compartimento de combate con designación " + designacion + ":\n" +
                "Tipo: " + tipoTorreta.getTipo() + "\n" +
                "Peso: " + peso + "Kg\n" +
                "Ángulo de tiro: " + anguloTiro + ANG + "\n" +
                "Ángulo de elevación: " + anguloElev + ANG + "\n" +
                "Ángulo de depresión: " + anguloDepr + ANG + "\n" +
                "Blindaje frontal: " + blindajeFrontal + MILL + "\n" +
                "Blindaje lateral: " + blindajeLateral + MILL + "\n" +
                "Blindaje trasero: " + blindajeTrasero + MILL;
    }
}
