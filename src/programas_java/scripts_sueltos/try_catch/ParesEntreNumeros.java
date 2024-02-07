public class ParesEntreNumeros {

    public static void main(String[] args) {
        
        boolean checker = true;
        int inf = 0;
        int sup = 0;
        
        while (checker) {
            
            System.out.println("Introduzca el límite inferior de la serie: ");
            String firstValue = System.console().readLine();

            System.out.println("Introduzca el límite superior de la serie: ");
            String secondValue = System.console().readLine();

            try {
                
                int[] checkedValues = valueChecker(firstValue, secondValue, inf, sup);
                inf = checkedValues[0];
                sup = checkedValues[1];
                checker = false;

            } catch (IncorrectOrderException e) {

                System.out.println(e.getMessage());

            } catch (NumberFormatException e) {
                
                System.out.println(e.getMessage());

            }
        }

        CalcularSumaPares(inf, sup);

    }

    public static class IncorrectOrderException extends Exception {
        public IncorrectOrderException(String mensajeError) {
            super(mensajeError);
        }
    }

    public static int[] valueChecker(String firstValue, String secondValue, int inf, int sup) throws IncorrectOrderException {

        try {
            inf = Integer.parseInt(firstValue);
            sup = Integer.parseInt(secondValue);

            if (sup <= inf) {
                throw new IncorrectOrderException("El límite inferior es igual o mayor al superior.");
            }

            int[] valueArray = new int[2];
            valueArray[0] = inf;
            valueArray[1] = sup;

            return valueArray;

        } catch (NumberFormatException e) {
            
            throw new NumberFormatException("Uno de los valores introducidos no es un número válido.");
        }
    }

    public static void CalcularSumaPares(int inf, int sup) {
        
        int sumaTotal = 0;

        for (int min = inf; min <= sup; min++) {
            if (min % 2 == 0) {
                sumaTotal += min;
            }
        }

        System.out.printf("El resultado de la suma de los números pares entre los valores %d y %d es %d.", inf, sup, sumaTotal);
    }
}
