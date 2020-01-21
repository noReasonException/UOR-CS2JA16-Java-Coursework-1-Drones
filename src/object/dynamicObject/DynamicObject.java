package object.dynamicObject;

import javafx.scene.image.Image;
import math.vector.Vector1;
import math.vector.Vector2;
import math.vector.Vector3;
import object.AbstractObject;
import random.RandomUtills;

public class DynamicObject extends AbstractObject {

    public DynamicObject(Vector3 position, double direction, double velocity, Image representation, RandomUtills randomUtills) {
        super(position, direction, velocity, representation, randomUtills);
    }
}
