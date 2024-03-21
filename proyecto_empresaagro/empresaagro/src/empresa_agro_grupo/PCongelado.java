package empresa_agro_grupo;

import java.time.LocalDate;

public class PCongelado extends Producto {

    private double tempCong;

    public PCongelado(LocalDate fechaCad, String numeroLote, double tempCong) {

        super(fechaCad, numeroLote);
        this.tempCong = tempCong;

    }

    public double getTempCong() {
        return tempCong;
    }

    public void setTempCong(double tempCong) {
        this.tempCong = tempCong;
    }

    @Override
    public String toString() { 
        
        StringBuilder sb = new StringBuilder();
        sb.append("Temp. recomendada de congelación: ");
        sb.append(tempCong);

        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(tempCong);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        PCongelado other = (PCongelado) obj;
        if (Double.doubleToLongBits(tempCong) != Double.doubleToLongBits(other.tempCong))
            return false;
        return true;
    }

}
