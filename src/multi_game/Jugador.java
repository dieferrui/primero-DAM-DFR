package multi_game;

public class Jugador {
    
    private String nombre;
    private int respuesta;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.respuesta = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
}