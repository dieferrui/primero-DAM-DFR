public class EjParse2 {

    public static void main(String[] args) {

        ejer1();
        ejer2();
        ejer3();
        ejer4();
        ejer5();
        ejer6();
        ejer7();
        ejer8();
        ejer9();
    }

    public static void ejer1() {

        char digito = 8550;
        char digito2 = '7';
        Character.isDigit(digito);
        System.out.println(Character.isDigit(digito));
        System.out.println(Character.isDigit(digito2));
    }
    
    public static void ejer2() {

        char letra = 'j';
        System.out.println(Character.isLetter(letra));
    }

    public static void ejer3() {

        double a = 3.5d;
        double b = 4.0d;
        double result3 = Double.max(a, b);
        System.out.println(result3);
    }

    public static void ejer4() {

        int maxInt = Integer.MAX_VALUE;
        System.out.println(maxInt);
    }

    public static void ejer5() {

        String c = "uno";
        String d = "Uno";
        System.out.println(d.equals(c));
    }

    public static void ejer6() {

        String c = "uno";
        String d = "Uno";
        System.out.println(d == c);
    }

    public static void ejer7() {

        String saludo = "Hola";
        System.out.println(saludo.charAt(0));
    }

    public static void ejer8() {

        String cadena = "caracola";
        int longitud = cadena.length();
        System.out.println(longitud);
    }

    public static void ejer9() {

        String str = "eloquent";
        int longitud = str.length();
        String strReducido = str.substring(1, longitud-1);
        System.out.println(strReducido);
    }
}
