package world;
import math.vector.Vector3;
import object.AbstractObject;

import java.util.HashMap;

public class World {
    private HashMap<Vector3, AbstractObject> data ;
    private int cubeX,cubeY,cubeZ;

    public HashMap<Vector3, AbstractObject> getData() {
        return data;
    }

    public World(int cubeX, int cubeY,int cubeZ) {
        this.cubeX = cubeX;
        this.cubeY = cubeY;
        this.cubeZ=cubeZ;
        this.data=new HashMap<>();
    }
    public Vector3 toWorldCoordinates(Vector3 droneRealLocation){
        int worldX = (droneRealLocation.getCore().getElement(0).intValue()/cubeX);
        if(droneRealLocation.getCore().getElement(0).intValue()%cubeX!=0)worldX+=1;
        int worldY = droneRealLocation.getCore().getElement(1).intValue()/cubeY;
        if(droneRealLocation.getCore().getElement(1)%cubeY!=0)worldY+=1;
        int worldZ = droneRealLocation.getCore().getElement(2).intValue()/cubeZ;
        if(droneRealLocation.getCore().getElement(2)%cubeZ!=0)worldZ+=1;
        return new Vector3(Integer.valueOf(worldX).doubleValue(),Integer.valueOf(worldY).doubleValue(),Integer.valueOf(worldZ).doubleValue());
    }

    public boolean collision(AbstractObject d, Vector3 location) {
        AbstractObject result = data.get(toWorldCoordinates(location));
        if (result == null || result.equals(d)) return false;
        else return true;
    }

    public AbstractObject updatePosition(AbstractObject d, Vector3 location) {
        data.remove(toWorldCoordinates(d.getPosition()));
        data.put(toWorldCoordinates(location),d);
        System.out.println(toWorldCoordinates(location));
        System.out.println(location);
        System.out.println();
        return d.setPosition(location);
    }


}