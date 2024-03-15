package readerApp;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Reader {

    public Reader() {
        // Constructor simple
    }
    
    public void openFile(String pathText) {
        
        try {
           
            File textFile = new File(pathText);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(textFile);

        } catch (IOException e) {
           
            e.printStackTrace();

        }
    }
}
