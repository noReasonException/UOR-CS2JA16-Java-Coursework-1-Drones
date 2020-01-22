package utils;

import logging.Logger;
import object.AbstractObject;

import java.io.*;
import java.util.List;

public class Serializer {
    /**
     * it serializes a database content into a file
     * @param filename the fullpath of the file to be saved
     * @param list the contents of a database to be saved
     * @param logger the global logger
     * @return the filename
     * @throws FileNotFoundException in case of any error
     * @throws IOException in case of any error
     */
    public static String toFile(String filename, List<AbstractObject> list, Logger logger) throws FileNotFoundException,IOException {

        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(list);
        out.close();
        fileOut.close();
        logger.info("Simulation saved at " + filename);
        return filename;
    }
    /**
     * it deserializes a database content into a file
     * @param filename the fullpath of the file to be saved
     * @param logger the global logger
     * @return the filename
     * @throws FileNotFoundException in case of any error
     * @throws IOException in case of any error
     * @throws ClassNotFoundException in case of incompatible classes
     */
    public static List<AbstractObject> fromFile(String filename, Logger logger) throws IOException,ClassNotFoundException{
        List<AbstractObject> retval;
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        retval=(List<AbstractObject>) in.readObject();
        in.close();
        fileIn.close();

        logger.info("Simulation loaded from " + filename);
        return retval;
    }
}
