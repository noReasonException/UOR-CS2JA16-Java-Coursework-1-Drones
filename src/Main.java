import math.vector.Vector3;
import object.AbstractObject;
import world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        World a=new World();
        AbstractObject n = new AbstractObject(new Vector3(1,2,3));
        a.subscribeObject(n);

        n.setPosition(new Vector3(4,5,6));
        System.out.println(a.getData().get(n.hashCode()).getPosition().toString());

    }
}
