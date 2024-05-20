package diego.enums_general;

public enum Deteccion {

    NORMAL(1), // En un enfrentamiento normal, los oponentes se detectan entre ellos antes de que comience el combate.
    SORPRESA(2), // En un enfrentamiento sorpresa, los oponentes se detectan entre ellos en el momento en el que el combate es inevitable.
    EMBOSCADA(3); // En una emboscada, uno de los oponentes detecta al otro antes de que el combate empiece.

    private final int tipo;

    Deteccion(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
}
