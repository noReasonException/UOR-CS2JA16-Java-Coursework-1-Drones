package factories;

import javafx.scene.image.Image;
import logging.DefaultLogger;
import logging.Logger;
import object.AbstractObject;

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
    private static final String [] DRONE_RESOURCES =new String[]{"drone01","drone02","drone03"};
    private static final String BULLET_RESOURCE ="bullet";
    private static final String TURRET_RESOURCE ="turret";

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

    /**
     * Loads the proper resource based in the AbstractObject's height
     * as the height increases , the size of the object increases too , this method takes care of it and it ensures that
     * every drone gets dynamically the proper sprite
     * @param o the AbstractObject to get the information from
     * @return the proper representing image for this AbstractObject
     */
    public Image loadResource(AbstractObject o){
        return loadResource(o.getRepresentationResourceName()+"-"+o.getPosition().getCore().getElement(2).intValue());
    }

    /**
     * Returns a random Drone resource , this needs to be used in combination with
     * a small example will make this clear
     * randomResource -> drone01
     * loadResource("drone01",new Vector(1,2,3)); -> drone01-3 (the first drone , the third image(1 smallest , 5 biggest))
     * @see ResourceLoader#loadResource(AbstractObject)
     * @return a string with the resource name(not the full name though , for the full name we need .loadResource to get the proper sprite(with the proper height))
     *
     *
     */
    public String getRandomDroneResource(){
        int index=Math.abs(rand.nextInt(DRONE_RESOURCES.length));
        return DRONE_RESOURCES[index];
    }

    /**
     *
     * @return the bullets resource name
     */
    public static String getBulletResource() {
        return BULLET_RESOURCE;
    }

    /**
     *
     * @return the turret resource name
     */
    public static String getTurretResource() {
        return TURRET_RESOURCE;
    }
}
