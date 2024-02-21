package empresa_agro;

public abstract class Producto {
    
    private int diasCaducidad;
    private String numLote;
    private boolean isAlmacenado;

    private int stockEnKilos;
    private double precioPorKilo;

    public Producto(int diasCaducidad, String numLote) {
        
        this.diasCaducidad = diasCaducidad;
        this.numLote = numLote;

    }
    
    public int getDiasCaducidad() {
        return diasCaducidad;
    }
    public void setdiasCaducidad(int diasCaducidad) {
        this.diasCaducidad = diasCaducidad;
    }
    public String getNumLote() {
        return numLote;
    }
    public void setNumLote(String numLote) {
        this.numLote = numLote;
    }
    public boolean isAlmacenado() {
        return isAlmacenado;
    }
    public void setAlmacenado(boolean isAlmacenado) {
        this.isAlmacenado = isAlmacenado;
    }
    public int getStockEnKilos() {
        return stockEnKilos;
    }
    public void setStockEnKilos(int stockEnKilos) {
        this.stockEnKilos = stockEnKilos;
    }
    public double getPrecioPorKilo() {
        return precioPorKilo;
    }
    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }

    
    
    @Override
    public int hashCode() {
        final int prime = 36;
        int result = 1;
        result = prime * result + diasCaducidad;
        result = prime * result + (isAlmacenado ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (diasCaducidad != other.diasCaducidad)
            return false;
        if (numLote == null) {
            if (other.numLote != null)
                return false;
        } else if (!numLote.equals(other.numLote))
            return false;
        if (isAlmacenado != other.isAlmacenado)
            return false;
        if (stockEnKilos != other.stockEnKilos)
            return false;
        if (precioPorKilo != other.precioPorKilo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dias hasta caducidad: " + diasCaducidad + ", Núm. Lote: " + numLote + ", Stock en kilos: " + stockEnKilos + 
            ", Precio por kilo: " + precioPorKilo + ".";
    }

}
