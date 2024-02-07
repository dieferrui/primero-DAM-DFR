package descent.funcionalidades;

import java.util.Scanner;

public class Principal {
    
    static final Scanner SC = new Scanner(System.in);
    static final String GUIDEPATH = "descendents\\archivos\\guide.txt";
    static final String SCOREPATH = "descendents\\archivos\\scores.txt";
    public static void main(String[] args) {

        mainMenu();

    }

    public static void mainMenu() {

        String selectMenu;
        final String ONE = "1";
        final String TWO = "2";
        final String TRI = "3";
        
        do {
            
            System.out.println("DESCENDENTS\n");
            System.out.println("1. Entrar en la mazmorra\n2. Ayuda\n3. Puntuaciones\n4. Salir");
            selectMenu = SC.nextLine();

            if (selectMenu.equals(ONE)) {
                
                Juego.startGame();

            } else if (selectMenu.equals(TWO)) {
                
                Lector.openFile(GUIDEPATH);

            } else if (selectMenu.equals(TRI)) {

                Lector.openFile(SCOREPATH);

            }

        } while (!selectMenu.equalsIgnoreCase("4"));

        SC.close();
        
    }
}
