package readerApp;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Manager {

    private StringBuilder sb = new StringBuilder("");

    public Manager() {
        // Constructor simple
    }
    
    public void openFile(String pathText) {
        
        try {
           
            File textFile = new File(pathText);
            Desktop desktop = Desktop.getDesktop();
            sb.append("File " + textFile.toPath() + " is " + textFile.exists());
            sb.append("\n");
            desktop.open(textFile);

        } catch (IOException e) {
           
            e.printStackTrace();

        }
    }

    public void openDir(String pathText) {
        
        try {
           
            File directoryFile = new File(pathText);
            Desktop desktop = Desktop.getDesktop();
            sb.append("File " + directoryFile.toPath() + " is " + directoryFile.mkdir());
            sb.append("\n");
            desktop.open(directoryFile);

        } catch (IOException e) {
           
            e.printStackTrace();

        }
    }

    public StringBuilder getSb() {
        return sb;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }

}
