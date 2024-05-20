package diego.enums_general;

public enum Terreno {

    DESIERTO(1), // En terreno desértico, las estadísticas de movilidad de los tanques tienen menor peso en el combate.
    BOSQUE(2), // En terreno boscoso, los valores de blindaje lateral y trasero de los tanques tienen mayor peso en el combate.
    MONTAÑA(3), // En terreno montañoso, los valores de blindaje frontal y de angulo de depresión de la torreta tienen mayor peso en el combate.
    CIUDAD(4), // En terreno urbano, los valores de ángulo de giro de la torreta no tienen peso en el combate.
    LLANURA(5); // En terreno llano, las estadísticas de movilidad de los tanques tienen mayor peso en el combate.

    private final int tipo;

    Terreno(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
}
