package engines.physicsengine;

import database.Database;
import etc.Constants;
import javafx.animation.AnimationTimer;
import logging.DefaultLogger;
import logging.Logger;
import math.vector.Vector3;
import object.AbstractObject;
import world.World;


/***
 * This is the Physics engine
 *      in each frame
 *          calculates each objects next position based on the velocity and direction
 *          if there is any collision , calls the nesessary handlers
 *
 */
public class PhysicsEngine extends AnimationTimer {
    private Database dataRef;
    private World world;


    private Logger logger = new DefaultLogger();

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public PhysicsEngine(Database dataRef, World w) {
        this.dataRef = dataRef;
        this.world = w;
    }

    /***
     * calculates the next position of a AbstractObject(Any) out of a given location,direction and velocity
     * @param obj the AbstractObject at position x,y
     * @return the new position (x`,y`)
     */
    public Vector3 nextPosition(AbstractObject obj) {
        return obj.getPosition().add(new Vector3((obj.getVelocity() * Math.cos(Math.toRadians(obj.getDirection()))),
                (obj.getVelocity() * Math.sin(Math.toRadians(obj.getDirection()))), 0));
    }

    /****
     * calculates the initial position of an AbstractObject(Bullet) out of a given location,direction
     * in order to avoid the collision with their mother ship , the initial velocity is very high in order to escape
     * @param firingDrone the motherShip
     * @return the vector containing the initial position of the bullet
     */
    public Vector3 initialBulletPosition(AbstractObject firingDrone) {
        return firingDrone.getPosition().add(new Vector3((Constants.bulletInitialVelocity * Math.cos(Math.toRadians(firingDrone.getDirection()))),
                (Constants.bulletInitialVelocity * Math.sin(Math.toRadians(firingDrone.getDirection()))), 0));
    }

    /***
     * calls as many times is needed the .initialBulletPosition in order to make sure that the bullet is not hitting the mothership
     * @param firingDrone the mothership
     * @return the new vector containing the initial position of the bullet
     */
    public Vector3 nextNBulletPosition(AbstractObject firingDrone) {
        Vector3 v = firingDrone.getPosition();
        for (int i = 0; i < Constants.upper; i++) {
            v = initialBulletPosition(firingDrone);
            if (!world.toWorldCoordinates(v).equals(firingDrone.getPosition())) {
                break;
            }
        }
        return v;
    }


    /***
     * The physics engine main loop
     * @param l the current timestamp(not used)
     * Basic Idea : Each frame the following happens
     *
     *         The engine calculates the next position for each object in the Database object
     *              if in the next move , a collision occurs, both objects are informed through callback handlers
     *              if a drone wants to fire a bullet , the nessesary actions are made
     *              if any object is died during this frame, the engine makes sure to be removed from the memory and inform the World map
     *                      that this object is gone
     */
    @Override
    public void handle(long l) {

        for (int i = 0; i < dataRef.asList().size(); i++) {
            AbstractObject b = dataRef.asList().get(i);
            Vector3 v = nextPosition(b);
            FieldOfView fov = new FieldOfView(v, world, logger, dataRef);
            if (b.isVisible()) {

                if (world.collision(b, v)) {
                    if (b.collisionEventHandler().apply(fov)) {//if true then is dead
                        b.setVisible(false);
                        dataRef.deleteObject(b);

                    }
                } else {
                    world.updatePosition(b, v);
                    b.setPosition(v);
                    if (b.nonCollisionEventHandler().apply(fov)) {//fire bullet
                        Vector3 bp = nextNBulletPosition(b);
                        AbstractObject bull = dataRef.newBullet(b, bp);
                    }
                }
            }
        }
    }
}
