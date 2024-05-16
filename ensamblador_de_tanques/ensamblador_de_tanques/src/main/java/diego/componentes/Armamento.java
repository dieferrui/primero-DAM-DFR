package diego.componentes;

import diego.componentes.enums.ClaseArmamento;
import diego.componentes.enums.Municion;
import diego.Paises;

public class Armamento extends Componente {

    private static final String MILL = "mm";

    private String designacion;
    private Paises[] usuarios;
    private double peso;

    private ClaseArmamento clase;

    private int penetracionCorta;
    private int penetracionMedia;
    private int penetracionLarga;
    private int[] penetracion;

    private int calibre;

    private Municion municionPrimaria;

    // El constructor sólo se usará por el administrador de la app para añadir componentes
    public Armamento(String designacion, Paises[] usuarios, double peso, ClaseArmamento clase, 
                        int[] penetracion, int calibre, Municion municionPrimaria) {

        super(designacion, usuarios, peso);

        this.clase = clase;

        this.penetracion = penetracion;
        this.penetracionCorta = penetracion[0];
        this.penetracionMedia = penetracion[1];
        this.penetracionLarga = penetracion[2];

        this.calibre = calibre;
        this.municionPrimaria = municionPrimaria;

    }

    public ClaseArmamento getClase() {
        return clase;
    }

    public int getPenetracionCorta() {
        return penetracionCorta;
    }

    public int getPenetracionMedia() {
        return penetracionMedia;
    }

    public int getPenetracionLarga() {
        return penetracionLarga;
    }

    public int getCalibre() {
        return calibre;
    }

    public Municion getMunicionPrimaria() {
        return municionPrimaria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(peso);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((clase == null) ? 0 : clase.hashCode());
        result = prime * result + calibre;
        result = prime * result + ((municionPrimaria == null) ? 0 : municionPrimaria.hashCode());
        result = prime * result + ((designacion == null) ? 0 : designacion.hashCode());
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
        Armamento other = (Armamento) obj;
        if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
            return false;
        if (clase != other.clase)
            return false;
        if (calibre != other.calibre)
            return false;
        if (municionPrimaria != other.municionPrimaria)
            return false;
        return true;
    }

    public String mostrarDatos() {
        return "Armamento con designación " + getDesignacion() + ":\n" +
                "Clase: " + getClase().getClase() + "\n" +
                "Peso: " + getPeso() + "Kg\n" +
                "Calibre: " + getCalibre() + MILL + "\n" +
                "Penetración a distancias cortas: " + getPenetracionCorta() + MILL + "\n" +
                "Penetración a distancias medias: " + getPenetracionMedia() + MILL + "\n" +
                "Penetración a distancias largas: " + getPenetracionLarga() + MILL + "\n" +
                "Tipo de munición primaria: " + getMunicionPrimaria().getTipo();
    }

}