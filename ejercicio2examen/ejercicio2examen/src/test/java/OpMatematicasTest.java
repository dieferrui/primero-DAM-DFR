import org.testng.annotations.Test;

import com.diego.*;

public class OpMatematicasTest {
    
    @Test(expectedExceptions = {java.lang.IllegalArgumentException.class})
    public void testOpMatematicasNull() {
        System.out.println("Constructor nulo");
        OpMatematicas instance = new OpMatematicas(null);
    }

    @Test(expectedExceptions = {java.lang.IllegalArgumentException.class})
    public void testOpMatematicasVacio() {
        System.out.println("Constructor vacío");
        int[] datos = {};
        OpMatematicas instance = new OpMatematicas(datos);
    }

    @Test
    public void testMinimo() {
        int[] datos = {1, 2, 3, 4, 5, 6, 7, 8};
        OpMatematicas operaciones = new OpMatematicas(datos);

        int resultado = operaciones.getMinimo();
        assertEquals(1, resultado, 0.001);
    }

    @Test
    public void testMaximo() {
        int[] datos = {1, 2, 3, 4, 5, 6, 7, 8};
        OpMatematicas operaciones = new OpMatematicas(datos);

        int resultado = operaciones.getMaximo();
        assertEquals(8, resultado, 0.001);
    }

    @Test
    public void testSuma() {
        int[] datos = {1, 2, 3, 4, 5, 6, 7, 8};
        OpMatematicas operaciones = new OpMatematicas(datos);

        int resultado = operaciones.getSuma();
        assertEquals(36, resultado, 0.001);
    }

    @Test
    public void testIndice3() {
        int[] datos = {1, 2, 3, 4, 5, 6, 7, 8};
        OpMatematicas operaciones = new OpMatematicas(datos);

        int resultado = operaciones.getIndiceDe(3);
        assertEquals(4, resultado, 0.001);
    }

    @Test(expectedExceptions = {java.util.NoSuchElementException.class})
    public void testIndiceFuera() {
        int[] datos = {1, 2, 3, 4, 5, 6, 7, 8};
        OpMatematicas operaciones = new OpMatematicas(datos);

        System.out.println("Posición inválida");
        int resultado = operaciones.getIndiceDe(666);
    }
}
