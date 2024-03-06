import java.time.LocalDate;

public class PRefrigerado extends Producto {

    private String codAl;

    public PRefrigerado(LocalDate fechaCad, String numeroLote, int unidadesStock,  double peso, int cantidad, String codAl) {

        super(fechaCad, numeroLote, unidadesStock, peso, cantidad);
        this.codAl = codAl;

    }

    public String getCodAl() {

        return codAl;

    }

    public void setCodAl(String codAl) {

        this.codAl = codAl;

    }

    @Override
    public String mostrarDatos() {

        return codAl;
        
    }
}
