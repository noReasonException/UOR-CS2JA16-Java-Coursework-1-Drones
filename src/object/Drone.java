package object;

import engines.physicsengine.FieldOfView;
import factories.ResourceLoader;
import math.vector.Vector3;
import random.RandomUtills;

import java.util.function.Function;

public class Drone extends AbstractObject {
    /**
     * The constructor
     * @param position the bullets initial position
     * @param direction the bullets direction
     * @param velocity the bullets velocity
     * @param randomUtills the randomUtills object
     */
    public Drone(Vector3 position, double direction, double velocity, RandomUtills randomUtills) {
        super(position, direction, velocity, ResourceLoader.siglenton().getRandomDroneResource(), randomUtills);
    }
    /**
     *this event handler is called every time this object is hitting another object
     * @return true if the last hit was resulted in the dead of the drone , false otherwise
     */
    public Function<FieldOfView, Boolean> collisionEventHandler() {
        return new Function<FieldOfView, Boolean>() {
            @Override
            public Boolean apply(FieldOfView fieldOfView) {
                if (isDead()) {
                    fieldOfView.logger.warn("Drone " + getId() + " is Dead");
                    return true;
                } else {
                    double direction = randomUtills.getRandomDirection(d -> {
                        setDirection(d);
                        return collisionAt(getPosition(), fieldOfView.world, 3) == 3;

                    });
                    setDirection(direction);
                }
                return false;
            }
        };
    }

    /**
     * this event handler is called every time the object doesnt hit anywhere
     * @return true if this object want to fire a bullet , false otherwise
     */
    public Function<FieldOfView, Boolean> nonCollisionEventHandler() {
        return new Function<FieldOfView, Boolean>() {
            @Override
            public Boolean apply(FieldOfView fieldOfView) {
                return Math.abs(rand.nextInt(1000000)) < 10000;
                //return hasFired == true ? !(hasFired = false) : hasFired;
            }
        };
    }

}
