import java.time.LocalDate;

public class PRefrigerado extends Producto {

    private String codAl;

    public PRefrigerado(LocalDate fechaCad, String numeroLote, String codAl) {

        super(fechaCad, numeroLote);
        this.codAl = codAl;

    }

    public String getCodAl() {
        return codAl;
    }

    public void setCodAl(String codAl) {
        this.codAl = codAl;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Código org. alimentario: ");
        sb.append(codAl);
        
        return sb.toString();
    }
}
