import java.time.LocalDate;

public class PFresco extends Producto {

    private LocalDate fechaEnv;
    private String codPais;

    public PFresco(LocalDate fechaCad, String numeroLote, int unidadesStock, double peso, int cantidad, LocalDate fechaEnv, String codPais) {

        super(fechaCad, numeroLote, unidadesStock, peso, cantidad);
        this.fechaEnv = fechaEnv;
        this.codPais = codPais;

    }

    public LocalDate getFechaEnv() {

        return fechaEnv;

    }

    public void setFechaEnv(LocalDate fechaEnv) {

        this.fechaEnv = fechaEnv;

    }

    public String getCodPais() {

        return codPais;

    }

    public void setCodPais(String codPais) {

        this.codPais = codPais;

    }


    @Override
    public String mostrarDatos() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha envasado: ");
        sb.append(fechaEnv).append("\n");
        sb.append("Código de país: ");
        sb.append(codPais);

        return sb.toString();
    }

}
