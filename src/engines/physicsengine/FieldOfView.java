package engines.physicsengine;

import math.vector.Vector3;
import world.World;

public class FieldOfView {
    public Vector3 nextPosition;
    public World world;

    public FieldOfView(Vector3 nextPosition, World world) {
        this.nextPosition = nextPosition;
        this.world = world;
    }
}
