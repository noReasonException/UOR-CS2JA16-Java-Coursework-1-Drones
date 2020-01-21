package database;

import etc.Constants;
import factories.ResourceLoader;
import javafx.scene.image.Image;
import logging.Logger;
import math.vector.Vector;
import math.vector.Vector3;
import object.AbstractObject;
import object.Bullet;
import object.Drone01;
import random.RandomUtills;
import world.World;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * This is the main on-memory data repository
 */
public class Database implements Closeable {

    protected List<AbstractObject> data = Collections.synchronizedList(new ArrayList<AbstractObject>());
    protected RandomUtills u;
    protected Random random = new Random();
    protected World w;
    protected Logger logger;

    /***
     * The constructor
     * @param u the RandomUtills instance , useful for calculating initial locations
     * @param w the World object
     */
    public Database(RandomUtills u, World w, Logger logger) {
        this.u = u;
        this.w = w;
        this.logger=logger;
    }
    public void genDefaultDatabase(){
        data.clear();
        addDrone();
        addDrone();
        addDrone();
    }




    /**
     * Returns the pure data
     *
     * @return the ArrayList with the objects of the game
     */
    public List<AbstractObject> asList() {
        return data;
    }

    /**
     * Returns the pure data
     *
     * @return the ArrayList with the objects of the game
     */
    public void fromList(List<AbstractObject> obj) {
        data.clear();
        data.addAll(obj);
    }



    /**
     * Adds a drone into the system
     *
     * @param direction the desired direction (0<=x<=360) (bigger or smaller will converted automatically)
     * @param velocity  the objects velocity , pixels per frame
     * @return the newrly created Drone (as AbstractObject)
     */
    public AbstractObject addDrone(double direction, double velocity) {
        Vector3 v = u.getRandomLocation(vector -> w.collisionWithAny(vector));
        AbstractObject o = new Drone01(v, direction, velocity, u);
        asList().add(o);
        w.updatePosition(o, v);
        return o;
    }

    /***
     * Adds a drone into the system , with random direction and velocity
     * @return the newrly created Drone (as AbstractObject)
     */
    public AbstractObject addDrone() {

        return addDrone(random.nextInt(360), ((double) random.nextInt(6)) / 10 + 0.1);
    }

    /**
     * Adds a bullet into the system
     *
     * @param obj            the drone firing the bullet
     * @param bulletPosition the position of the bullet (calculated from physics engine)
     * @return the newrly created bullet
     */
    public AbstractObject newBullet(AbstractObject obj, Vector3 bulletPosition) {
        AbstractObject o = new Bullet(bulletPosition, obj.getDirection(), Constants.bulletVelocity, u);
        asList().add(o);
        w.updatePosition(o, bulletPosition);
        return o;
    }

    /**
     * Deletes the given AbstactObject instance from the memory
     *
     * @param b the abstractObject to be deleted
     */
    public void deleteObject(AbstractObject b) {
        asList().remove(b);
        w.eraseObject(b);
    }

    @Override
    public void close() throws IOException {
        logger.info("Database object terminates itself");
        //TODO save configuration
    }
}
