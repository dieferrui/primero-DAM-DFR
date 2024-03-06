import java.time.LocalDate;

public class Producto {

    private LocalDate fechaCad;
    private String numeroLote;

    public Producto(LocalDate fechaCad, String numeroLote) {

        this.fechaCad = fechaCad;
        this.numeroLote = numeroLote;

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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
