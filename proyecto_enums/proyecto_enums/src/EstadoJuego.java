public enum EstadoJuego {

    INICIADO,
    EN_PROGRESO,
    PAUSADO,
    TERMINADO;

    public String mostrarEstado() {

        switch (this) {

            case INICIADO:
                return "El juego sólo acaba de empezar";

            case EN_PROGRESO:
                return "El juego está en progreso";

            case PAUSADO:
                return "El juego está en pausa";

            case TERMINADO:
                return "El juego se ha acabado";

            default:
                return "Estado inválido";
        }
    }

}
