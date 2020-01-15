package world;

import engines.eventengine.Event;
import object.AbstractObject;

import java.util.ArrayList;
import java.util.List;

/***
 * This is a simple class representing a 2D World , it plays the role of screen buffer , it doesnt have any knowledge of
 * weird 3D stuff
 */
public class World {

    ArrayList<ArrayList<ArrayList<AbstractObject>>> map;
    private int sizeX;
    private int sizeY;

    public World(List<AbstractObject> obj,int sizeX,int sizeY) {
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        map=genMap(sizeX,sizeY);
    }
    static ArrayList<ArrayList<ArrayList<AbstractObject>>> genMap(int sizeX,int sizeY){
        ArrayList<ArrayList<ArrayList<AbstractObject>>> map=new ArrayList<>();
        for (int i = 0; i < sizeX; i++) {
            map.add(new ArrayList<ArrayList<AbstractObject>>());
            for (int j = 0; j < sizeY; j++) {
                map.get(i).add(new ArrayList<AbstractObject>());
            }
        }
        return map;
    }
    public void updateWorld(Event v){
        //TODO write logic here
    }

}
