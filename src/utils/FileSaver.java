package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileSaver {
    public static String saveToFile(String filename,String rawData) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(new FileOutputStream(filename+"/log.log"))) {
            out.print(rawData);

        }
        return filename+"/log.log";
    }
}
