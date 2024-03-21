package readerApp;

import java.io.File;

public class App {

    public static void main(String[] args) {

        Manager manager = new Manager();

        File bufferedText = manager.createFile("proyectofile/proyectofile/src/readerApp/buffText.txt");
        manager.creaLineas(bufferedText, 50);

    }
}
