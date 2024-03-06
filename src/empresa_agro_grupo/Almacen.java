import java.util.ArrayList;

public class Almacen {

    private int espacio = 1000;
    private int espacioOcupado;
    private ArrayList<PAlmacenado> productosAlmacendos = new ArrayList<>();

    public Almacen() {
        // Constructor vacío
    }

    public int getEspacio() {
        return espacio;
    }

    public int getEspacioOcupado() {
        return espacioOcupado;
    }

    public void setEspacioOcupado(int espacioOcupado) {
        this.espacioOcupado = espacioOcupado;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    public void compararProd(PAlmacenado productoNuevo) {

        int espacioDisponible = espacio - espacioOcupado;

        if (productoNuevo.getStock() > espacioDisponible) {

            System.out.println("No hay espacio disponible para " + productoNuevo.getDescripcion());
            return;

        }

        for (PAlmacenado productoActual : productosAlmacendos) {

            if (productoNuevo.getNumeroLote().equals(productoActual.getProducto().getNumeroLote()) &&
                    productoNuevo.getFechaCad().equals(productoActual.getProducto().getFechaCad())) {
                
                productoActual.aumentarStock(productoNuevo.getProducto());
                ajustarEspacio();
                return;

            }
        }

        productosAlmacendos.add(productoNuevo);
        ajustarEspacio();
    }



    public void mostrarProductos() {

        StringBuilder sb = new StringBuilder();

        for (PAlmacenado productoActual : productosAlmacendos) {

            sb.append("-----------------------\n");
            sb.append("Descripción: ");
            sb.append(productoActual.getDescripcion()).append("\n");
            sb.append("Tipo: ");
            sb.append(productoActual.getTipo()).append("\n");
            sb.append("Stock: ");
            sb.append(productoActual.getStock()).append("\n");
            sb.append(productoActual.getProducto().mostrarDatos()).append("\n");

            System.out.println(sb.toString());
        }
    }

    private void ajustarEspacio() {

        this.espacioOcupado = 0;

        for (PAlmacenado productoActual : productosAlmacendos) {

            this.espacioOcupado += productoActual.getStock();

        }
    }


    public void mostrarEspacio() {

        StringBuilder sb = new StringBuilder();
        
        sb.append("Espacio disponible: ");
        sb.append(espacio).append("\n");
        sb.append("Espacio ocupado: ");
        sb.append(espacioOcupado).append("\n");
        sb.append("Espacio ocupado: ");

        System.out.println(sb.toString());
    }
}

