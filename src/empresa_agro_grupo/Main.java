import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Almacen almacen = new Almacen();

        PFresco fresas = new PFresco(LocalDate.of(2024, 6, 2), "fr001", LocalDate.of(2023, 12, 10), "ES");
        PRefrigerado pastelDeQueso = new PRefrigerado(LocalDate.of(2024, 8, 12), "pa002", "OM033-A");
        PCongelado heladoTrufa = new PCongelado(LocalDate.of(2024, 12, 9), "hl003", -6d);

        almacen.almacenarProducto(fresas, 250, 1d);

        almacen.mostrarProductos();

        almacen.almacenarProducto(pastelDeQueso, 100, 14d);

        almacen.mostrarProductos();

        almacen.almacenarProducto(heladoTrufa, 200, 8.5);

        almacen.mostrarProductos();

        almacen.almacenarProducto(fresas, 700, 2d);

        almacen.mostrarProductos();

        almacen.extraerProducto("pa002", 80);

        almacen.extraerProducto("fr001", 400);

        almacen.mostrarProductos();

    }
}