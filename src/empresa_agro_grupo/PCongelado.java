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
}
