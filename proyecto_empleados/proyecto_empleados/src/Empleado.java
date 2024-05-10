public class Empleado {

    private String nombre;
    private String posicion;

    public Empleado(String nombre, String posicion) {

        this.nombre = nombre;
        this.posicion = posicion;

    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
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
        Empleado other = (Empleado) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equalsIgnoreCase(other.nombre))
            return false;
        if (posicion == null) {
            if (other.posicion != null)
                return false;
        } else if (!posicion.equalsIgnoreCase(other.posicion))
            return false;
        return true;
    }
}
