package programas_java.de_abajo_a_arriba;

public class Enemigo {
    
    private String nombre;
    private String danio;
    private int xp;
    private int hitPoints;
    private int currentHP;
    private int atkMod;
    private int armorClass;

    public Enemigo(String nombre) {

        this.nombre = nombre;
        getStats(nombre);

    }

    public void getStats(String enemigo) {

        switch (enemigo) {

            case "Esqueleto":
                setDanio("1d4");
                setXP(5);
                setHP(6);
                setCurrentHP(getHP());
                setAtkMod(+6);
                setArmorClass(16);
                break;

            case "Goblin":
                setDanio("1d6");
                setXP(15);
                setHP(14);
                setCurrentHP(getHP());
                setAtkMod(+6);
                setArmorClass(14);
                break;

            case "Orco":
                setDanio("2d8");
                setXP(30);
                setHP(40);
                setCurrentHP(getHP());
                setAtkMod(+8);
                setArmorClass(18);
                break;

            case "Gigante":
                setDanio("2d12");
                setXP(60);
                setHP(60);
                setCurrentHP(getHP());
                setAtkMod(+10);
                setArmorClass(20);
                break;

            case "Dragón":
                setDanio("4d10");
                setXP(80);
                setHP(110);
                setCurrentHP(getHP());
                setAtkMod(+12);
                setArmorClass(22);
                break;
            
            default:
                break;
        }
    }

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

    public int getXP() {
        return xp;
    }

    public void setXP(int xp) {
        this.xp = xp;
    }

    public int getHP() {
        return hitPoints;
    }

    public void setHP(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getAtkMod() {
        return atkMod;
    }

    public void setAtkMod(int atkMod) {
        this.atkMod = atkMod;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    
}
