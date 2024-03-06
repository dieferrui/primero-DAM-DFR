import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Almacen almacen = new Almacen();

        Producto Fresas = new PFresco(LocalDate.of(2024,03,29),"p3654",30, 9.0, 210, LocalDate.of(2023,12,29),"Spain");
        PAlmacenado PAFresas = new PAlmacenado(Fresas, 10.05, "Caja de Fresas");
        almacen.compararProd(PAFresas);

        Producto aFresas = new PFresco(LocalDate.of(2024,03,29),"p3654",30, 9.0, 980, LocalDate.of(2023,12,29),"Spain");
        PAlmacenado PAaFresas = new PAlmacenado(aFresas, 10.05, "Caja 2");
        almacen.compararProd(PAaFresas);

        System.out.println(almacen.getEspacio());
        System.out.println(almacen.getEspacioOcupado());

        almacen.mostrarProductos();
        almacen.mostrarEspacio();

    }
}