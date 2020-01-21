package object;

import factories.ResourceLoader;
import javafx.scene.image.Image;
import math.vector.Vector3;
import random.RandomUtills;

public class Drone01 extends AbstractObject {
    /**
     * The constructor
     * @param position the bullets initial position
     * @param direction the bullets direction
     * @param velocity the bullets velocity
     * @param randomUtills the randomUtills object
     */
    public Drone01(Vector3 position, double direction, double velocity, RandomUtills randomUtills) {
        super(position, direction, velocity, ResourceLoader.siglenton().loadResource("drone01-sm"), randomUtills);
    }
}
