package programas_java.de_abajo_a_arriba;

public class Arma {
    
    protected String nombre;
    protected String danio;
    protected int nivel;
    protected int atkMod;

    public Arma(String nombre, String danio, int nivel, int atkMod) {

        this.nombre = nombre;
        this.danio = danio;
        this.nivel = nivel;
        this.atkMod = atkMod;

    }

    static Arma longsword = new Arma("Espada larga", "1d8", 0, +0);
    static Arma mace = new Arma("Maza", "1d6", 0, +0);
    static Arma magicks = new Arma("Libro de hechizos", "1d12", 0, +0);
    static Arma spata = new Arma("Espadón", "3d6", 1, +1);
    static Arma dmnTrr = new Arma("Gran Filo del Rey Demonio Carmesí", "8d10+25", 19, +3);
    static Arma thrNglr = new Arma("Throngler", "12d12+50", 22, +4);

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDanio() {
        return danio;
    }
    public void setDanio(String danio) {
        this.danio = danio;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getAtkMod() {
        return atkMod;
    }
    public void setAtkMod(int atkMod) {
        this.atkMod = atkMod;
    }

}
