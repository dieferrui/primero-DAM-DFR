package empresa_agro_grupo;

import java.time.LocalDate;

public class Producto {
    
    private LocalDate fechaCad;
    private String numLote;
    private int udPorStock;

    public Producto(LocalDate fechaCad, String numLote, int udPorStock) {

        this.fechaCad = fechaCad;
        this.numLote = numLote;
        this.udPorStock = udPorStock;

    }

    public LocalDate getFechaCad() {
        return fechaCad;
    }

    public void setFechaCad(LocalDate fechaCad) {
        this.fechaCad = fechaCad;
    }

    public String getNumLote() {
        return numLote;
    }

    public void setNumLote(String numLote) {
        this.numLote = numLote;
    }

    public int getUdPorStock() {
        return udPorStock;
    }

    public void setUdPorStock(int udPorStock) {
        this.udPorStock = udPorStock;
    }

}
