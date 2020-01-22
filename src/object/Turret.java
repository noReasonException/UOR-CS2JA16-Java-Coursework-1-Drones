package object;

import engines.physicsengine.FieldOfView;
import factories.ResourceLoader;
import math.vector.Vector3;
import object.AbstractObject;
import random.RandomUtills;

import java.util.List;
import java.util.function.Function;

public class Turret extends AbstractObject {
    public Turret(Vector3 position, double direction, RandomUtills randomUtills) {
        super(position, direction, 0, ResourceLoader.getTurretResource(), randomUtills);
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
                return false;

            }
        };
    }
    /**
     * this event handler is called every time the object doesnt hit anywhere
     * @return true if this object want to fire a bullet , false otherwise
     */
    @Override
    public Function<FieldOfView, Boolean> nonCollisionEventHandler() {
        if(Math.abs(rand.nextInt(1000000)) < 1000){
            setDirection(randomUtills.getRandomDirection(any->true));
        }
        return new Function<FieldOfView, Boolean>() {
            @Override
            public Boolean apply(FieldOfView fieldOfView) {
                return Math.abs(rand.nextInt(1000000)) < 10000;
            }
        };
    }
}
