package empresa_agro;

public class Congelado extends Producto {
    
    private int tempCongelacion;

    public Congelado(int diasCaducidad, String numLote, int tempCongelacion) {

        super(diasCaducidad, numLote);
        this.tempCongelacion = tempCongelacion;

    }

    public int getTempCongelacion() {
        return tempCongelacion;
    }

    public void setTempCongelacion(int tempCongelacion) {
        this.tempCongelacion = tempCongelacion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + tempCongelacion;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Congelado other = (Congelado) obj;
        if (tempCongelacion != other.tempCongelacion)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Congelado [tempCongelacion=" + tempCongelacion + "]";
    }

}
