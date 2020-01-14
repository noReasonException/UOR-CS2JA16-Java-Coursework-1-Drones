package object;

import math.vector.Vector3;

public class AbstractObject {
    private Vector3 position;

    public AbstractObject(Vector3 position) {
        this.position = position;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }
}
