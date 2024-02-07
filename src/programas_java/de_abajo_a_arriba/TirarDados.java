package programas_java.de_abajo_a_arriba;

import java.util.Random;

public class TirarDados {

    private TirarDados() {
        // No necesitamos instancias de TirarDados
    }

    private static int result = 0;
    private static Random random = new Random();
    
    public static int damageRoll(String roll, boolean critical) {

        int diceNumber;
        int modifyer;
        int diceType;

        String[] parts = roll.split("[d+-]");
        diceNumber = Integer.parseInt(parts[0]);
        diceType = Integer.parseInt(parts[1]);

        if (roll.contains("+")) {

            modifyer = Integer.parseInt(parts[2]);

        } else if (roll.contains("-")) {

            modifyer = -Integer.parseInt(parts[2]);

        } else {

            modifyer = 0;

        }

        for (int i = 0; i < diceNumber; i++) {

            result += (random.nextInt(diceType) + 1);

        }

        if (critical) {

            result = (result + modifyer) * 2;

        } else {

            result += modifyer;

        }

        return result;

    }

    public static int attackRoll(String roll) {

        int diceNumber;
        int modifyer;
        int diceType;

        String[] parts = roll.split("[d+-]");
        diceNumber = Integer.parseInt(parts[0]);
        diceType = Integer.parseInt(parts[1]);

        if (roll.contains("+")) {

            modifyer = Integer.parseInt(parts[2]);

        } else if (roll.contains("-")) {

            modifyer = -Integer.parseInt(parts[2]);

        } else {

            modifyer = 0;

        }

        for (int i = 0; i < diceNumber; i++) {

            result += (random.nextInt(diceType) + 1) +  modifyer;

        }

        return result;

    }
}
