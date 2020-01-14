import math.vector.Vector;
import math.vector.Vector2;
import math.vector.Vector3;
import object.AbstractObject;
import world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import object.direction.utils.DirectionUtils;
public class Main {
    public static void main(String[] args) {
        Vector2 v = new Vector2(1,-1);

        System.out.println(DirectionUtils.directionToRadians(v));

    }
}
