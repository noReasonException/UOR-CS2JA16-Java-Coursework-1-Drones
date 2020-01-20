package object.staticObject;

import javafx.scene.image.Image;
import math.vector.Vector1;
import math.vector.Vector2;
import math.vector.Vector3;
import object.dynamicObject.DynamicObject;
import random.RandomUtills;

public class StaticObject extends DynamicObject {
    public StaticObject(Vector3 position, double direction, Image representation, RandomUtills randomUtills) {
        super(position, direction, 0,representation,randomUtills);
    }

}
