package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileSaver {
    /***
     * saves a raw string into a file
     * @param filename the filename to save(full path)
     * @param rawData the data to be saved
     * @return the rawData
     * @throws FileNotFoundException in case of any error
     */
    public static String saveToFile(String filename,String rawData) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(new FileOutputStream(filename))) {
            out.print(rawData);
        }
        return filename;
    }
}
