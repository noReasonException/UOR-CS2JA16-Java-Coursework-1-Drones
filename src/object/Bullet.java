package object;

import engines.physicsengine.FieldOfView;
import factories.ResourceLoader;
import javafx.scene.image.Image;
import math.vector.Vector3;
import object.dynamicObject.DynamicObject;
import random.RandomUtills;

import java.util.function.Function;

public class Bullet extends DynamicObject {
    public Bullet(Vector3 position, double direction, double velocity, RandomUtills randomUtills) {
        super(position, direction, velocity, ResourceLoader.siglenton().loadResource("bullet-sm"), randomUtills);
    }

    @Override
    public Function<FieldOfView, Boolean> nonCollisionEventHandler() {
        return new Function<FieldOfView, Boolean>() {
            @Override
            public Boolean apply(FieldOfView fieldOfView) {
                return false;
            }
        };
    }

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

