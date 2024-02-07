public class EjerciciosParse {

    public static void main(String[] args) {

        System.out.println(stringToInt());
        System.out.println(intToString());
        System.out.println(charToString());
        System.out.println(stringToBoolean());
        System.out.println(stringToDouble());
    }

    public static int stringToInt() {

        String num2 = "2";
        int result1 = Integer.parseInt(num2);
        return result1;
    }
    
    public static String intToString() {

        int numero = 1985;
        String result2 = Integer.toString(numero);
        return result2;
    }

    public static String charToString() {

        char chara = 'p';
        String result3 = Character.toString(chara);
        return result3;
    }

    public static Boolean stringToBoolean() {

        String falseBoolean = "true";
        boolean result4 = Boolean.parseBoolean(falseBoolean);
        return result4;
    }

    public static double stringToDouble() {

        String num3 = "2.5";
        double result5 = Double.parseDouble(num3);
        return result5;
    }
}
