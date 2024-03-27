import org.junit.*;
import static org.junit.Assert.*;

public class CalculadoraBasicaTest {

    @Test
    public void testSuma() {
        assertEquals(8, CalculadoraBasica.operacion('+', 5, 3), 0);
    }

    @Test
    public void testResta() {
        assertEquals(2, CalculadoraBasica.operacion('-', 5, 3), 0);
    }

    @Test
    public void testMultiplicacion() {
        assertEquals(15, CalculadoraBasica.operacion('*', 5, 3), 0);
    }

    @Test
    public void testDivision() {
        assertEquals(2, CalculadoraBasica.operacion('/', 6, 3), 0);
    }
}
