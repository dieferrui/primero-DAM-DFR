package descent.objetos;

import java.util.ArrayList;
import java.util.Random;
import descent.funcionalidades.*;

import java.io.IOException;

public class Nivel {
    
    String prompt;
    protected String biome;
    protected String description;
    protected int depth;
    protected Boolean availableExit;
    protected ArrayList<Enemigo> hostiles;
    public static String[] biomes = {"Subsuelo", "Caverna", "Mazmorra", "Hielo", "Osario", "Piramide", "Celeste", "Infernal"};

    public Nivel(String biome, String description, int depth) {

        this.biome = biome;
        this.description = description;
        this.depth = depth;

    }

    public static Nivel generarNivel(int depth, int playerLv) {

        String biomeZero = null;
        String descFloorZero = "Las puertas de la mazmorra se abren con un ominoso retumbar,\n"
                        + "invitándote al interior. El recibidor, si es que se puede llamar\n"
                        + "así, consiste en una amplia sala con paredes de piedra cubiertas\n"
                        + "de brillante musgo, que prospera gracias a la tranquila fuente\n"
                        + "que gorgotea plácidamente en el centro de la estancia. ¿Qué\n"
                        + "quieres hacer?";
        int depthZero = 0;

        Nivel level = new Nivel(biomeZero, descFloorZero, depthZero);

        level.hostiles = null;
        level.availableExit = Boolean.FALSE;

        return level;

    }

    public static Nivel generarNivel(int depth, int playerLv, Nivel previousLv) throws Exception {

        String biome = seleccionarBioma(previousLv.biome);
        String description = "";

        try {
            
            description = generarDescripcion(biome);
        
        } catch (IOException io) {

            System.out.println("Se ha producido una excepción Entrada/Salida.");

        }

        Nivel newLevel = new Nivel(biome, description, depth);

        // newLevel.hostiles = generarEnemigos(biome, playerLv);

        return newLevel;

    }

    public static String seleccionarBioma(String previousBiome) {

        Random random = new Random();
        String newBiome;

        if (previousBiome == null || random.nextDouble() >= 0.95) {

            newBiome = biomes[random.nextInt(biomes.length)];

        } else {

            newBiome = previousBiome;

        }

        return newBiome;

    }

    /*
    public static ArrayList<Enemigo> generarEnemigos(String biome, int playerLv) {

        
    }
    */

    public static String generarDescripcion(String biome) throws Exception {

        String biomeDesc;

        switch (biome) {

            case "Subsuelo": biomeDesc = "cueva de tierra cerca de la superficie"; break;
            case "Caverna": biomeDesc = "caverna excavada profundamente en la roca"; break;
            case "Mazmorra": biomeDesc = "mazmorra clásica"; break;
            case "Hielo": biomeDesc = "gruta helada, o una mazmorra enterrada en la nieve"; break;
            case "Osario": biomeDesc = "osario, cementerio, o lugar de reposo para los muertos similar"; break;
            case "Piramide": biomeDesc = "pirámide o templo ambientado en el antiguo oriente"; break;
            case "Celeste": biomeDesc = "lugar celestial o sagrado, probablemente bendito"; break;
            case "Infernal": biomeDesc = "caverna de lava, templo profano, o lugar relacionado con el infierno"; break;
            default: biomeDesc = "default"; break;

        }

        String universalPrompt = "Usando sólamente dos o tres frases, descríbeme un \"piso\" de una mazmorra ambientada en un setting de "
                                + "fantasía medieval. El \"piso\" está ubicado en un/una " + biomeDesc + ". Adicionalmente, añade algunos "
                                + "detalles relacionados con sólo uno de los siguientes \"subtemas\": agua, abismo, plantas, hongos, "
                                + "huesos, rastros, huellas, fuego, ruinas, magia, runas, cultos, ruido, olor. Debes tener en cuenta que "
                                + "la descripción y los detalles que proveas no deben llamar la atención sobre sí mismos, sino sólamente "
                                + "dar a quien lea el texto una sensación de misterio/peligro.";

        return PromptsOpenAI.solicitarPrompt(MenuPrincipal.apiKey, universalPrompt);

    }

    public String getDescription() {

        return description;

    }
}
