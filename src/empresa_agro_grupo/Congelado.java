package empresa_agro_grupo;

import java.time.LocalDate;

public class Congelado extends Producto {
    
    private double tempCong;

    public Congelado(LocalDate fechaCad, String numLote, int udPorStock, double tempCong) {

        super(fechaCad, numLote, udPorStock);
        this.tempCong = tempCong;
        
    }

    public double getTempCong() {
        return tempCong;
    }

    public void setTempCong(double tempCong) {
        this.tempCong = tempCong;
    }

}
