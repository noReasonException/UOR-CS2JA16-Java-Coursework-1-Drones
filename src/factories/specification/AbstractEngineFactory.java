package factories.specification;

import database.Database;
import engines.physicsengine.PhysicsEngine;
import engines.renderer.Renderer;
import etc.WindowInfo;
import logging.DefaultLogger;
import logging.Logger;
import random.RandomUtills;
import world.World;

import java.io.Closeable;
import java.io.IOException;

/***
 * This is the AbstractEngineFactory
 * takes care of D.I in this project , providing us with every object we want
 */
abstract public class AbstractEngineFactory implements Closeable {
    protected PhysicsEngine physicsEngine;
    protected Renderer renderer;
    protected World world;
    protected Database data;
    protected RandomUtills randomUtills;
    protected WindowInfo windowInfo;
    protected Logger logger;

    public AbstractEngineFactory(WindowInfo windowInfo) {
        this.windowInfo = windowInfo;
    }

    /**
     * Creates a singleton instance of Database
     * @return a singleton Database Object
     */
    abstract public Database getDatabase();

    /**
     * Creates a singleton instance of PhysicsEngine
     * @return a singleton PhysicsEngine Object
     */
    abstract public PhysicsEngine getPhysicsEngine();
    /**
     * Creates a singleton instance of Rendered
     * @return a singleton Renderer Object
     */
    abstract public Renderer getRenderEngine();

    /**
     * Creates a singleton instance of World
     * @return a singleton World Object
     */
    abstract public World getWorldMap();

    /**
     * Creates a singleton instance of RandomUtils
     * @return a singleton RandomUtils Object
     */
    abstract public RandomUtills getRandomUtills();

    public Logger getLogger() { return logger==null?logger=new DefaultLogger():logger; }

    public void setLogger(Logger logger) { this.logger = logger; }

    @Override
    public void close() throws IOException {
        getDatabase().close();
        getPhysicsEngine().close();
        getRenderEngine().close();
        getWorldMap().close();
    }
}
