package object;

import engines.physicsengine.FieldOfView;
import factories.ResourceLoader;
import javafx.scene.image.Image;
import math.vector.Vector3;
import random.RandomUtills;

import java.util.function.Function;

/**
 * This is the implementation of AbstractObject , for the bullet.
 */
public class Bullet extends AbstractObject {
    /**
     * The constructor
     * @param position the bullets initial position
     * @param direction the bullets direction
     * @param velocity the bullets velocity
     * @param randomUtills the randomUtills object
     */
    public Bullet(Vector3 position, double direction, double velocity, RandomUtills randomUtills) {
        super(position, direction, velocity, ResourceLoader.getBulletResource(), randomUtills);
    }


    /**
     * this event handler is called every time the object doesnt hit anywhere
     * @return true if this object want to fire a bullet , false otherwise
     */
    @Override
    public Function<FieldOfView, Boolean> nonCollisionEventHandler() {
        return new Function<FieldOfView, Boolean>() {
            @Override
            public Boolean apply(FieldOfView fieldOfView) {
                return false;
            }
        };
    }
    /**
     *this event handler is called every time this object is hitting another object
     * @return true if the last hit was resulted in the dead of the drone , false otherwise
     */
    @Override
    public Function<FieldOfView, Boolean> collisionEventHandler() {
        return new Function<FieldOfView, Boolean>() {
            @Override
            public Boolean apply(FieldOfView fieldOfView) {
                return true;
            }
        };
    }
}

