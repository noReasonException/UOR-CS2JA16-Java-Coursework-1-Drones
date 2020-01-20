package database;

import factories.ResourceLoader;
import javafx.scene.image.Image;
import math.vector.Vector;
import math.vector.Vector3;
import object.AbstractObject;
import random.RandomUtills;
import world.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Database {
    protected List<AbstractObject> data= Collections.synchronizedList(new ArrayList<AbstractObject>());
    protected RandomUtills u ;
    protected Random random=new Random();
    protected World w;
    protected ResourceLoader loader;

    public Database(RandomUtills u, World w,ResourceLoader loader) {
        this.u = u;
        this.w = w;
        this.loader=loader;
    }


    public List<AbstractObject> asList() {
        return data;
    }

    public AbstractObject addDrone(double direction, double velocity, Image representation){
        Vector3 v = u.getRandomLocation(vector->w.collision(vector));
        AbstractObject o =new AbstractObject(v,direction,velocity,representation,u);
        asList().add(o);
        w.updatePosition(o,v);
        return o;
    }
    public AbstractObject addDrone(){
        return addDrone(random.nextInt(360),((double)random.nextInt(10))/10,loader.loadResource("drone01-sm"));
    }
}
