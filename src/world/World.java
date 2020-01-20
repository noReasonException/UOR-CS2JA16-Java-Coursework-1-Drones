package world;
import math.vector.Vector3;
import object.AbstractObject;

import java.util.HashMap;
import java.util.Random;

public class World {
    private HashMap<Vector3, AbstractObject> data ;
    private int cubeX,cubeY,cubeZ,windowX,windowY;
    private Random randint=new Random();

    public HashMap<Vector3, AbstractObject> getData() {
        return data;
    }

    public World(int cubeX, int cubeY,int cubeZ,int windowX,int windowY) {
        this.cubeX = cubeX;
        this.cubeY = cubeY;
        this.cubeZ=cubeZ;
        this.windowX=windowX;
        this.windowY=windowY;
        this.data=new HashMap<>();
    }
    public Vector3 toWorldCoordinates(Vector3 droneRealLocation){
        int worldX = (droneRealLocation.getCore().getElement(0).intValue()/cubeX);
        if(droneRealLocation.getCore().getElement(0).intValue()%cubeX!=0)worldX+=1;
        int worldY = droneRealLocation.getCore().getElement(1).intValue()/cubeY;
        if(droneRealLocation.getCore().getElement(1).intValue()%cubeY!=0)worldY+=1;
        int worldZ = droneRealLocation.getCore().getElement(2).intValue()/cubeZ;
        if(droneRealLocation.getCore().getElement(2).intValue()%cubeZ!=0)worldZ+=1;
        return new Vector3(Integer.valueOf(worldX).doubleValue(),Integer.valueOf(worldY).doubleValue(),Integer.valueOf(worldZ).doubleValue());
    }

    public boolean collision(AbstractObject d, Vector3 location) {
        AbstractObject result = data.get(toWorldCoordinates(location));
        if(     location.getCore().getElement(0)>windowX-randint.nextInt(50) ||
                location.getCore().getElement(1)>windowY-randint.nextInt(50) ||
                location.getCore().getElement(0)<1 ||
                location.getCore().getElement(1)<1||
                location.getCore().getElement(2)<1)return true;
        else if (result == null || result.equals(d)) return false;
        else return true;
    }
    public boolean collision(Vector3 location) {
        AbstractObject result = data.get(toWorldCoordinates(location));
        if(     location.getCore().getElement(0)>windowX-randint.nextInt(50) ||
                location.getCore().getElement(1)>windowY-randint.nextInt(50) ||
                location.getCore().getElement(0)<1 ||
                location.getCore().getElement(1)<1||
                location.getCore().getElement(2)<1)return true;
        else if (result == null) return false;
        else return true;
    }



    public AbstractObject updatePosition(AbstractObject d, Vector3 location) {
        synchronized (this){

            this.data.remove(toWorldCoordinates(location),d);
            this.data.put(toWorldCoordinates(location),d);
            return d.setPosition(location);
        }
    }


}