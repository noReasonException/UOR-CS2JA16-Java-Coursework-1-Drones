package object;

import engines.physicsengine.FieldOfView;
import math.vector.Vector3;
import object.AbstractObject;
import random.RandomUtills;

import java.util.List;
import java.util.function.Function;

public class Turret extends AbstractObject {
    public Turret(Vector3 position, double direction, RandomUtills randomUtills) {
        super(position, direction, 0, "turret01-sm", randomUtills);
    }


    @Override
    public Function<FieldOfView, Boolean> collisionEventHandler() {
        return new Function<FieldOfView, Boolean>() {
            @Override
            public Boolean apply(FieldOfView fieldOfView) {
                return false;

            }
        };
    }

    @Override
    public Function<FieldOfView, Boolean> nonCollisionEventHandler() {
        if(Math.abs(rand.nextInt(1000000)) < 1000){
            setDirection(randomUtills.getRandomDirection(any->true));
        }
        return super.nonCollisionEventHandler();
    }
}
