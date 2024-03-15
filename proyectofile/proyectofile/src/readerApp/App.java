package readerApp;

public class App {

    public static void main(String[] args) {

        Manager reader = new Manager();
        Manager reader2 = new Manager();

        String relativePathLocal = "src\\readerApp\\exampleLocal.txt";
        String absolutePathLocal = "D:\\Repositorios de código\\primero-DAM-DFR\\proyectofile\\proyectofile\\src\\readerApp\\exampleLocal.txt";

        String absolutePathtoD = "d:\\example.txt";
        String absolutePathToGif = "d:\\ASU-57 A.gif"; // No hay aplicación default para gif? No funciona.

        String relativePathLocalDir = "src\\readerApp\\exampledir";

        reader.openFile(relativePathLocal);

        reader.openFile(absolutePathLocal);

        reader2.openFile(absolutePathtoD);

        reader2.openFile(absolutePathToGif);

        reader2.openDir(relativePathLocalDir);

        System.out.println(reader.getSb().toString());
        System.out.println(reader2.getSb().toString());
    }
}
