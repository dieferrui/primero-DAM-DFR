package diego;

public enum Paises {

    ESTADOS_UNIDOS("USA"),
    REINO_UNIDO("GBR"),
    UNION_SOVIETICA("RUS"),
    ALEMANIA("GER");

    private final String nombre;

    Paises(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static boolean contiene(String nombre) {

        for (Paises pais : Paises.values()) {

            if (pais.getNombre().equalsIgnoreCase(nombre)) {

                return true;

            }
        }

        return false;
    }
}
