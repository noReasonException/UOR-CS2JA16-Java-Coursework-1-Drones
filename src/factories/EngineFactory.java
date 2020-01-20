package factories;

import database.Database;
import engines.physicsengine.PhysicsEngine;
import engines.renderer.Renderer;
import factories.specification.AbstractEngineFactory;
import javafx.scene.canvas.GraphicsContext;
import object.AbstractObject;
import random.RandomUtills;
import world.World;

public class EngineFactory extends AbstractEngineFactory {

    private GraphicsContext gc;
    private int windowX,windowY,windowZ;
    private ResourceLoader loader;
    public EngineFactory(int gridX, int gridY, int gridZ,int windowX,int windowY,int windowZ,ResourceLoader loader) {
        super(gridX,gridY,gridZ);
        this.windowX=windowX;
        this.windowY=windowY;
        this.windowZ=windowZ;
        this.loader=loader;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public PhysicsEngine physicsEngine() {
        return super.physicsEngine==null?super.physicsEngine=new PhysicsEngine(getData(),world()):super.physicsEngine;
    }

    @Override
    public Renderer renderEngine() {
        return super.renderer==null?super.renderer=new Renderer(getData(),gc,windowX,windowY):super.renderer;
    }

    @Override
    public World world() {
        return super.world==null?super.world=new World(getSizeX(),getSizeY(),getSizeZ(),windowX,windowY):super.world;
    }

    @Override
    public Database getData() {
        return super.data==null?super.data=new Database(getRandomUtills(),world(),getLoader()):super.data;
    }

    @Override
    public RandomUtills getRandomUtills() {return super.randomUtills==null?super.randomUtills=new RandomUtills(windowX,windowY,windowZ):super.randomUtills;}

    public ResourceLoader getLoader() { return loader; }
}
