package utils;

import logging.Logger;
import object.AbstractObject;

import java.io.*;
import java.util.List;

public class Serializer {
    public static String toFile(String filename, List<AbstractObject> list, Logger logger) throws FileNotFoundException,IOException {

        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(list);
        out.close();
        fileOut.close();
        logger.info("Simulation saved at " + filename);
        return filename;
    }
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
