package readerApp;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Manager {
    
    private StringBuilder sb = new StringBuilder("");

    public Manager() {
        // Constructor simple
    }

    public void creaLineas(File file, int numLin) {

        try {

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 1; i <= numLin; i++) {

                bw.write("Linea numero " + i);
                bw.newLine();

            }

            bw.close();
            sb.append(file.getName() + " creado." + numLin + " lineas.");
            System.out.println(sb.toString());

        } catch (IOException e) {

            System.out.println("Se ha producido un error al crear el archivo " + file.getName());

        }

    }

    public File createFile(String path) {

        return new File(path);

    }
    
    public void openFile(File file) {
        
        try {

            Desktop desktop = Desktop.getDesktop();
            sb.append("File " + file.toPath() + " is " + file.exists() + "\n");
            sb.append("\n");
            desktop.open(file);

        } catch (Exception e) {
           
            e.printStackTrace();

        }
    }

    public void openDir(File dir) {
        
        try {

            Desktop desktop = Desktop.getDesktop();
            sb.append("File " + dir.toPath() + " is " + dir.mkdir() + "\n");
            sb.append("\n");
            desktop.open(dir);

        } catch (Exception e) {
           
            e.printStackTrace();

        }
    }

    public void getInformation(File file) {

        sb.append("Path of file " + file.getName() + " is " + file.getAbsolutePath()+ "\n");
        sb.append("Parent of file " + file.getName() + " is " + file.getParent()+ "\n");
        sb.append("This file is normal? " + file.isFile() + ". Therefore, it is not hidden " + file.isHidden()+ "\n");
        sb.append("This file was last modified: " + file.lastModified()+ "\n");

    }

    public void deleteFile(File file) {

        sb.append("File " + file.getName());
        file.delete();
        sb.append(" has been deleted.\n");
        sb.append("Confirmation: Does file exist? " + file.exists());

    }

    public File restructure(File file) {

        String pathFile = file.getAbsolutePath();

        if (file.exists()) {
            
            file.delete();

        }

        File newFile = new File(pathFile);
        return newFile;

    }

    public void newDirFilled(String pathText) {

        File directoryFile = new File(pathText);
        directoryFile.mkdir();

        for (int i = 1; i < 11; i++) {

            String filePath = directoryFile.getAbsolutePath() + "\\example" + i + ".txt";
            File file = new File(filePath);
            
            try {
                
                file.createNewFile();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        for (File file : directoryFile.listFiles()) {

            sb.append(file.getName() + "\n");
            
        }
    }

    public StringBuilder getSb() {
        return sb;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }

}
