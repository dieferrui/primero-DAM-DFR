package pruebalogger;

import org.apache.logging.log4j.*;

public class Main {
    
    private static Logger LOGGER = LogManager.getRootLogger();
    
    public static void main(String[] args) {
       
        try {

            // Código que puede generar una excepción

        } catch (ArithmeticException e) {

            LOGGER.error("¡Error aritmético! No se puede dividir por cero.");

        }
    }
}