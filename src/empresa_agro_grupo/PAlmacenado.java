import java.time.LocalDate;

public class PAlmacenado {

    private Producto producto;
    private LocalDate fechaCad;
    private String numeroLote;
    private int stock;
    private double precio;
    private String descripcion;
    private String tipo;

    public PAlmacenado(Producto producto, double precio, String descripcion) {

        this.producto = producto;
        this.fechaCad = producto.getFechaCad();
        this.numeroLote = producto.getNumeroLote();
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipo = producto.getClass().getName();
        aumentarStock(producto);

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public LocalDate getFechaCad() {
        return fechaCad;
    }

    public void setFechaCad(LocalDate fechaCad) {
        this.fechaCad = fechaCad;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
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

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    protected void aumentarStock(Producto producto) {
        this.stock = stock + producto.getCantidad();
    }

}
