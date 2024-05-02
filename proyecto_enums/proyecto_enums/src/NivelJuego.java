public enum NivelJuego {

    PRINCIPIANTE,
    INTERMEDIO,
    AVANZADO;

    public boolean esAvanzado() {

        return (this == AVANZADO ? true : false);
        
    }

}
