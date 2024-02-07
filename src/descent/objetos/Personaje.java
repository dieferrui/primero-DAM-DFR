package descent.objetos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import descent.funcionalidades.*;

public class Personaje extends Entidad {
    
    private String charClass;
    private int strScore; private int strMod;
    private int dexScore; private int dexMod;
    private int conScore; private int conMod;
    private int intScore; private int intMod;
    private int wisScore; private int wisMod;
    private int chaScore; private int chaMod;
    public static final int UNTRAINED = 0;
    public static final int TRAINED = 2;
    public static final int EXPERT = 4;
    public static final int MASTER = 6;
    public static final int LEGENDARY = 8;
    private int acrobaticsSkill;
    private int athleticsSkill;
    private int arcanaSkill;
    private int deceptionSkill;
    private int diplomacySkill;
    private int intimidationSkill;
    private int loreSkill;
    private int medicineSkill;
    private int performanceSkill;
    private int religionSkill;
    private int stealthSkill;
    private int survivalSkill;
    private int thieverySkill;

    public Personaje(String name, ArrayList<String> inventory, int money, int initiative, 
    int level, int atkMod, int maxHP, int currentHP, int armorClass, int willSave, int reflexSave, int fortSave, 
    String charClass) {

        super(name, inventory, level, money, initiative, atkMod,
        armorClass, maxHP, currentHP, willSave, reflexSave, fortSave);
        this.charClass = charClass;
    }

    // Esta función permite al usuario dar nombre al personaje y elegir su clase
    public static Personaje crearPersonaje() {

        Personaje player = new Personaje("", null, 0, 0, 0, 0, 
            1, 1, 0, 0, 0, 0, "");
        String selectedClass;
        String confirm;
        String[] optionsArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        do {
            
            System.out.println("Dime quién eres...");
            String playerName = MenuPrincipal.SC.nextLine();
            player.name = playerName;

            do {
                
                System.out.println("... y qué eres.");
                System.out.println("Selecciona tu clase:\n"
                                    + "1. Guerrero.\n"
                                    + "2. Ladrón.\n"
                                    + "3. Bárbaro.\n"
                                    + "4. Espadachín.\n"
                                    + "5. Mago.\n"
                                    + "6. Clérigo.\n"
                                    + "7. Alquimista.\n"
                                    + "8. Campeón.\n"
                                    + "9. Pistolero.\n"
                                    + "10. Bardo.\n");

                selectedClass = MenuPrincipal.SC.nextLine();

            } while (Arrays.stream(optionsArray).noneMatch(selectedClass::equals));

            System.out.println("Estás seguro de tus elecciones?");
            System.out.println("1. Sí\n2. No\n");
            confirm = MenuPrincipal.SC.nextLine();

        } while (!confirm.equals("1"));

        generarPersonaje(selectedClass, player);

        return player;

    }

    /*
    Esta función genera para cada personaje un set de estadísticas aleatorias
    y equipo inicial dependiendo de la clase
    */

    // TODO Tiene pinta de que a la larga será mejor separar las clases de personaje en sus propios archivos

    protected static Personaje generarPersonaje(String selectedClass, Personaje player) {

        Random randomizer = new Random();

        switch (selectedClass) {
            
            case "1":
                player.charClass = "Guerrero"; // Asignar clase
                player.level = 1;

                // Asignar equipamiento
                player.money = 100;

                // Asignar estadísticas
                player.strScore = randomizer.nextInt((20 - 16) + 1) + 16; player.strMod = estandarizarModificadores(player.strScore);
                player.dexScore = randomizer.nextInt((16 - 12) + 1) + 12; player.dexMod = estandarizarModificadores(player.dexScore);
                player.conScore = randomizer.nextInt((18 - 14) + 1) + 14; player.conMod = estandarizarModificadores(player.conScore);
                player.intScore = randomizer.nextInt((12 - 8) + 1) + 8; player.intMod = estandarizarModificadores(player.intScore);
                player.wisScore = randomizer.nextInt((14 - 8) + 1) + 8; player.wisMod = estandarizarModificadores(player.wisScore);
                player.chaScore = randomizer.nextInt((16 - 8) + 1) + 8; player.chaMod = estandarizarModificadores(player.chaScore);
                player.atkMod = EXPERT + player.strMod;
                player.initiative = TRAINED + player.wisMod;
                player.maxHP = 10 + player.conMod;
                player.currentHP = player.maxHP;
                player.armorClass = 10 + TRAINED + player.conMod + player.dexMod;
                player.willSave = EXPERT + player.wisMod;
                player.reflexSave = TRAINED + player.dexMod;
                player.fortSave = EXPERT + player.conMod;

                // Asignar habilidades
                player.acrobaticsSkill = TRAINED + player.dexMod;
                player.athleticsSkill = EXPERT + player.strMod;
                player.arcanaSkill = UNTRAINED + player.intMod;
                player.deceptionSkill = UNTRAINED + player.chaMod;
                player.diplomacySkill = TRAINED + player.chaMod;
                player.intimidationSkill = TRAINED + player.chaMod;
                player.loreSkill = UNTRAINED + player.intMod;
                player.medicineSkill = TRAINED + player.wisMod;
                player.performanceSkill = UNTRAINED + player.chaMod;
                player.religionSkill = UNTRAINED + player.wisMod;
                player.stealthSkill = UNTRAINED + player.dexMod;
                player.survivalSkill = TRAINED + player.wisMod;
                player.thieverySkill = UNTRAINED + player.dexMod;
                break;

            case "2":
                player.charClass = "Ladrón"; // Asignar clase

                // Asignar equipamiento
                player.money = 100;

                // Asignar estadísticas
                player.strScore = randomizer.nextInt((14 - 8) + 1) + 8; player.strMod = estandarizarModificadores(player.strScore);
                player.dexScore = randomizer.nextInt((20 - 16) + 1) + 16; player.dexMod = estandarizarModificadores(player.dexScore);
                player.conScore = randomizer.nextInt((12 - 10) + 1) + 10; player.conMod = estandarizarModificadores(player.conScore);
                player.intScore = randomizer.nextInt((12 - 8) + 1) + 8; player.intMod = estandarizarModificadores(player.intScore);
                player.wisScore = randomizer.nextInt((16 - 12) + 1) + 12; player.wisMod = estandarizarModificadores(player.wisScore);
                player.chaScore = randomizer.nextInt((14 - 10) + 1) + 10; player.chaMod = estandarizarModificadores(player.chaScore);
                player.atkMod = TRAINED + player.dexMod;
                player.initiative = EXPERT + player.wisMod;
                player.maxHP = 8 + player.conMod;
                player.currentHP = player.maxHP;
                player.armorClass = 10 + TRAINED + player.conMod + player.dexMod;
                player.willSave = TRAINED +  player.wisMod;
                player.reflexSave = EXPERT + player.dexMod;
                player.fortSave = TRAINED + player.conMod;

                // Asignar habilidades
                player.acrobaticsSkill = EXPERT + player.dexMod;
                player.athleticsSkill = TRAINED + player.strMod;
                player.arcanaSkill = UNTRAINED + player.intMod;
                player.deceptionSkill = TRAINED + player.chaMod;
                player.diplomacySkill = TRAINED + player.chaMod;
                player.intimidationSkill = TRAINED + player.chaMod;
                player.loreSkill = UNTRAINED + player.intMod;
                player.medicineSkill = TRAINED + player.wisMod;
                player.performanceSkill = UNTRAINED + player.chaMod;
                player.religionSkill = UNTRAINED + player.wisMod;
                player.stealthSkill = TRAINED + player.dexMod;
                player.survivalSkill = TRAINED + player.wisMod;
                player.thieverySkill = TRAINED + player.dexMod;
                break;

            case "3":
                player.charClass = "Bárbaro"; // Asignar clase

                // Asignar equipamiento
                player.money = 100;

                // Asignar estadísticas
                player.strScore = randomizer.nextInt((20 - 18) + 1) + 18; player.strMod = estandarizarModificadores(player.strScore);
                player.dexScore = randomizer.nextInt((14 - 10) + 1) + 10; player.dexMod = estandarizarModificadores(player.dexScore);
                player.conScore = randomizer.nextInt((18 - 14) + 1) + 14; player.conMod = estandarizarModificadores(player.conScore);
                player.intScore = randomizer.nextInt((10 - 8) + 1) + 8; player.intMod = estandarizarModificadores(player.intScore);
                player.wisScore = randomizer.nextInt((14 - 8) + 1) + 8; player.wisMod = estandarizarModificadores(player.wisScore);
                player.chaScore = randomizer.nextInt((12 - 8) + 1) + 8; player.chaMod = estandarizarModificadores(player.chaScore);
                player.atkMod = TRAINED + player.strMod;
                player.initiative = TRAINED + player.wisMod;
                player.maxHP = 12 + player.conMod;
                player.currentHP = player.maxHP;
                player.armorClass = 10 + TRAINED + player.conMod + player.dexMod;
                player.willSave = TRAINED +  player.wisMod;
                player.reflexSave = TRAINED + player.dexMod;
                player.fortSave = EXPERT + player.conMod;

                // Asignar habilidades
                player.acrobaticsSkill = UNTRAINED + player.dexMod;
                player.athleticsSkill = EXPERT + player.strMod;
                player.arcanaSkill = UNTRAINED + player.intMod;
                player.deceptionSkill = UNTRAINED + player.chaMod;
                player.diplomacySkill = UNTRAINED + player.chaMod;
                player.intimidationSkill = EXPERT + player.chaMod;
                player.loreSkill = UNTRAINED + player.intMod;
                player.medicineSkill = TRAINED + player.wisMod;
                player.performanceSkill = UNTRAINED + player.chaMod;
                player.religionSkill = UNTRAINED + player.wisMod;
                player.stealthSkill = UNTRAINED + player.dexMod;
                player.survivalSkill = TRAINED + player.wisMod;
                player.thieverySkill = UNTRAINED + player.dexMod;
                break;

            case "4":
                player.charClass = "Espadachín"; // Asignar clase

                // Asignar equipamiento
                player.money = 100;

                // Asignar estadísticas
                player.strScore = randomizer.nextInt((14 - 10) + 1) + 10; player.strMod = estandarizarModificadores(player.strScore);
                player.dexScore = randomizer.nextInt((18 - 16) + 1) + 16; player.dexMod = estandarizarModificadores(player.dexScore);
                player.conScore = randomizer.nextInt((14 - 10) + 1) + 10; player.conMod = estandarizarModificadores(player.conScore);
                player.intScore = randomizer.nextInt((12 - 8) + 1) + 8; player.intMod = estandarizarModificadores(player.intScore);
                player.wisScore = randomizer.nextInt((14 - 8) + 1) + 8; player.wisMod = estandarizarModificadores(player.wisScore);
                player.chaScore = randomizer.nextInt((18 - 16) + 1) + 16; player.chaMod = estandarizarModificadores(player.chaScore);
                player.atkMod = TRAINED + player.dexMod;
                player.initiative = EXPERT + player.wisMod;
                player.maxHP = 8 + player.conMod;
                player.currentHP = player.maxHP;
                player.armorClass = 10 + TRAINED + player.conMod + player.dexMod;
                player.willSave = EXPERT +  player.wisMod;
                player.reflexSave = EXPERT + player.dexMod;
                player.fortSave = EXPERT + player.conMod;

                // Asignar habilidades
                player.acrobaticsSkill = TRAINED + player.dexMod;
                player.athleticsSkill = TRAINED + player.strMod;
                player.arcanaSkill = UNTRAINED + player.intMod;
                player.deceptionSkill = EXPERT + player.chaMod;
                player.diplomacySkill = EXPERT + player.chaMod;
                player.intimidationSkill = TRAINED + player.chaMod;
                player.loreSkill = UNTRAINED + player.intMod;
                player.medicineSkill = UNTRAINED + player.wisMod;
                player.performanceSkill = TRAINED + player.chaMod;
                player.religionSkill = UNTRAINED + player.wisMod;
                player.stealthSkill = TRAINED + player.dexMod;
                player.survivalSkill = UNTRAINED + player.wisMod;
                player.thieverySkill = TRAINED + player.dexMod;
                break;

            case "5":
                player.charClass = "Mago"; // Asignar clase
                player.level = 1;

                // Asignar equipamiento
                player.money = 100;

                // Asignar estadísticas
                player.strScore = randomizer.nextInt((12 - 8) + 1) + 8; player.strMod = estandarizarModificadores(player.strScore);
                player.dexScore = randomizer.nextInt((14 - 8) + 1) + 8; player.dexMod = estandarizarModificadores(player.dexScore);
                player.conScore = randomizer.nextInt((12 - 8) + 1) + 8; player.conMod = estandarizarModificadores(player.conScore);
                player.intScore = randomizer.nextInt((20 - 18) + 1) + 18; player.intMod = estandarizarModificadores(player.intScore);
                player.wisScore = randomizer.nextInt((14 - 8) + 1) + 8; player.wisMod = estandarizarModificadores(player.wisScore);
                player.chaScore = randomizer.nextInt((14 - 8) + 1) + 8; player.chaMod = estandarizarModificadores(player.chaScore);
                player.atkMod = TRAINED + player.intMod;
                player.initiative = TRAINED + player.wisMod;
                player.maxHP = 6 + player.conMod;
                player.currentHP = player.maxHP;
                player.armorClass = 10 + UNTRAINED + player.conMod + player.dexMod;
                player.willSave = EXPERT + player.wisMod;
                player.reflexSave = TRAINED + player.dexMod;
                player.fortSave = TRAINED + player.conMod;

                // Asignar habilidades
                player.acrobaticsSkill = UNTRAINED + player.dexMod;
                player.athleticsSkill = UNTRAINED + player.strMod;
                player.arcanaSkill = EXPERT + player.intMod;
                player.deceptionSkill = UNTRAINED + player.chaMod;
                player.diplomacySkill = TRAINED + player.chaMod;
                player.intimidationSkill = UNTRAINED + player.chaMod;
                player.loreSkill = TRAINED + player.intMod;
                player.medicineSkill = TRAINED + player.wisMod;
                player.performanceSkill = UNTRAINED + player.chaMod;
                player.religionSkill = TRAINED + player.wisMod;
                player.stealthSkill = UNTRAINED + player.dexMod;
                player.survivalSkill = UNTRAINED + player.wisMod;
                player.thieverySkill = UNTRAINED + player.dexMod;
                break;

            case "6":
                player.charClass = "Clérigo"; // Asignar clase
                player.level = 1;

                // Asignar equipamiento
                player.money = 100;

                // Asignar estadísticas
                player.strScore = randomizer.nextInt((14 - 8) + 1) + 8; player.strMod = estandarizarModificadores(player.strScore);
                player.dexScore = randomizer.nextInt((14 - 8) + 1) + 8; player.dexMod = estandarizarModificadores(player.dexScore);
                player.conScore = randomizer.nextInt((12 - 10) + 1) + 10; player.conMod = estandarizarModificadores(player.conScore);
                player.intScore = randomizer.nextInt((10 - 8) + 1) + 8; player.intMod = estandarizarModificadores(player.intScore);
                player.wisScore = randomizer.nextInt((20 - 16) + 1) + 16; player.wisMod = estandarizarModificadores(player.wisScore);
                player.chaScore = randomizer.nextInt((12 - 8) + 1) + 8; player.chaMod = estandarizarModificadores(player.chaScore);
                player.atkMod = TRAINED + player.wisMod;
                player.initiative = TRAINED + player.wisMod;
                player.maxHP = 6 + player.conMod;
                player.currentHP = player.maxHP;
                player.armorClass = 10 + TRAINED + player.conMod + player.dexMod;
                player.willSave = EXPERT + player.wisMod;
                player.reflexSave = TRAINED + player.dexMod;
                player.fortSave = TRAINED + player.conMod;

                // Asignar habilidades
                player.acrobaticsSkill = TRAINED + player.dexMod;
                player.athleticsSkill = TRAINED + player.strMod;
                player.arcanaSkill = UNTRAINED + player.intMod;
                player.deceptionSkill = UNTRAINED + player.chaMod;
                player.diplomacySkill = TRAINED + player.chaMod;
                player.intimidationSkill = UNTRAINED + player.chaMod;
                player.loreSkill = UNTRAINED + player.intMod;
                player.medicineSkill = TRAINED + player.wisMod;
                player.performanceSkill = UNTRAINED + player.chaMod;
                player.religionSkill = EXPERT + player.wisMod;
                player.stealthSkill = UNTRAINED + player.dexMod;
                player.survivalSkill = TRAINED + player.wisMod;
                player.thieverySkill = UNTRAINED + player.dexMod;
                break;

            case "7":
                player.charClass = "Alquimista"; // Asignar clase
                player.level = 1;

                // Asignar equipamiento
                player.money = 100;

                // Asignar estadísticas
                player.strScore = randomizer.nextInt((10 - 8) + 1) + 8; player.strMod = estandarizarModificadores(player.strScore);
                player.dexScore = randomizer.nextInt((16 - 10) + 1) + 10; player.dexMod = estandarizarModificadores(player.dexScore);
                player.conScore = randomizer.nextInt((10 - 8) + 1) + 8; player.conMod = estandarizarModificadores(player.conScore);
                player.intScore = randomizer.nextInt((20 - 16) + 1) + 16; player.intMod = estandarizarModificadores(player.intScore);
                player.wisScore = randomizer.nextInt((10 - 8) + 1) + 8; player.wisMod = estandarizarModificadores(player.wisScore);
                player.chaScore = randomizer.nextInt((14 - 10) + 1) + 10; player.chaMod = estandarizarModificadores(player.chaScore);
                player.atkMod = EXPERT + player.wisMod;
                player.initiative = TRAINED + player.wisMod;
                player.maxHP = 8 + player.conMod;
                player.currentHP = player.maxHP;
                player.armorClass = 10 + UNTRAINED + player.conMod + player.dexMod;
                player.willSave = TRAINED + player.wisMod;
                player.reflexSave = TRAINED + player.dexMod;
                player.fortSave = TRAINED + player.conMod;

                // Asignar habilidades
                player.acrobaticsSkill = TRAINED + player.dexMod;
                player.athleticsSkill = TRAINED + player.strMod;
                player.arcanaSkill = TRAINED + player.intMod;
                player.deceptionSkill = UNTRAINED + player.chaMod;
                player.diplomacySkill = UNTRAINED + player.chaMod;
                player.intimidationSkill = UNTRAINED + player.chaMod;
                player.loreSkill = TRAINED + player.intMod;
                player.medicineSkill = TRAINED + player.wisMod;
                player.performanceSkill = UNTRAINED + player.chaMod;
                player.religionSkill = UNTRAINED + player.wisMod;
                player.stealthSkill = TRAINED + player.dexMod;
                player.survivalSkill = TRAINED + player.wisMod;
                player.thieverySkill = UNTRAINED + player.dexMod;
                break;

            case "8":
                player.charClass = "Campeón"; // Asignar clase
                player.level = 1;

                // Asignar equipamiento
                player.money = 100;

                // Asignar estadísticas
                player.strScore = randomizer.nextInt((16 - 14) + 1) + 14; player.strMod = estandarizarModificadores(player.strScore);
                player.dexScore = randomizer.nextInt((10 - 8) + 1) + 8; player.dexMod = estandarizarModificadores(player.dexScore);
                player.conScore = randomizer.nextInt((20 - 16) + 1) + 16; player.conMod = estandarizarModificadores(player.conScore);
                player.intScore = randomizer.nextInt((10 - 8) + 1) + 8; player.intMod = estandarizarModificadores(player.intScore);
                player.wisScore = randomizer.nextInt((16 - 10) + 1) + 10; player.wisMod = estandarizarModificadores(player.wisScore);
                player.chaScore = randomizer.nextInt((14 - 10) + 1) + 10; player.chaMod = estandarizarModificadores(player.chaScore);
                player.atkMod = TRAINED + player.strMod;
                player.initiative = TRAINED + player.wisMod;
                player.maxHP = 10 + TRAINED + player.conMod;
                player.currentHP = player.maxHP;
                player.armorClass = 10 + EXPERT + player.conMod + player.dexMod;
                player.willSave = EXPERT + player.wisMod;
                player.reflexSave = TRAINED + player.dexMod;
                player.fortSave = EXPERT + player.conMod;

                // Asignar habilidades
                player.acrobaticsSkill = UNTRAINED + player.dexMod;
                player.athleticsSkill = TRAINED + player.strMod;
                player.arcanaSkill = UNTRAINED + player.intMod;
                player.deceptionSkill = UNTRAINED + player.chaMod;
                player.diplomacySkill = EXPERT + player.chaMod;
                player.intimidationSkill = TRAINED + player.chaMod;
                player.loreSkill = UNTRAINED + player.intMod;
                player.medicineSkill = TRAINED + player.wisMod;
                player.performanceSkill = UNTRAINED + player.chaMod;
                player.religionSkill = TRAINED + player.wisMod;
                player.stealthSkill = UNTRAINED + player.dexMod;
                player.survivalSkill = UNTRAINED + player.wisMod;
                player.thieverySkill = UNTRAINED + player.dexMod;
                break;

            case "9":
                player.charClass = "Pistolero"; // Asignar clase
                player.level = 1;

                // Asignar equipamiento
                player.money = 100;

                // Asignar estadísticas
                player.strScore = randomizer.nextInt((12 - 10) + 1) + 10; player.strMod = estandarizarModificadores(player.strScore);
                player.dexScore = randomizer.nextInt((20 - 16) + 1) + 16; player.dexMod = estandarizarModificadores(player.dexScore);
                player.conScore = randomizer.nextInt((14 - 10) + 1) + 10; player.conMod = estandarizarModificadores(player.conScore);
                player.intScore = randomizer.nextInt((12 - 8) + 1) + 8; player.intMod = estandarizarModificadores(player.intScore);
                player.wisScore = randomizer.nextInt((12 - 10) + 1) + 8; player.wisMod = estandarizarModificadores(player.wisScore);
                player.chaScore = randomizer.nextInt((16 - 10) + 1) + 10; player.chaMod = estandarizarModificadores(player.chaScore);
                player.atkMod = EXPERT + player.strMod;
                player.initiative = TRAINED + player.wisMod;
                player.maxHP = 10 + player.conMod;
                player.currentHP = player.maxHP;
                player.armorClass = 10 + TRAINED + player.conMod + player.dexMod;
                player.willSave = EXPERT + player.wisMod;
                player.reflexSave = EXPERT + player.dexMod;
                player.fortSave = TRAINED + player.conMod;

                // Asignar habilidades
                player.acrobaticsSkill = EXPERT + player.dexMod;
                player.athleticsSkill = TRAINED + player.strMod;
                player.arcanaSkill = UNTRAINED + player.intMod;
                player.deceptionSkill = TRAINED + player.chaMod;
                player.diplomacySkill = TRAINED + player.chaMod;
                player.intimidationSkill = TRAINED + player.chaMod;
                player.loreSkill = UNTRAINED + player.intMod;
                player.medicineSkill = UNTRAINED + player.wisMod;
                player.performanceSkill = UNTRAINED + player.chaMod;
                player.religionSkill = UNTRAINED + player.wisMod;
                player.stealthSkill = UNTRAINED + player.dexMod;
                player.survivalSkill = UNTRAINED + player.wisMod;
                player.thieverySkill = TRAINED + player.dexMod;
                break;

            case "10":
                player.charClass = "Bardo"; // Asignar clase

                // Asignar equipamiento
                player.money = 100;

                // Asignar estadísticas
                player.strScore = randomizer.nextInt((12 - 8) + 1) + 8; player.strMod = estandarizarModificadores(player.strScore);
                player.dexScore = randomizer.nextInt((14 - 10) + 1) + 10; player.dexMod = estandarizarModificadores(player.dexScore);
                player.conScore = randomizer.nextInt((14 - 10) + 1) + 10; player.conMod = estandarizarModificadores(player.conScore);
                player.intScore = randomizer.nextInt((16 - 8) + 1) + 8; player.intMod = estandarizarModificadores(player.intScore);
                player.wisScore = randomizer.nextInt((12 - 8) + 1) + 8; player.wisMod = estandarizarModificadores(player.wisScore);
                player.chaScore = randomizer.nextInt((20 - 16) + 1) + 16; player.chaMod = estandarizarModificadores(player.chaScore);
                player.atkMod = TRAINED + player.dexMod;
                player.initiative = TRAINED + player.wisMod;
                player.maxHP = 6 + player.conMod;
                player.currentHP = player.maxHP;
                player.armorClass = 10 + TRAINED + player.conMod + player.dexMod;
                player.willSave = EXPERT +  player.wisMod;
                player.reflexSave = TRAINED + player.dexMod;
                player.fortSave = TRAINED + player.conMod;

                // Asignar habilidades
                player.acrobaticsSkill = UNTRAINED + player.dexMod;
                player.athleticsSkill = UNTRAINED + player.strMod;
                player.arcanaSkill = TRAINED + player.intMod;
                player.deceptionSkill = EXPERT + player.chaMod;
                player.diplomacySkill = EXPERT + player.chaMod;
                player.intimidationSkill = EXPERT + player.chaMod;
                player.loreSkill = EXPERT + player.intMod;
                player.medicineSkill = UNTRAINED + player.wisMod;
                player.performanceSkill = EXPERT + player.chaMod;
                player.religionSkill = UNTRAINED + player.wisMod;
                player.stealthSkill = UNTRAINED + player.dexMod;
                player.survivalSkill = UNTRAINED + player.wisMod;
                player.thieverySkill = TRAINED + player.dexMod;
                break;

        }

        return player;
    }

    private static int estandarizarModificadores(int mod) {

        switch (mod) {

            case 1: return -5;
            case 2, 3: return -4;
            case 4, 5: return -3;
            case 6, 7: return -2;
            case 8, 9: return -1;
            case 12, 13: return 1;
            case 14, 15: return 2;
            case 16, 17: return 3;
            case 18, 19: return 4;
            case 20, 21: return 5;
            case 22, 23: return 6;
            case 24, 25: return 7;
            default: return 0;

        }
    }

    @Override
    public String toString() {
        return "Personaje [charClass=" + charClass + ", strScore=" + strScore + ", dexScore=" + dexScore + ", conScore="
                + conScore + ", intScore=" + intScore + ", wisScore=" + wisScore + ", chaScore=" + chaScore
                + ", acrobaticsSkill=" + acrobaticsSkill + ", athleticsSkill=" + athleticsSkill + ", arcanaSkill="
                + arcanaSkill + ", deceptionSkill=" + deceptionSkill + ", diplomacySkill=" + diplomacySkill
                + ", intimidationSkill=" + intimidationSkill + ", loreSkill=" + loreSkill + ", medicineSkill="
                + medicineSkill + ", performanceSkill=" + performanceSkill + ", religionSkill=" + religionSkill
                + ", stealthSkill=" + stealthSkill + ", survivalSkill=" + survivalSkill + ", thieverySkill="
                + thieverySkill + "]";
    
    }

    // Getters y setters
    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public int getStrScore() {
        return strScore;
    }

    public void setStrScore(int strScore) {
        this.strScore = strScore;
    }

    public int getStrMod() {
        return strMod;
    }

    public void setStrMod(int strMod) {
        this.strMod = strMod;
    }

    public int getDexScore() {
        return dexScore;
    }

    public void setDexScore(int dexScore) {
        this.dexScore = dexScore;
    }

    public int getDexMod() {
        return dexMod;
    }

    public void setDexMod(int dexMod) {
        this.dexMod = dexMod;
    }

    public int getConScore() {
        return conScore;
    }

    public void setConScore(int conScore) {
        this.conScore = conScore;
    }

    public int getConMod() {
        return conMod;
    }

    public void setConMod(int conMod) {
        this.conMod = conMod;
    }

    public int getIntScore() {
        return intScore;
    }

    public void setIntScore(int intScore) {
        this.intScore = intScore;
    }

    public int getIntMod() {
        return intMod;
    }

    public void setIntMod(int intMod) {
        this.intMod = intMod;
    }

    public int getWisScore() {
        return wisScore;
    }

    public void setWisScore(int wisScore) {
        this.wisScore = wisScore;
    }

    public int getWisMod() {
        return wisMod;
    }

    public void setWisMod(int wisMod) {
        this.wisMod = wisMod;
    }

    public int getChaScore() {
        return chaScore;
    }

    public void setChaScore(int chaScore) {
        this.chaScore = chaScore;
    }

    public int getChaMod() {
        return chaMod;
    }

    public void setChaMod(int chaMod) {
        this.chaMod = chaMod;
    }

    public static int getUntrained() {
        return UNTRAINED;
    }

    public static int getTrained() {
        return TRAINED;
    }

    public static int getExpert() {
        return EXPERT;
    }

    public static int getMaster() {
        return MASTER;
    }

    public static int getLegendary() {
        return LEGENDARY;
    }

    public int getAcrobaticsSkill() {
        return acrobaticsSkill;
    }

    public void setAcrobaticsSkill(int acrobaticsSkill) {
        this.acrobaticsSkill = acrobaticsSkill;
    }

    public int getAthleticsSkill() {
        return athleticsSkill;
    }

    public void setAthleticsSkill(int athleticsSkill) {
        this.athleticsSkill = athleticsSkill;
    }

    public int getArcanaSkill() {
        return arcanaSkill;
    }

    public void setArcanaSkill(int arcanaSkill) {
        this.arcanaSkill = arcanaSkill;
    }

    public int getDeceptionSkill() {
        return deceptionSkill;
    }

    public void setDeceptionSkill(int deceptionSkill) {
        this.deceptionSkill = deceptionSkill;
    }

    public int getDiplomacySkill() {
        return diplomacySkill;
    }

    public void setDiplomacySkill(int diplomacySkill) {
        this.diplomacySkill = diplomacySkill;
    }

    public int getIntimidationSkill() {
        return intimidationSkill;
    }

    public void setIntimidationSkill(int intimidationSkill) {
        this.intimidationSkill = intimidationSkill;
    }

    public int getLoreSkill() {
        return loreSkill;
    }

    public void setLoreSkill(int loreSkill) {
        this.loreSkill = loreSkill;
    }

    public int getMedicineSkill() {
        return medicineSkill;
    }

    public void setMedicineSkill(int medicineSkill) {
        this.medicineSkill = medicineSkill;
    }

    public int getPerformanceSkill() {
        return performanceSkill;
    }

    public void setPerformanceSkill(int performanceSkill) {
        this.performanceSkill = performanceSkill;
    }

    public int getReligionSkill() {
        return religionSkill;
    }

    public void setReligionSkill(int religionSkill) {
        this.religionSkill = religionSkill;
    }

    public int getStealthSkill() {
        return stealthSkill;
    }

    public void setStealthSkill(int stealthSkill) {
        this.stealthSkill = stealthSkill;
    }

    public int getSurvivalSkill() {
        return survivalSkill;
    }

    public void setSurvivalSkill(int survivalSkill) {
        this.survivalSkill = survivalSkill;
    }

    public int getThieverySkill() {
        return thieverySkill;
    }

    public void setThieverySkill(int thieverySkill) {
        this.thieverySkill = thieverySkill;
    }
    
}
