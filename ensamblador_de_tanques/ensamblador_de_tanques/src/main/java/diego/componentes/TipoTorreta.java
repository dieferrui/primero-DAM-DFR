package diego.componentes;

public enum TipoTorreta {
    
    TORRETA("Torreta"), 
    SUPERESTRUCTURA("Superestructura");

    private final String tipo;

    TipoTorreta(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
