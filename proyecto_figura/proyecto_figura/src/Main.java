import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {

        Circulo circulo1 = new Circulo(1.1d);
        Circulo circulo2 = new Circulo(2.8d);
        Circulo circulo3 = new Circulo(5.5d);
        Circulo circulo4 = new Circulo(11.0d);

        Triangulo triangulo1 = new Triangulo(3.0d, 4.0d, 5.0d);
        Triangulo triangulo2 = new Triangulo(4.0d, 5.5d, 7.0d);
        Triangulo triangulo3 = new Triangulo(9.0d, 6.0d, 10.5d);

        Rectangulo rectangulo1 = new Rectangulo(2.0d, 4.0d);
        Rectangulo rectangulo2 = new Rectangulo(5.0d, 6.0d);
        Rectangulo rectangulo3 = new Rectangulo(7.0d, 8.0d);

        List<FiguraPlana> figuras = new ArrayList<>();
        figuras.add(circulo1);
        figuras.add(circulo2);
        figuras.add(circulo3);
        figuras.add(circulo4);
        figuras.add(triangulo1);
        figuras.add(triangulo2);
        figuras.add(triangulo3);
        figuras.add(rectangulo1);
        figuras.add(rectangulo2);
        figuras.add(rectangulo3);

        /*
        Collections.sort(figuras);

        System.out.println("Figuras ordenadas por área (de menor a mayor) mediante comparable: ");
        
        for (FiguraPlana figura : figuras) {

            System.out.println(figura.toString());

        }
        */

        ComparadorArea comparadorArea = new ComparadorArea(){

            @Override
            public int compare(FiguraPlana figura1, FiguraPlana figura2) {

                return Double.compare(figura1.getArea(), figura2.getArea());
        
            }
            
        };

        Collections.sort(figuras, comparadorArea);

        System.out.println("Figuras ordenadas por área (de menor a mayor) mediante comparator: ");
        
        for (FiguraPlana figura : figuras) {

            System.out.println(figura.toString());

        }
        
    }
}

class ComparadorArea implements Comparator<FiguraPlana> {

    public int compare(FiguraPlana figura1, FiguraPlana figura2) {

        return Double.compare(figura1.getArea(), figura2.getArea());

    }

}
