package factories;

import javafx.scene.image.Image;
import logging.DefaultLogger;
import logging.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;


/**
 * This is the resource loader
 * Provides a friendly interface for loading images into memory
 * it also caches and prevents the same resource to loaded twice
 */
public class ResourceLoader {
    private Logger logger;
    private HashMap<String, Image> quickLoader = new HashMap<>();
    private static final String [] DRONE_RESOURCES =new String[]{"drone01-sm","drone02-sm","drone03-sm"};

    private Random rand=new Random();

    private static ResourceLoader loader;

    /**

     * Initializes the singleton instance of the loader
     * @return the newrly created instance of loader
     * @throws FileNotFoundException ONLY IF the not found image is not found
     */
    public static ResourceLoader siglentonInitializer() throws FileNotFoundException {
        return loader = new ResourceLoader(new DefaultLogger());
    }

    /**
     * returns the instance (not safe,returns null if not initialized)
     * @return the instance of loader
     */
    public static ResourceLoader siglenton() {
        return loader;
    }

    /**
     * Sets the logger (used to print logs into the gui screen)
     * @param logger
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * The constructor
     * @param logger the default logger to print logs (may be the terminal or a gui view)
     * @throws FileNotFoundException if the broken.png did not found under the resources/internal folder
     */
    public ResourceLoader(Logger logger) throws FileNotFoundException {
        this.logger = logger;
        quickLoader.put("error", new Image(new FileInputStream("resources/internal/broken.png")));
    }

    /***
     * Loads a resource(an image) from resources/png file
     * @param resourceName the file name without the extension(!!!)
     * @return the javafx.Image object
     */
    public Image loadResource(String resourceName) {
        try {

            if (quickLoader.containsKey(resourceName)) return quickLoader.get(resourceName);
            else {
                Image tmp = new Image(new FileInputStream("resources/png/dronebase/" + resourceName + ".png"));
                quickLoader.put(resourceName, tmp);
                return tmp;
            }
        } catch (FileNotFoundException e) {
            logger.error("missing (" + resourceName + ")");
            return quickLoader.get("error");
        }
    }
    public Image loadRandomResource(){
        return loadResource(getRandomResource());
    }

    public String getRandomResource(){
        int index=Math.abs(rand.nextInt(DRONE_RESOURCES.length));
        return DRONE_RESOURCES[index];
    }

}
