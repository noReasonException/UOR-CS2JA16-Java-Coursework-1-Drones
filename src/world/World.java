package world;

import etc.WindowInfo;
import logging.DefaultLogger;
import logging.Logger;
import math.vector.Vector;
import math.vector.Vector3;
import object.AbstractObject;

import java.util.HashMap;
import java.util.Random;

public class World {
    private HashMap<Vector3, AbstractObject> data;
    private WindowInfo windowInfo;
    private Random randint = new Random();
    private Logger logger = new DefaultLogger();

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

    public Vector3 toWorldCoordinates(Vector3 droneRealLocation) {
        int worldX = (droneRealLocation.getCore().getElement(0).intValue() / windowInfo.getCubeX());
        if (droneRealLocation.getCore().getElement(0).intValue() % windowInfo.getCubeX() != 0) worldX += 1;
        int worldY = droneRealLocation.getCore().getElement(1).intValue() / windowInfo.getCubeY();
        if (droneRealLocation.getCore().getElement(1).intValue() % windowInfo.getCubeY() != 0) worldY += 1;
        int worldZ = droneRealLocation.getCore().getElement(2).intValue() / windowInfo.getCubeZ();
        if (droneRealLocation.getCore().getElement(2).intValue() % windowInfo.getCubeZ() != 0) worldZ += 1;
        return new Vector3(Integer.valueOf(worldX).doubleValue(), Integer.valueOf(worldY).doubleValue(), Integer.valueOf(worldZ).doubleValue());
    }

    public boolean collisionWithAny(Vector3 location) {
        AbstractObject result = data.get(toWorldCoordinates(location));
        if (collisionWithWall(location)) return true;
        else if (result == null) {
            return false;
        } else return true;
    }

    public boolean collision(AbstractObject d, Vector3 location) {
        AbstractObject result = data.get(toWorldCoordinates(location));
        if (collisionWithWall(location)) return true;
        else if (result == null) return false;
        else if (result.getId() == d.getId()) return false;
        else if (!result.isVisible()) return false;
        else return true;
    }

    public boolean collisionWithWall(Vector3 location) {
        return location.getCore().getElement(0) > windowInfo.getWindowX() - randint.nextInt(50) ||
                location.getCore().getElement(1) > windowInfo.getWindowY() - randint.nextInt(50) ||
                location.getCore().getElement(0) < 5 ||
                location.getCore().getElement(1) < 5 ||
                location.getCore().getElement(2) < 5;
    }

    public void eraseObject(AbstractObject ab) {
        data.remove(ab.getPosition(), ab);
        logger.info(ab.toString() + " erased from mem");
    }

    public void updatePosition(AbstractObject d, Vector3 location) {
        synchronized (this) {
            this.data.remove(toWorldCoordinates(location), d);
            this.data.put(toWorldCoordinates(location), d);

        }
    }


}