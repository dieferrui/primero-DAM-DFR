package diego.enums_general;

public enum Situacion {

    NEUTRA(1), // Un tanque en en situación neutra no obtiene beneficios específicos en combate.
    DEFENSIVA(2), // Un tanque en posición defensiva es más difícil de destruir.
    OFENSIVA(3); // Un tanque en posición de atacante tiende a estar más expuesto.

    private final int situacion;

    Situacion(int situacion) {
        this.situacion = situacion;
    }

    public int getSituacion() {
        return situacion;
    }
}
