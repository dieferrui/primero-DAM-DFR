import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Lector {

    private Lector() {
        // No necesitamos instancias de Lector
    }
    
    public static void openFile(String pathText) {
        
        try {
           
            File textFile = new File(pathText);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(textFile);

        } catch (IOException e) {
           
            e.printStackTrace();

        }
    }
}
