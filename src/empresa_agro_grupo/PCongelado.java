import java.time.LocalDate;

public class PCongelado extends Producto {

    private double tempCong;

    public PCongelado(LocalDate fechaCad, String numeroLote, int unidadesStock, double peso, int cantidad, double tempCong) {

        super(fechaCad, numeroLote, unidadesStock, peso, cantidad);
        this.tempCong = tempCong;

    }

    public double getTempCong() {

        return tempCong;

    }

    public void setTempCong(double tempCong) {

        this.tempCong = tempCong;

    }

    @Override
    public String mostrarDatos() { StringBuilder sb = new StringBuilder();

        sb.append(tempCong);
        return sb.toString();
        
    }
}
