public class PAlmacenado {

    private Producto producto;
    private int stock;
    private double precio;

    public PAlmacenado(Producto producto, int stock, double precio) {

        this.producto = producto;
        this.stock = stock;
        this.precio = precio;

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto: " + producto.getNumeroLote() + " - Stock: " + stock + " - Precio: " + precio;
    }

}
