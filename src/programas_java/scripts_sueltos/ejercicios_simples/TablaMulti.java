public class TablaMulti {

    public static void main(String[] args) {

        System.out.println("Introduzca qué tabla de multiplicar desea visualizar: ");
        int tabla = Integer.parseInt(System.console().readLine());

        TablaMul(tabla);
    }
    
    public static void TablaMul(int tabla) {

        System.out.println("Tabla del " + tabla + ":");

        for (int i = 1; i <= 10; i++) {
            
            System.out.println(tabla + " por " + i + " es igual a " + (tabla * i));
        }
    }
}
