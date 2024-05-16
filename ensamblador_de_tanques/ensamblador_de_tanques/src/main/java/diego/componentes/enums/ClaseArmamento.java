package diego.componentes.enums;

public enum ClaseArmamento {

    CANNON("Cañón"),
    AUTOCANNON("Cañón automático"),
    HOWITZER("Mortero");

    private final String clase;

    ClaseArmamento(String clase) {
        this.clase = clase;
    }

    public String getClase() {
        return clase;
    }
}
