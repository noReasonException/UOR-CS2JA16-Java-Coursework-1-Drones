package world;

import etc.WindowInfo;
import logging.DefaultLogger;
import logging.Logger;
import math.vector.Vector;
import math.vector.Vector3;
import object.AbstractObject;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;


/***
 * The world map object
 * keeps track of all objects in the game , detects collisions etc
 */
public class World implements Closeable {
    private HashMap<Vector3, AbstractObject> data;
    private WindowInfo windowInfo;
    private Random randint = new Random();
    private Logger logger = new DefaultLogger();

    //logger
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public HashMap<Vector3, AbstractObject> getData() {
        return data;
    }


    public World(WindowInfo windowInfo) {
        this.windowInfo = windowInfo;
        this.data = new HashMap<>();
    }

    /***
     * converts the real location of each object into the world-compatible tile location
     * @param droneRealLocation the drone location
     * @return the drones tile-based location
     */
    public Vector3 toWorldCoordinates(Vector3 droneRealLocation) {
        int worldX = (droneRealLocation.getCore().getElement(0).intValue() / windowInfo.getCubeX());
        if (droneRealLocation.getCore().getElement(0).intValue() % windowInfo.getCubeX() != 0) worldX += 1;
        int worldY = droneRealLocation.getCore().getElement(1).intValue() / windowInfo.getCubeY();
        if (droneRealLocation.getCore().getElement(1).intValue() % windowInfo.getCubeY() != 0) worldY += 1;
        int worldZ = droneRealLocation.getCore().getElement(2).intValue() / windowInfo.getCubeZ();
        if (droneRealLocation.getCore().getElement(2).intValue() % windowInfo.getCubeZ() != 0) worldZ += 1;
        return new Vector3(Integer.valueOf(worldX).doubleValue(), Integer.valueOf(worldY).doubleValue(), Integer.valueOf(worldZ).doubleValue());
    }

    /**
     *
     * @param location the location query
     * @return true if anything exists there(including level limits)
     */
    public boolean collisionWithAny(Vector3 location) {
        AbstractObject result = data.get(toWorldCoordinates(location));
        if (collisionWithWall(location)) return true;
        else if (result == null) {
            return false;
        } else return true;
    }

    /**
     *
     * @param d the object firing this method
     * @param location the objects next location
     * @return true if the object can procceed in the next location
     */
    public boolean collision(AbstractObject d, Vector3 location) {
        AbstractObject result = data.get(toWorldCoordinates(location));
        if (collisionWithWall(location)) return true;
        else if (result == null) return false;
        else if (result.getId() == d.getId()) return false;
        else if (!result.isVisible()) return false;
        else return true;
    }

    /**
     *
     * @param location the location query
     * @return true if this location is outside level limits
     */
    public boolean collisionWithWall(Vector3 location) {
        return location.getCore().getElement(0) > windowInfo.getWindowX() - randint.nextInt(50) ||
                location.getCore().getElement(1) > windowInfo.getWindowY() - randint.nextInt(50) ||
                location.getCore().getElement(0) < 5 ||
                location.getCore().getElement(1) < 5 ||
                location.getCore().getElement(2) < 5;
    }

    /**
     * deletes the object from the memory
     * @param ab the issuing AbstractObject
     */
    public void eraseObject(AbstractObject ab) {
        data.remove(ab.getPosition(), ab);
        logger.info(ab.toString() + " erased from mem");
    }

    /**
     * updates the location of object @param d into @param location
     * @param d the object
     * @param location the object's next location
     */
    public void updatePosition(AbstractObject d, Vector3 location) {
        synchronized (this) {
            this.data.remove(toWorldCoordinates(location), d);
            this.data.put(toWorldCoordinates(location), d);

        }
    }

    @Override
    public void close() throws IOException {
        this.data.clear();
        logger.info("WorldMap object terminates itself");
    }
}