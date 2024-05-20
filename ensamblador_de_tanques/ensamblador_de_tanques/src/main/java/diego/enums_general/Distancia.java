package diego.enums_general;

public enum Distancia {

    CORTA(100),
    MEDIA(500),
    LARGA(1000);

    private final int metros;

    Distancia(int metros) {
        this.metros = metros;
    }

    public int getMetros() {
        return metros;
    }
}
