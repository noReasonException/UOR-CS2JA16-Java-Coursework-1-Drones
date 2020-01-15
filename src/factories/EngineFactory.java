package factories;

import engines.eventengine.EventEngine;
import engines.physicsengine.PhysicsEngine;
import engines.renderengine.RenderEngine;
import factories.specification.AbstractEngineFactory;
import object.AbstractObject;
import world.World;

import java.util.ArrayList;

public class EngineFactory extends AbstractEngineFactory {

    public EngineFactory(int sizeX,int sizeY) {
        super(sizeX,sizeY);
    }

    @Override
    public PhysicsEngine physicsEngine() {
        return super.physicsEngine==null?super.physicsEngine=new PhysicsEngine(this):super.physicsEngine;
    }

    @Override
    public EventEngine eventEngine() {
        return super.eventEngine==null?super.eventEngine=new EventEngine(this):super.eventEngine;
    }

    @Override
    public RenderEngine renderEngine() {
        return super.renderEngine==null?super.renderEngine=new RenderEngine(this):super.renderEngine;
    }

    @Override
    public World world() {
        return super.world==null?super.world=new World(new ArrayList< AbstractObject >(),getSizeX(),getSizeY()):super.world;
    }
}
