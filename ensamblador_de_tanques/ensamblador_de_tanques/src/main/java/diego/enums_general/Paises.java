package diego.enums_general;

public enum Paises {

    USA("USA"), // Estados Unidos
    GBR("GBR"), // Reino Unido
    RUS("RUS"), // Rusia
    GER("GER"), // Alemania
    SWE("SWE"), // Suecia
    FRA("FRA"), // Francia
    ITA("ITA"), // Italia
    JAP("JAP"), // Japón
    CHN("CHN"); // China

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
