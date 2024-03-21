package hangman;

import java.util.Random;

public class Palabra {
    
    private static Random random = new Random();
    private boolean isSolved = false;
    private String palabraValor;

    public Palabra(String tipo) {

        this.palabraValor = getPalabra(tipo);

    }

    public static String getPalabra(String tipo) {

        int select;

        String[] grupos = {"AVENGED SEVENFOLD", "ONLAP", "ALESANA", "ASSUMING WE SURVIVE",
                            "BRING ME THE HORIZON", "NEWHAVEN", "ADEPT", "ATTACK ATTACK",
                            "DANGERKIDS", "DRAGONFORCE", "GREEN DAY", "IRON MAIDEN",
                            "JORN", "LINKIN PARK", "THE OFFSPRING", "ONE MORNING LEFT",
                            "OUR LAST NIGHT", "THE PAPER MELODY", "RAIZER", "SABATON",
                            "STARSET", "SYSTEM OF A DOWN", "THREE DAYS GRACE"};

        String[] videojuegos = {"ELDEN RING", "DARK SOULS", "SEKIRO", "ARMORED CORE",
                            "KINGDOM HEARTS", "STARDEW VALLEY", "TERRARIA", "BALDURS GATE",
                            "VALORANT", "LEAGUE OF LEGENDS", "DIABLO", "WORLD OF WARCRAFT",
                            "THE LEGEND OF ZELDA", "SUPER MARIO ODYSSEY", "BATTLEFIELD",
                            "CALL OF DUTY", "CULT OF THE LAMB", "EN GARDE", "WAR THUNDER",
                            "PROJECT COLD WAR", "TRAILMAKERS", "TRACKMANIA", "NEED FOR SPEED"};

        String[] animes = {"SWORD ART ONLINE", "JUJUTSU KAISEN", "ONE PUNCH MAN", "DRAGON BALL",
                            "NARUTO", "ONE PIECE", "GIRLS UND PANZER", "SOLO LEVELING",
                            "OVERLORD", "VIOLET EVERGARDEN", "KILL LA KILL", "AKAME GA KILL",
                            "MASHLE", "DEATH NOTE", "TOKYO GHOUL", "MOB PSYCHO",
                            "HIGH SCHOOL DXD", "ELFEN LIED", "RE ZERO", "SERIAL EXPERIMENTS LAIN"};

        String[] tanques = {"PANTHER", "TIGER", "JAGDPANTHER", "JAGDTIGER", "PANZERJAGER",
                            "LEOPARD", "MAUS", "WIRBELWIND", "OSTWIND", "WIESEL", "DICKER MAX",
                            "STURER EMIL", "MARDER", "KUGELBLITZ", "M4 SHERMAN", "M3 LEE",
                            "M1 ABRAMS", "M5 STUART", "HELLCAT", "M10 WOLVERINE", "LECLERC",
                            "SHERMAN FIREFLY", "TOG", "AVENGER", "CROMWELL", "CRUISER", "COMET",
                            "CAERNARVON", "CONQUEROR", "CRUSADER", "TETRARCH", "MATILDA", "CHURCHILL",
                            "FCM 36", "RENAULT R35", "AMX ELC BIS", "B1 BIS", "SOMUA SAU 40",
                            "LORRAINE 155", "CHAR 25T", "LORRAINE 40T", "AUTOBLINDA",
                            "SEMOVENTE", "BREDA", "FRECCIA", "CENTAURO", "ARIETE", "OTOMATIC",
                            "HA GO", "RO GO", "CHI HA LG", "CHI NU", "CHI RI", "HO RI"};

        switch (tipo) {

            case "Grupo": select = random.nextInt(grupos.length); return grupos[select];
            case "Juego": select = random.nextInt(videojuegos.length); return videojuegos[select];
            case "Anime": select = random.nextInt(animes.length); return animes[select];
            case "Tanque": select = random.nextInt(tanques.length); return tanques[select];
            default: select = random.nextInt(tanques.length); return tanques[select];

        }
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

    public String getPalabra() {
        return palabraValor;
    }

    public void setPalabra(String palabraValor) {
        this.palabraValor = palabraValor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (isSolved ? 1231 : 1237);
        result = prime * result + ((palabraValor == null) ? 0 : palabraValor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Palabra other = (Palabra) obj;
        if (isSolved != other.isSolved)
            return false;
        if (palabraValor == null) {
            if (other.palabraValor != null)
                return false;
        } else if (!palabraValor.equals(other.palabraValor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return palabraValor;
    }

}
