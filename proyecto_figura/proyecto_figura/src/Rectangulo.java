public class Rectangulo extends FiguraPlana {

    private static final String NOMBRE = "Rectángulo";
    private double base;
    private double altura;

    public Rectangulo(double largo, double ancho) {

        super(NOMBRE);
        this.base = (largo <= 0) ? 1 : largo;
        this.altura = (ancho <= 0) ? 1 : ancho;
        if (altura <= 0) this.altura = 1;

    }

    @Override
    public int compareTo(FiguraPlana otraFigura) {

        return Double.compare(this.getArea(), otraFigura.getArea());

    }

    public double getBase() {
        return base;
    }    /**
     * Method implementation to calculate the area
     */
    @Override
    public double getArea() {
        return this.base * this.altura;
    }

    public void setBase(double base) {
        this.base = base;
    }    @Override
    public double perimetro() {
        return (2 * base) + (2 * altura);
    }

    public double getAltura() {
        return altura;
    }    /**
     * Returns a representative string of the square.
     */
    @Override
    public String toString() {

        return "Rectángulo: Base = " + base + ", Altura = " + altura + ", Área = " + getArea();
        
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }






}
