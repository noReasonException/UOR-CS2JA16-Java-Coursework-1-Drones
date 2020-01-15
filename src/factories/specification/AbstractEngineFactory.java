package factories.specification;

import engines.eventengine.EventEngine;
import engines.physicsengine.PhysicsEngine;
import engines.renderengine.RenderEngine;
import world.World;

abstract public class AbstractEngineFactory {
    protected PhysicsEngine physicsEngine;
    protected EventEngine eventEngine;
    protected RenderEngine renderEngine;

    protected World world;
    protected int sizeX,sizeY;

    public AbstractEngineFactory(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    abstract public PhysicsEngine physicsEngine();

    abstract public EventEngine eventEngine();

    abstract public RenderEngine renderEngine();

    abstract public World world();

    public int getSizeX(){return sizeX;}

    public int getSizeY(){return sizeY;}
}
