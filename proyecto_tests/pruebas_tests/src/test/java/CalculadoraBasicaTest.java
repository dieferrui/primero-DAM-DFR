import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import pruebas_de_tests.CalculadoraBasica;

/* 
Tests realizados en VSCode, desconozco si se pueden importar
tal y como están hechos aquí a intelliJ
*/

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

    @Test
    public void testDivisionCero() {
        assertEquals(0, CalculadoraBasica.operacion('/', 8, 0));
    }
    
}
