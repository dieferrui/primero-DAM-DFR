package empresa_agro;

import java.util.ArrayList;
import java.util.Scanner;

public class Almacen {

    private Scanner sca = new Scanner(System.in);
    private int cantidadDeStock = 0;
    private ArrayList<Producto> productosAlmacenados = new ArrayList<>();
    
    public void almacenarProducto(Producto producto) {

        if (cantidadDeStock >= 1000) {

            System.out.println("No es posible almacenar más stock: almacén lleno.");

        } else {

            int numKilos;
            int precioKilos;

            producto.setAlmacenado(true);

            do {
                
                System.out.println("Indique la cantidad de stock en kilos (Sólo números enteros): ");
                numKilos = sca.nextInt();

                if (numKilos <= 0) {

                    System.out.println("Error: no es posible introducir esa cantidad.");
                
                } else {

                    producto.setStockEnKilos(numKilos);

                }

            } while (numKilos <= 0);

            do {

                System.out.println("Indique el precio por kilo del producto (Sólo números enteros): ");
                precioKilos = sca.nextInt();

                if (precioKilos <= 0) {
                    
                    System.out.println("Error: no es posible introducir esa cantidad.");
                
                } else {

                    producto.setPrecioPorKilo(precioKilos);

                }
            
            } while (precioKilos <= 0);

            System.out.flush();
            cantidadDeStock++;
            productosAlmacenados.add(producto);
            productosAlmacenados.sort(null);

        }
        
    }

    public void verProductosEnStock() {

        System.out.println("El número de productos en stock es de " + cantidadDeStock + ".");
        int i = 0;

        for (Producto producto : productosAlmacenados) {

            i++;
            System.out.println(i + ". " + producto.toString());

        }
    }

    public int extraerProducto() {

        System.out.println("Indique qué cantidad de stock quiere extraer del\n"
                            + "producto en stock con fecha de caducidad más próxima: ");
        int cantidadProducto = sca.nextInt();

        Producto productoAfectado = productosAlmacenados.get(0);
        int stockDisponible = productoAfectado.getStockEnKilos();

        productoAfectado.setStockEnKilos(stockDisponible - cantidadProducto);

        if (productoAfectado.getStockEnKilos() <= 0) {

            System.out.println("Se ha agotado el stock del producto.");
            productosAlmacenados.remove(0);
            cantidadDeStock--;
            
        } else {

            System.out.println("Quedan " + productoAfectado.getStockEnKilos() + "Kg de este producto.");
        }

        productosAlmacenados.sort(null);
        return Math.min(cantidadProducto, stockDisponible);
    
    }
}
