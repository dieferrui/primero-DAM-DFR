package diego.componentes;

public enum Municion {

    AP("Armor Piercing"),
    APCR("Armor Piercing Composite Rigid"),
    APHE("Armor Piercing High Explosive"),
    HE("High Explosive"),
    HESH("High Explosive Squash Head"),
    HEAT("High Explosive Anti Tank");

    private final String tipo;

    Municion(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
