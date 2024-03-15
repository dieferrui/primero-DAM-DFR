package readerApp;

import java.io.File;

public class App {

    public static void main(String[] args) {

        Manager reader = new Manager();
        Manager reader2 = new Manager();

        String relativePathLocal = "src\\readerApp\\exampleLocal.txt";
        String absolutePathLocal = "D:\\Repositorios de código\\primero-DAM-DFR\\proyectofile\\proyectofile\\src\\readerApp\\exampleLocal.txt";

        String absolutePathtoD = "d:\\example.txt";
        String absolutePathToGif = "d:\\ASU-57 A.gif"; // No hay aplicación default para gif? No funciona.

        String relativePathLocalDir = "src\\readerApp\\exampledir";
        String relativePathLocalDir2 = "src\\readerApp\\exampledir2";

        /*
        reader.openFile(relativePathLocal);

        reader.openFile(absolutePathLocal);

        reader2.openFile(absolutePathtoD);

        reader2.openFile(absolutePathToGif);

        reader2.openDir(relativePathLocalDir);

        File textFileA = new File(relativePathLocal);
        File textFileB = new File(absolutePathLocal);

        reader2.getInformation(textFileA);
        reader2.getInformation(textFileB);
        reader2.deleteFile(textFileB);
        */

        reader.newDirFilled(relativePathLocalDir2);

        System.out.println(reader.getSb().toString());
        System.out.println(reader2.getSb().toString());
    }
}
