package factories;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logging.DefaultLogger;
import logging.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class ResourceLoader {
    private Logger logger;
    private HashMap<String, Image> quickLoader = new HashMap<>();

    private static ResourceLoader loader;

    public static ResourceLoader siglentonInitializer() throws FileNotFoundException {
        return loader = new ResourceLoader(new DefaultLogger());
    }

    public static ResourceLoader siglenton() {
        return loader;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public ResourceLoader(Logger logger) throws FileNotFoundException {
        this.logger = logger;
        quickLoader.put("error", new Image(new FileInputStream("resources/internal/broken.png")));
    }

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

    public ImageView loadResourceView(String resourceName) {
        return new ImageView(loadResource(resourceName));
    }

}
