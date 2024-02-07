package descent.funcionalidades;

public class Juego {

    private Juego() {
        // No necesitamos instancias de Juego
    }

    public static void startGame() {
        
        System.out.println("Los rumores dicen que en el borde Este del imperio,\n"
                            + "cerca de la frontera, existe una mazmorra afectada\n"
                            + "por extraña magia de transposición. Muchos son los que\n"
                            + "han tratado de descubrir cuál es la útlima sala de la\n"
                            + "mazmorra, pero nadie lo ha logrado jamás. Sin embargo,\n"
                            + "aquí estás, dispuesto a hacer historia, o como mínimo a\n"
                            + "reunir una pequeña fortuna saqueando sus cambiantes salas.\n"
                            + "\nEsto es Descendents.");

        Jugador player = Generador.generateCharacter();
    }
    
}
