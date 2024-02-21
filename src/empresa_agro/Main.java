package empresa_agro;

import java.util.Scanner;

public class Main {

    public static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {

        Fresco lecheEntera = new Fresco(10, "LE03345", "22 de Diciembre de 2023", "ES");
        Refrigerado quesoDeCabra = new Refrigerado(566, "QC00654", "OMS-33L");
        Congelado heladosDelCarrion = new Congelado(233, "HC60994", -8);

        final Producto[] PRODUCTOS = {lecheEntera, quesoDeCabra, heladosDelCarrion};

        String eleccionMenu;

        System.out.println("Aplicación de prueba del almacén de AgroProdes S.L");
        System.out.println("Con esta aplicación podrá testear las funciones del almacén\n"
                            + "con un producto de cada tipo: leche entera (fresco), queso\n"
                            + "de cabra (refrigerado) y helados (congelado).\n");
        
        do {
            
            Almacen almacen = new Almacen();

            System.out.println("(Se ha creado un almacén de testeo)");
            System.out.println("Elija qué quiere hacer a continuación:\n1. Ver productos almacenados\n"
                                + "2. Almacenar producto\n3. Extraer stock de producto");
            eleccionMenu = SC.nextLine();

            switch(eleccionMenu) {

                case "1":
                    almacen.verProductosEnStock(); 
                    break;

                case "2":
                    System.out.println("Elija el producto a almacenar:\n1. Leche\n2. Queso\n3. Helados\n");
                    String numProducto = SC.nextLine();

                    switch(numProducto) {

                        case "1":
                            Fresco leche = (Fresco)PRODUCTOS[0];
                            almacen.almacenarProducto(leche);
                            break;
                        
                        case "2":
                            Refrigerado queso = (Refrigerado)PRODUCTOS[1];
                            almacen.almacenarProducto(queso);
                            break;
                        
                        case "3":
                            Congelado helado = (Congelado)PRODUCTOS[2];
                            almacen.almacenarProducto(helado);
                        break;
                    }

                    break;
                
                case "3":
                    int cantidadExtraida = almacen.extraerProducto();
                    System.out.println("Se han extraído " + cantidadExtraida + "Kg de producto.");
                    break;
                
                case "4":
                    System.out.println("Eliminando cambios...");
                    break;

                default:
                    System.out.println("Saliendo de forma forzosa...");
                    eleccionMenu = "4";
                    break;
            }
            
        } while (!eleccionMenu.equals("4"));
    }
    
}
