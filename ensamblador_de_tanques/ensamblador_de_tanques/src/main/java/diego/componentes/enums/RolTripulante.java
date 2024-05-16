package diego.componentes.enums;

public enum RolTripulante {

    COMANDANTE("Comandante"), 
    CONDUCTOR("Conductor"),
    ARTILLERO("Artillero"),
    OPERADOR_DE_RADIO("Operador de radio"),
    CARGADOR("Cargador"),
    TRIPULANTE_AUXILIAR("Auxiliar");

    private final String rol;

    RolTripulante(String rol) {
        this.rol = rol;
    }

    public String getrol() {
        return rol;
    }
}
