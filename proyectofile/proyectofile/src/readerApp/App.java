package readerApp;

import java.io.File;

public class App {

    public static void main(String[] args) {

        Manager reader = new Manager();

        File ficheroBuff = reader.createFile("c:\\Users\\alumno\\Desktop\\ficheroBuffered.txt");
        
    }
}
