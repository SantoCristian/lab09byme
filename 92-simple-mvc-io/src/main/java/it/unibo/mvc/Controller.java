package it.unibo.mvc;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;
    final private static String SEP = System.getProperty("file.separator");
    final private static String DEFAULT_NAME = 
        System.getProperty("user.home") + SEP + "output.txt";

    Controller() {
        this.currentFile = new File(DEFAULT_NAME);
    }
    /**
     * This method sets the value of the current file.
     * @param fileWanted the file that i want 
     */
    public void setCurrentFile(final File fileWanted) {
        this.currentFile = fileWanted;
    }

    /**
     * This method returns the current file
     * @return Provides the current file 
     */
    public  File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * This method gives a String whitch is the path of the current file.
     * 
     * @return Provides the path (String)
     */
    public String getPath() {
        return this.currentFile.getPath();
    }

    /**
     * This is a method that can write a String on the current document
     * 
     * @param string The String i want to write
     * @throws IOException Throws IOexception when there is a problem with I/O on the file
     */
    public void writeOnCurrent(String string) throws IOException {
            final OutputStream file = new FileOutputStream(currentFile.getPath());
            final OutputStream bFile = new BufferedOutputStream(file);
            final DataOutputStream dFile = new DataOutputStream(bFile);

            dFile.writeUTF(string);
    }


}
