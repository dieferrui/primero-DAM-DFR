package descent.objetos;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Enemigo extends Entidad{
    
    private String description;
    private String weakness;
    private String resistance;
    private String immunity;
    private String[] relatedBiomes;

    // Un constructor genérico de enemigos
    public Enemigo(String name, ArrayList<String> inventory, int money, int initiative, int level, int atkMod, 
        int maxHP, int currentHP, int armorClass, int willSave, int reflexSave, int fortSave, String description, 
        String weakness, String resistance, String immunity) {

        super(name, inventory, money, initiative, level, atkMod, maxHP, currentHP, armorClass, willSave, reflexSave, fortSave);
        this.description = description;
        this.weakness = weakness;
        this.resistance = resistance;
        this.immunity = immunity;

    }

    // La siguiente función instancia enemigos a partir de nombres de archivos de texto
    public static Enemigo generarEnemigo(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String name = "";
            String description = "";
            String weakness = "";
            String resistance = "";
            String immunity = "";
            ArrayList<String> inventory = new ArrayList<String>();
            int money = 0;
            int initiative = 0;
            int level = 0;
            int atkMod = 0;
            int maxHP = 0;
            int currentHP = 0;
            int armorClass = 0;
            int willSave = 0;
            int reflexSave = 0;
            int fortSave = 0;
            
            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split("=");

                if (parts.length == 2) {

                    String property = parts[0].trim();
                    String value = parts[1].trim();

                    switch (property) {

                        case "name": name = value; break;
                        case "description": description = value; break;
                        case "weakness": weakness = value; break;
                        case "resistance": resistance = value; break;
                        case "immunity": immunity = value; break;
                        case "inventory":

                            String[] items = value.split(",");

                            for (String item : items) {

                                inventory.add(item.trim());

                            }

                            break;
                        
                        case "money": money = Integer.parseInt(value); break;
                        case "initiative": initiative = Integer.parseInt(value); break;
                        case "level": level = Integer.parseInt(value); break;
                        case "atkMod": atkMod = Integer.parseInt(value); break;
                        case "maxHP": maxHP = Integer.parseInt(value); currentHP = maxHP; break;
                        case "armorClass": armorClass = Integer.parseInt(value); break;
                        case "willSave": willSave = Integer.parseInt(value); break;
                        case "reflexSave": reflexSave = Integer.parseInt(value); break;
                        case "fortSave": fortSave = Integer.parseInt(value); break;

                    }
                }
            }

            return new Enemigo(name, inventory, money, initiative, level, atkMod, maxHP, currentHP, armorClass, willSave, reflexSave, 
                                fortSave, description, weakness, resistance, immunity);
        
        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }
    }
}
