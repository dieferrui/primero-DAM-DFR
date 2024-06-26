package diego;

import java.io.Serializable;
import java.util.Arrays;

import diego.componentes.*;
import java.text.DecimalFormat;

public class Tanque implements Serializable, Comparable<Tanque> {

    private static final long serialVersionUID = 8008L;

    private String nombre;

    private Chassis chasis;
    private Torreta torreta;
    private Motor motor;
    private Armamento arma;
    private Tripulante[] tripulacion;
    private double relacionPotencia;
    private String clase;

    public Tanque() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Chassis getChasis() {
        return chasis;
    }

    public void setChasis(Chassis chasis) {
        this.chasis = chasis;
    }

    public Torreta getTorreta() {
        return torreta;
    }

    public void setTorreta(Torreta torreta) {
        this.torreta = torreta;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Armamento getArma() {
        return arma;
    }

    public void setArma(Armamento arma) {
        this.arma = arma;
    }

    public Tripulante[] getTripulacion() {
        return tripulacion;
    }

    public double getRelacionPotencia() {
        return relacionPotencia;
    }

    public void setTripulacion(Tripulante[] tripulacion) {
        this.tripulacion = tripulacion;
    }

    public void setRelacionPotencia(double relacionPotencia) {
        this.relacionPotencia = relacionPotencia;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chasis == null) ? 0 : chasis.hashCode());
        result = prime * result + ((torreta == null) ? 0 : torreta.hashCode());
        result = prime * result + ((motor == null) ? 0 : motor.hashCode());
        result = prime * result + ((arma == null) ? 0 : arma.hashCode());
        result = prime * result + Arrays.hashCode(tripulacion);
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
        Tanque other = (Tanque) obj;
        if (chasis == null) {
            if (other.chasis != null)
                return false;
        } else if (!chasis.equals(other.chasis))
            return false;
        if (torreta == null) {
            if (other.torreta != null)
                return false;
        } else if (!torreta.equals(other.torreta))
            return false;
        if (motor == null) {
            if (other.motor != null)
                return false;
        } else if (!motor.equals(other.motor))
            return false;
        if (arma == null) {
            if (other.arma != null)
                return false;
        } else if (!arma.equals(other.arma))
            return false;
        if (!Arrays.equals(tripulacion, other.tripulacion))
            return false;
        return true;
    }
    
    // Compara cada tanque y lo ordena según su peso total
    @Override
    public int compareTo(Tanque otroTanque) {
        return Double.compare(this.getChasis().getCargaActual(), otroTanque.getChasis().getCargaActual());
    }

    public String mostrarDatosCompletos() {

        DecimalFormat df = new DecimalFormat("#.#");
        String relacionPotFormat = df.format(getRelacionPotencia());

        return getClase() + " " + getNombre() + "\n" +
                "Tripulantes: " + getTripulacion().length + "\n\n" +
                "Relación potencia/peso: " + relacionPotFormat + "CV/t\n\n" +
                getChasis().mostrarDatos() + "\n\n" + 
                getTorreta().mostrarDatos() + "\n\n" + 
                getMotor().mostrarDatos() + "\n\n" + 
                getArma().toString() + "\n\n";
    }
}
