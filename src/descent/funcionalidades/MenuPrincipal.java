package Descent.Funcionalidades;

import java.util.Scanner;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

import Descent.Objetos.*;

public class MenuPrincipal {

    public static final Scanner SC = new Scanner(System.in);
    public static String apiKey;
     
    public static void main(String[] args) {

        
        try {

            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\Primero-DAM-DFR\\Primero-DAM-DFR\\Descent\\Funcionalidades\\config.properties"));

            apiKey = properties.getProperty("openai.apiKey");

        } catch (Exception e) {

            e.printStackTrace();

        }
    
        String selectMenu;
        String pathGuia = "D:\\Primero-DAM-DFR\\Primero-DAM-DFR\\Descent\\guia.txt";
        String pathPuntos = "D:\\Primero-DAM-DFR\\Primero-DAM-DFR\\Descent\\puntuaciones.txt";

        do {
            
            // Este es el menú principal per se
            System.out.println("DESCENT\n");
            System.out.println("1. Entrar en la mazmorra\n2. Ayuda\n3. Puntuaciones\n4. Salir");
            selectMenu = SC.nextLine();

            if (selectMenu.equals("1")) {
                
                CicloDeJuego.iniciarJuego();

            } else if (selectMenu.equals("2")) {
                
                abrirTexto(pathGuia);

            } else if (selectMenu.equals("3")) {

                abrirTexto(pathPuntos);

            }

        } while (!selectMenu.equalsIgnoreCase("4"));

        SC.close();

    }

    // Este método sirve para abrir los archivos de texto de ayuda y puntuaciones
    public static void abrirTexto(String pathText) {
        
        try {
           
            File textFile = new File(pathText);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(textFile);

        } catch (IOException e) {
           
            e.printStackTrace();

        }
    }
}
