package factories.specification;

import database.Database;
import engines.physicsengine.PhysicsEngine;
import engines.renderer.Renderer;
import etc.WindowInfo;
import object.AbstractObject;
import random.RandomUtills;
import world.World;

abstract public class AbstractEngineFactory {
    protected PhysicsEngine physicsEngine;
    protected Renderer renderer;
    protected World world;
    protected Database data;
    protected RandomUtills randomUtills;
    protected WindowInfo windowInfo;

    public AbstractEngineFactory(WindowInfo windowInfo) {
        this.windowInfo = windowInfo;
    }

    abstract public Database getData();

    abstract public PhysicsEngine physicsEngine();

    abstract public Renderer renderEngine();

    abstract public World world();

    abstract public RandomUtills getRandomUtills();

}
