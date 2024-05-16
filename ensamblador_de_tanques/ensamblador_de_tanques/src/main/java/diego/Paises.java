package diego;

public enum Paises {

    ESTADOS_UNIDOS("EEUU"),
    REINO_UNIDO("UK"),
    UNION_SOVIETICA("URSS"),
    ALEMANIA("ALEMANIA");

    private final String nombre;

    Paises(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
