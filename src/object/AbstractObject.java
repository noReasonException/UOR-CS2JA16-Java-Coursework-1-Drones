package object;

import math.vector.Vector2;
import math.vector.Vector3;

public class AbstractObject {
    private Vector3 position;
    private Vector2 direction;

    public AbstractObject(Vector3 position) {
        this.position = position;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }
}
