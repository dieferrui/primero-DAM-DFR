import java.time.LocalDate;

public abstract class Producto {

    private LocalDate fechaCad;
    private String numeroLote;
    private int unidadesStock;
    private double peso;
    private int cantidad;


    public Producto(LocalDate fechaCad, String numeroLote, int unidadesStock, double peso, int cantidad) {

        this.fechaCad = fechaCad;
        this.numeroLote = numeroLote;
        this.unidadesStock = unidadesStock;
        this.peso = peso;
        this.cantidad = cantidad;
        
    }

    public LocalDate getFechaCad() {
        return fechaCad;
    }

    public void setFechaCad(LocalDate fechaCad) {
        this.fechaCad = fechaCad;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public int getUnidadesStock() {
        return unidadesStock;
    }

    public void setUnidadesStock(int unidadesStock) {
        this.unidadesStock = unidadesStock;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public abstract String mostrarDatos();
}
