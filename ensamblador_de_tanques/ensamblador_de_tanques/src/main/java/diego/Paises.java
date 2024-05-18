package diego;

public enum Paises {

    USA("USA"),
    GBR("GBR"),
    RUS("RUS"),
    GER("GER"),
    SWE("SWE"),
    FRA("FRA"),
    ITA("ITA"),
    JAP("JAP"),
    CHN("CHN");

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
