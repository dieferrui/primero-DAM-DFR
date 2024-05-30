package diego.componentes;

import java.util.ArrayList;

import diego.enums_general.Paises;

public class Motor extends Componente implements Comparable<Motor>{

    private String ID;
    private String designacion;
    private ArrayList<Paises> usuarios;
    private double peso;

    private double velocidadMax;
    private int potencia;

    public Motor(String ID, String designacion, ArrayList<Paises> usuarios, double peso, 
                    double velocidadMax, int potencia) {

        super(ID, designacion, usuarios, peso);

        this.velocidadMax = velocidadMax;
        this.potencia = potencia;

    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public int getPotencia() {
        return potencia;
    }

    @Override
    public int compareTo(Motor otroMotor) {
        
        int returnValue = 0;

        returnValue = Integer.compare(this.getPotencia(), otroMotor.getPotencia());

        if (returnValue == 0) {

            returnValue = Double.compare(this.getVelocidadMax(), otroMotor.getVelocidadMax());

        }

        return returnValue;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
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
        if (Double.doubleToLongBits(velocidadMax) != Double.doubleToLongBits(other.velocidadMax))
            return false;
        if (potencia != other.potencia)
            return false;
        return true;
    }

    public String mostrarDatos() {
        return "Motor con designación " + getDesignacion() + ":\n" +
                "Peso: " + getPeso() + "Kg\n" +
                "Potencia: " + getPotencia() + "CV\n" +
                "Velocidad máxima: " + getVelocidadMax() + "Km/h";
    }
}
