package pruebalogger;

import org.apache.logging.log4j.*;

public class Main {
    
    private static Logger LOGGER = LogManager.getLogger("practica.solucion_ejercicios");
    
    public static void main(String[] args) {
       
        try {

            int res = 20 / 0;

        } catch (ArithmeticException e) {

            LOGGER.error("¡Error aritmético! No se puede dividir por cero.");

        }
    }
}
