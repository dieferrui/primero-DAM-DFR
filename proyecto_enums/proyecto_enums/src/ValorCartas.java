public enum ValorCartas {

    AS(13),
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
    Q(11),
    K(12);

    private int puntos;

    private ValorCartas(int puntos) {

        this.puntos = puntos;

    }

    public int obtenerPuntos() {

        return this.puntos;

    }
}
