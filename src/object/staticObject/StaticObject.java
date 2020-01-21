package object.staticObject;

import javafx.scene.image.Image;
import math.vector.Vector1;
import math.vector.Vector2;
import math.vector.Vector3;
import object.AbstractObject;
import random.RandomUtills;

/**
 * This is an implementation of AbstractObject with constant and final velocity of zero
 */
public class StaticObject extends AbstractObject {
    public StaticObject(Vector3 position, double direction, String representation, RandomUtills randomUtills) {
        super(position, direction, 0, representation, randomUtills);
    }

}
