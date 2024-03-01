package empresa_agro_grupo;

import java.time.LocalDate;

public class Fresco extends Producto {
    
    private LocalDate fechaEnv;
    private String codPais;

    public Fresco(LocalDate fechaCad, String numLote, int udPorStock, LocalDate fechaEnv, String codPais) {

        super(fechaCad, numLote, udPorStock);
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

}
