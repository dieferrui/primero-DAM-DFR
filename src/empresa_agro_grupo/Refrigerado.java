package empresa_agro_grupo;

import java.time.LocalDate;

public class Refrigerado extends Producto {
    
    private String codOrg;

    public Refrigerado(LocalDate fechaCad, String numLote, int udPorStock, String codOrg) {

        super(fechaCad, numLote, udPorStock);
        this.codOrg = codOrg;
        
    }

    public String getCodOrg() {
        return codOrg;
    }

    public void setCodOrg(String codOrg) {
        this.codOrg = codOrg;
    }

}
