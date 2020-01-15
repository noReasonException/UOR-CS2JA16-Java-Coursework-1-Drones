package object.dynamicObject;

import javafx.scene.image.Image;
import math.vector.Vector2;
import math.vector.Vector3;
import object.AbstractObject;

public class DynamicObject extends AbstractObject {

    public DynamicObject(Vector3 position, Vector2 direction, Image representation) {
        super(position, direction, representation);
    }
}
