public class Matricad {

    private java.util.ArrayList<String> cadenes; 	// referència a la llista de cadenes, un camp
    /**
     * Constructor de Matricad.
     * @param dada matriu amb les cadenes per a la llista
     */
    public Matricad(String[] dada) {
        if ((dada == null) || (dada.length == 0)) {	// Verifiquem que la llista tinga valors  
            throw new IllegalArgumentException();
        }
        this.cadenes = new java.util.ArrayList<>();
        for (String element : dada) {
            cadenes.add(element);
        }
    }
    /**
     * @return la cadena que té més caràcters. La primera si hi ha diverses amb la mateixa longitud
     */
    public String getMaxCad() {
        String max = "";
        for (String element : cadenes) {
            if (element.length() > max.length()) {
                max = element;
            }
        }
        return max;
    }
    /**
     * @return la suma total de caràcters de totes les cadenes.
     */
    public int getSumaCaracters() {
        int total = 0;
        for (String d : cadenes) {
            total += d.length();
        }
        return total;
    }
    /**
     * Retorna l'índex de la cadena buscada.
     *
     * @param unaCadena Cadena buscada
     * @return Retorna la posició d'un element dins de l’array
     * @throws java.util.NoSuchElementException Si l'element no existeix en la llista
     */
    public int getIndexDe(String unaCadena) throws java.util.NoSuchElementException {
        if (unaCadena == null) { 	// Comprovem que l'argument siga vàlid  
            throw new IllegalArgumentException();
        }
        int pos = 0;
        for (String d : cadenes) { 	// Recorrem la informació fins a trobar l'element
            if (d.equals(unaCadena)) {
                return pos;
            }
            pos++;
        }
        throw new java.util.NoSuchElementException(unaCadena); 	// L'element no existeix, llancem l'excepció
    }
}