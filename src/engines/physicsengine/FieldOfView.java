package engines.physicsengine;

import database.Database;
import logging.Logger;
import math.vector.Vector3;
import world.World;

/***
 * Provides useful information into the AbstractObject's event handlers
 */
public class FieldOfView {
    public Vector3 nextPosition;
    public World world;
    public Logger logger;
    private Database d;

    /**
     * The constructor
     *
     * @param nextPosition the position that this object will go in the next frame
     * @param world        the world object (useful to calculate collisions)
     * @param logger       the logger object
     * @param d            the database object , useful for self-destruct stuff
     */
    public FieldOfView(Vector3 nextPosition, World world, Logger logger, Database d) {
        this.nextPosition = nextPosition;
        this.world = world;
        this.logger = logger;
        this.d = d;
    }
}
