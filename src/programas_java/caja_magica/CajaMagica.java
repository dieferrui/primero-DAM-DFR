public class CajaMagica {
    
    private Objeto objeto;

    public Objeto verContenido() {
        if (this.objeto == null) {
            return objeto;
        } else {
            return objeto;
        }
    }

    public void ponerQuitar(Aventurero aventurero, Objeto objeto) {
        if (this.objeto == null && objeto == null) {
            System.out.println("La caja está vacía, pero " + aventurero.getNombre() + " no tiene nada en la mano.");
        } else if (this.objeto == null && objeto != null) {
            System.out.println("La caja está vacía. " + aventurero.getNombre() + " pone " + objeto.getNombre() + " en la caja.");
            this.objeto = objeto;
        } else if (this.objeto != null && objeto == null) {
            System.out.println("Hay un/una " + this.objeto.getNombre() + " en la caja. Cuando " + aventurero.getNombre() + " retira el objeto de la caja, éste se pierde para siempre.");
            this.objeto = null;
        } else {
            System.out.println("Hay un/una " + this.objeto.getNombre() + " en la caja. " + aventurero.getNombre() + " pone " + objeto.getNombre() + " en la caja. El primer objeto desaparece.");
            this.objeto = objeto;
        }
        System.out.println();
    }
}
