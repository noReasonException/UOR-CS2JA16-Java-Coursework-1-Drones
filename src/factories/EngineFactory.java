package factories;

import engines.eventengine.EventEngine;
import engines.physicsengine.PhysicsEngine;
import engines.renderengine.RenderEngine;
import factories.specification.AbstractEngineFactory;

public class EngineFactory extends AbstractEngineFactory {
    @Override
    public PhysicsEngine physicsEngine(AbstractEngineFactory factory) {
        return super.physicsEngine==null?super.physicsEngine=new PhysicsEngine(this):super.physicsEngine;
    }

    @Override
    public EventEngine eventEngine(AbstractEngineFactory factory) {
        return super.eventEngine==null?super.eventEngine=new EventEngine(this):super.eventEngine;
    }

    @Override
    public RenderEngine renderEngine(AbstractEngineFactory factory) {
        return super.renderEngine==null?super.renderEngine=new RenderEngine(this):super.renderEngine;
    }
}
