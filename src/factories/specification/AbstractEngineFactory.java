package factories.specification;

import database.Database;
import engines.physicsengine.PhysicsEngine;
import engines.renderer.Renderer;
import object.AbstractObject;
import random.RandomUtills;
import world.World;

abstract public class AbstractEngineFactory {
    protected PhysicsEngine physicsEngine;
    protected Renderer renderer;
    protected World world;
    protected Database data;
    protected RandomUtills randomUtills;

    protected int sizeX,sizeY,sizeZ;

    public AbstractEngineFactory(int sizeX, int sizeY, int sizeZ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
    }

    abstract public Database getData();

    abstract public PhysicsEngine physicsEngine();

    abstract public Renderer renderEngine();

    abstract public World world();

    abstract public RandomUtills getRandomUtills();

    public int getSizeX(){return sizeX;}

    public int getSizeY(){return sizeY;}

    public int getSizeZ() { return sizeZ; }
}
