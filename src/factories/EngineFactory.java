package factories;

import database.Database;
import engines.physicsengine.PhysicsEngine;
import engines.renderer.Renderer;
import etc.WindowInfo;
import factories.specification.AbstractEngineFactory;
import javafx.scene.canvas.GraphicsContext;
import object.AbstractObject;
import random.RandomUtills;
import world.World;

import java.awt.*;

public class EngineFactory extends AbstractEngineFactory {

    private GraphicsContext gc;
    private ResourceLoader loader;

    public EngineFactory(WindowInfo info, ResourceLoader loader) {
        super(info);
        this.loader = loader;
    }


    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    /**
     * Creates a singleton instance of PhysicsEngine
     * @return a singleton PhysicsEngine Object
     */
    @Override
    public PhysicsEngine physicsEngine() {
        return super.physicsEngine == null ? super.physicsEngine = new PhysicsEngine(getData(), world()) : super.physicsEngine;
    }
    /**
     * Creates a singleton instance of Renderer
     * @return a singleton Renderer Object
     */
    @Override
    public Renderer renderEngine() {
        return super.renderer == null ? super.renderer = new Renderer(getData(), gc, getWindowInfo()) : super.renderer;
    }
    /**
     * Creates a singleton instance of World
     * @return a singleton World Object
     */
    @Override
    public World world() {
        return super.world == null ? super.world = new World(getWindowInfo()) : super.world;
    }
    /**
     * Creates a singleton instance of Database
     * @return a singleton Database Object
     */
    @Override
    public Database getData() {
        return super.data == null ? super.data = new Database(getRandomUtills(), world()) : super.data;
    }
    /**
     * Creates a singleton instance of RandomUtills
     * @return a singleton RandomUtills Object
     */
    @Override
    public RandomUtills getRandomUtills() {
        return super.randomUtills == null ? super.randomUtills = new RandomUtills(getWindowInfo()) : super.randomUtills;
    }
    /**
     * Creates a singleton instance of ResourceLoader
     * @return a singleton ResourceLoader Object
     */
    public ResourceLoader getLoader() {
        return loader;
    }
    /**
     * Creates a singleton instance of GraphicsContext
     * @return a singleton GraphicsContext Object
     */
    public GraphicsContext getGc() {
        return gc;
    }
    /**
     * Creates a singleton instance of WindowInfo
     * @return a singleton WindowInfo Object
     */
    public WindowInfo getWindowInfo() {
        return windowInfo;
    }
}
