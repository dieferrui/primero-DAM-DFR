public class App {

    public static void main(String[] args) {
        
        NivelJuego nivel = NivelJuego.AVANZADO;
        NivelJuego nivel2 = NivelJuego.PRINCIPIANTE;

        System.out.println(nivel.esAvanzado());
        System.out.println(nivel2.esAvanzado());


        EstadoJuego estado = EstadoJuego.TERMINADO;
        EstadoJuego estado2 = EstadoJuego.EN_PROGRESO;
        EstadoJuego estado3 = EstadoJuego.PAUSADO;

        System.out.println(estado.mostrarEstado());
        System.out.println(estado2.mostrarEstado());
        System.out.println(estado3.mostrarEstado());

        ValorCartas as = ValorCartas.AS;
        ValorCartas tres = ValorCartas.TRES;
        ValorCartas jester = ValorCartas.J;
        ValorCartas rey = ValorCartas.K;

        System.out.println(as.obtenerPuntos());
        System.out.println(tres.obtenerPuntos());
        System.out.println(jester.obtenerPuntos());
        System.out.println(rey.obtenerPuntos());
        
    }
}
