package object;

import factories.ResourceLoader;
import javafx.scene.image.Image;
import math.vector.Vector3;
import random.RandomUtills;

public class Drone01 extends AbstractObject {
    public Drone01(Vector3 position, double direction, double velocity, RandomUtills randomUtills) {
        super(position, direction, velocity, ResourceLoader.siglenton().loadResource("drone01-sm"), randomUtills);
    }
}
