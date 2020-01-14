package world;

import object.AbstractObject;

import java.util.HashMap;
import java.util.Map;

/***
 * This is a simple class representing a 2D World , it plays the role of screen buffer , it doesnt have any knowledge of
 * weird 3D stuff
 */
public class World {
    Map<Integer, AbstractObject> data = new HashMap<>();

    public World subscribeObject(AbstractObject a){data.put(a.hashCode(),a);return this;}

    public Map<Integer, AbstractObject> getData() {
        return data;
    }
}
