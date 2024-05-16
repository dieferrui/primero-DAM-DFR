package diego.componentes;

import diego.Paises;

public class Motor extends Componente {

    private String designacion;
    private Paises[] usuarios;
    private double peso;

    private double aceleracion;
    private double velocidadMax;
    private int potencia;

    public Motor(String designacion, Paises[] usuarios, double peso, double aceleracion, 
                    double velocidadMax, int potencia) {

        super(designacion, usuarios, peso);

        this.aceleracion = aceleracion;
        this.velocidadMax = velocidadMax;
        this.potencia = potencia;

    }

    public double getAceleracion() {
        return aceleracion;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public int getPotencia() {
        return potencia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(aceleracion);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(velocidadMax);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + potencia;
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
        Motor other = (Motor) obj;
        if (Double.doubleToLongBits(aceleracion) != Double.doubleToLongBits(other.aceleracion))
            return false;
        if (Double.doubleToLongBits(velocidadMax) != Double.doubleToLongBits(other.velocidadMax))
            return false;
        if (potencia != other.potencia)
            return false;
        return true;
    }

    public String mostrarDatos() {
        return "Motor con designación " + designacion + ":\n" +
                "Peso: " + peso + "Kg\n" +
                "Potencia: " + potencia + "CV\n" +
                "Velocidad máxima: " + velocidadMax + "Km/h";
    }
}