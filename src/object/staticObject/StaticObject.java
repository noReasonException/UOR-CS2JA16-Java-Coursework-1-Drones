package object.staticObject;

import javafx.scene.image.Image;
import math.vector.Vector2;
import math.vector.Vector3;
import object.dynamicObject.DynamicObject;

public class StaticObject extends DynamicObject {
    public StaticObject(Vector3 position, Vector2 direction, Image representation) {
        super(position, direction, representation);
    }

}
