package Descent.Objetos;

import java.util.ArrayList;

public class Entidad {
    
    public String name;
    public int level;
    public ArrayList<String> inventory;
    public int money;
    public int initiative;
    public int atkMod;
    public int armorClass;
    public int maxHP;
    public int currentHP;
    public int willSave;
    public int reflexSave;
    public int fortSave;

    public Entidad(String name, ArrayList<String> inventory, int level, int money, int initiative, int atkMod,
            int armorClass, int maxHP, int currentHP, int willSave, int reflexSave, int fortSave) {

        this.name = name;
        this.level = level;
        this.inventory = inventory;
        this.money = money;
        this.initiative = initiative;
        this.atkMod = atkMod;
        this.armorClass = armorClass;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.willSave = willSave;
        this.reflexSave = reflexSave;
        this.fortSave = fortSave;

    }
}
