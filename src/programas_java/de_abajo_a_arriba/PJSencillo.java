package de_abajo_a_arriba;

public class PJSencillo {
    
    private String nombre;
    private Arma arma;
    private int nivel;
    private int hitPoints;
    private int currentHP;
    private int atkMod;
    private int armorClass;

    public PJSencillo(String nombre) {

        this.nombre = nombre;

    }

    public static void eleccionPJ(String clase, PJSencillo player) {

        player.setNivel(1);

        switch (clase) {
            case "Fighter": makeFighter(player); break;
            case "Wizard": makeWizard(player); break;
            case "Champion": makeChampion(player); break;
            default: makeFighter(player); break;
        }

    }

    public static void makeFighter(PJSencillo player) {

        player.setArma(Arma.longsword);
        player.setHP(50);
        player.setCurrentHP(player.getHP());
        player.setAtkMod(+6 + player.arma.atkMod);
        player.setArmorClass(17);

    }

    public static void makeWizard(PJSencillo player) {

        player.setArma(Arma.magicks);
        player.setHP(20);
        player.setCurrentHP(player.getHP());
        player.setAtkMod(+10 + player.arma.atkMod);
        player.setArmorClass(14);

    }

    public static void makeChampion(PJSencillo player) {

        player.setArma(Arma.mace);
        player.setHP(100);
        player.setCurrentHP(player.getHP());
        player.setAtkMod(+2 + player.arma.atkMod);
        player.setArmorClass(21);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
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
