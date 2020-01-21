package factories.specification;

import database.Database;
import engines.physicsengine.PhysicsEngine;
import engines.renderer.Renderer;
import etc.WindowInfo;
import random.RandomUtills;
import world.World;

/***
 * This is the AbstractEngineFactory
 * takes care of D.I in this project , providing us with every object we want
 */
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

    /**
     * Creates a singleton instance of Database
     * @return a singleton Database Object
     */
    abstract public Database getData();

    /**
     * Creates a singleton instance of PhysicsEngine
     * @return a singleton PhysicsEngine Object
     */
    abstract public PhysicsEngine physicsEngine();
    /**
     * Creates a singleton instance of Rendered
     * @return a singleton Renderer Object
     */
    abstract public Renderer renderEngine();

    /**
     * Creates a singleton instance of World
     * @return a singleton World Object
     */
    abstract public World world();

    /**
     * Creates a singleton instance of RandomUtils
     * @return a singleton RandomUtils Object
     */
    abstract public RandomUtills getRandomUtills();

}
