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

    @Override
    public PhysicsEngine physicsEngine() {
        return super.physicsEngine == null ? super.physicsEngine = new PhysicsEngine(getData(), world()) : super.physicsEngine;
    }

    @Override
    public Renderer renderEngine() {
        return super.renderer == null ? super.renderer = new Renderer(getData(), gc, getWindowInfo()) : super.renderer;
    }

    @Override
    public World world() {
        return super.world == null ? super.world = new World(getWindowInfo()) : super.world;
    }

    @Override
    public Database getData() {
        return super.data == null ? super.data = new Database(getRandomUtills(), world()) : super.data;
    }

    @Override
    public RandomUtills getRandomUtills() {
        return super.randomUtills == null ? super.randomUtills = new RandomUtills(getWindowInfo()) : super.randomUtills;
    }

    public ResourceLoader getLoader() {
        return loader;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public WindowInfo getWindowInfo() {
        return windowInfo;
    }
}
