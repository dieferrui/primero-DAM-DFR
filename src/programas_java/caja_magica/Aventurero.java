public class Aventurero {
    
    private String nombre;

    public Aventurero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void abrirCaja(CajaMagica caja) {
        Objeto objeto = caja.verContenido();
        if (objeto == null) {
            System.out.println("La caja está vacía.");
            System.out.println();
        } else {
            System.out.println("La caja contiene: ");
            System.out.print(objeto.getNombre());
            System.out.println();
        }
    }

    public void usarCaja(CajaMagica caja, Objeto objeto) {
        caja.ponerQuitar(this, objeto);
    }
}
