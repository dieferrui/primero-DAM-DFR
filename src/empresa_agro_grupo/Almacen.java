import java.util.ArrayList;

import java.util.Collections;

public class Almacen {

    private int espacio = 1000;
    private int espacioOcupado;
    private ArrayList<PAlmacenado> productosAlmacenados = new ArrayList<>();

    public Almacen() {
        // Constructor vacío
    }

    public void almacenarProducto(Producto productoNuevo, int stock, double precio) {

        int cantPosible;
        PAlmacenado productoEntrante = new PAlmacenado(productoNuevo, stock, precio);

        cantPosible = comprobarEspacio(productoEntrante);

        productoEntrante.setStock(cantPosible);

        if (cantPosible <= 0) {

            System.out.println("No se han añadido productos al almacén.");
        
        } else {
            
            System.out.println("Se han añadido " + cantPosible + "kg del producto " +
                productoNuevo.getNumeroLote() + " al almacén.");

            productosAlmacenados.add(productoEntrante);
            espacioOcupado += productoEntrante.getStock();
        
        }

        this.ordenarProductos();

    }

    private int comprobarEspacio(PAlmacenado productoEntrante) {

        int espacioDisponible = espacio - espacioOcupado;

        if (productoEntrante.getStock() > espacioDisponible) {

            System.out.println("No hay espacio disponible para " + productoEntrante.toString() +
                "\n Sólo se almacenarán " + espacioDisponible + " kg.");
            return espacioDisponible;

        } else {

            return productoEntrante.getStock();

        }
    }

    private void ordenarProductos() {

        Collections.sort(productosAlmacenados, (almacenado1, almacenado2) -> 
        almacenado1.getProducto().getFechaCad().compareTo(almacenado2.getProducto().getFechaCad()));

    }

    public void mostrarProductos() {

        StringBuilder sb = new StringBuilder();
        int cuenta = 1;

        sb.append("Estado del almacén: " + espacioOcupado + "/" + espacio + "kg disponibles.\n");

        for (PAlmacenado productoActual : productosAlmacenados) {

            sb.delete(0, sb.length());
            sb.append("-----------------------\n");
            sb.append(cuenta + ". ");
            sb.append(productoActual.toString());

            System.out.println(sb.toString());
            cuenta++;
        }

        System.out.println();
    }

    public void extraerProducto(String productoID, int cantProducto) {

        int cantARestar = cantProducto;
        int[] casos = new int[2];

        for (PAlmacenado producto: productosAlmacenados) {

            if (productoID.equals(producto.getProducto().getNumeroLote())) {

                casos = restarProducto(producto, cantARestar);

            }

            if (casos[0] == 0) {

                cantARestar = casos[1];
                continue;

            } else {

                break;

            }
        }
    }

    private int[] restarProducto(PAlmacenado producto, int cant) {

        int res = 0;
        int[] casoValor = new int[2];
        int resto = 0;

        if (cant > producto.getStock()) {

            System.out.println("Se extraerá todo (" + producto.getStock() + ") el stock del producto " + 
            producto.getProducto().getNumeroLote() + " a " + producto.getPrecio() + " euros/kg.");

            espacioOcupado -= producto.getStock();
            productosAlmacenados.remove(producto);

            resto = cant - producto.getStock();
            res = 0;

        } else if (cant == producto.getStock()) {

            System.out.println("Se extraerá todo (" + producto.getStock() + ") el stock del producto " + 
            producto.getProducto().getNumeroLote() + " a " + producto.getPrecio() + " euros/kg.");

            espacioOcupado -= cant;
            productosAlmacenados.remove(producto);

            res = 1;

        } else {

            System.out.println("Se extraerán " + cant + "kg del producto " + 
            producto.getProducto().getNumeroLote() + " a " + producto.getPrecio() + " euros/kg.");

            espacioOcupado -= cant;
            producto.setStock(producto.getStock() - cant);

            res = 2;

        }

        casoValor[0] = res;
        casoValor[1] = resto;

        return casoValor;
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
}

