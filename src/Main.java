import math.vector.Vector;
import math.vector.Vector1;
import math.vector.Vector2;
import math.vector.Vector3;
import object.AbstractObject;
import random.RandomUtills;
import world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import object.direction.utils.DirectionUtils;
public class Main {
    public static void main(String[] args) {
        RandomUtills v = new RandomUtills(10,10,10);


        Vector1 b=v.getRandomDirectionVector();
        while (b.getCore().getElement(0)<(Math.PI*2)){
            System.out.println(b);
            b=v.getRandomDirectionVector();
        }

    }
}
