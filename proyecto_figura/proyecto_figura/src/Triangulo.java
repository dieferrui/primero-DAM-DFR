public class Triangulo extends FiguraPlana {

    private static final String NOMBRE = "Triángulo";

    private boolean isRectangulo;

    private double base;
    private double altura;

    private double a;
    private double b;
    private double c;

    public Triangulo(double base, double altura, boolean isRectangulo) {

        super(NOMBRE);
        this.base = base;
        this.altura = altura;
        this.base = (base <= 0) ? 1 : base;
        this.altura = (altura <= 0) ? 1 : altura;
        
        if (isRectangulo) {
            
            this.a = base;
            this.b = altura;
            this.calcularHipotenusa();

        }

    }

    public Triangulo(double a, double b, double c) {

        super(NOMBRE);
        this.a = (a <= 0) ? 1 : a;
        this.b = (b <= 0) ? 1 : b;
        this.c = (c <= 0) ? 1 : c;
        this.calcularBaseAltura();

    }

    // El método calcularHipotenusa sólo devuelve el tercer lado de un triángulo rectángulo
    public void calcularHipotenusa() {

        double h = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        this.c = h;

    }

    //El método calcularBaseAltura calcula la altura a partir de la base A
    public void calcularBaseAltura() {

        this.base = a;
        this.altura = (2 * getAreaDeSemiperimetro()) / a;

    }

    public double getAreaDeSemiperimetro() {

        double semiperimetro = semiperimetro();
        return Math.sqrt(semiperimetro * (semiperimetro - a) * (semiperimetro - b) * (semiperimetro - c));

    }

    private double semiperimetro() {

        return (a + b + c) / 2;
        
    }

    @Override
    public int compareTo(FiguraPlana otraFigura) {

        return Double.compare(getArea(), otraFigura.getArea());

    }

    @Override
    public double getArea() {

        return (base * altura) / 2;

    }

    @Override
    public double perimetro() {

        return a + b + c;

    }

    @Override
    public String toString() {

        return "Triángulo: A = " + a + ", B = " + b + ", C = " + c + ", Área = " + getArea();

    }
}
