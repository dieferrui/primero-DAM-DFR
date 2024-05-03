public enum ValorCartas {

    AS(11),
    DOS(2),
    TRES(3),
    CUATRO(4),
    CINCO(5),
    SEIS(6),
    SIETE(7),
    OCHO(8),
    NUEVE(9),
    DIEZ(10),
    J(10),
    Q(10),
    K(10);

    private int puntos;

    private ValorCartas(int puntos) {

        this.puntos = puntos;

    }

    public int obtenerPuntos() {

        return this.puntos;

    }
}
