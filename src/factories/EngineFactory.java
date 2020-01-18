package factories;

import database.Database;
import engines.physicsengine.PhysicsEngine;
import engines.renderer.Renderer;
import factories.specification.AbstractEngineFactory;
import javafx.scene.canvas.GraphicsContext;
import object.AbstractObject;
import world.World;

public class EngineFactory extends AbstractEngineFactory {

    private GraphicsContext gc;
    private int windowX,windowY;
    public EngineFactory(int gridX, int gridY, int gridZ,int windowX,int windowY) {
        super(gridX,gridY,gridZ);
        this.windowX=windowX;
        this.windowY=windowY;
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
        return super.world==null?super.world=new World(getSizeX(),getSizeY(),getSizeZ()):super.world;
    }

    @Override
    public Database<AbstractObject> getData() {
        return super.data==null?super.data=new Database<>():super.data;
    }
}
