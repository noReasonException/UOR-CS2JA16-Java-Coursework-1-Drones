package factories.specification;

import engines.eventengine.EventEngine;
import engines.physicsengine.PhysicsEngine;
import engines.renderengine.RenderEngine;

abstract public class AbstractEngineFactory {
    protected PhysicsEngine physicsEngine;
    protected EventEngine eventEngine;
    protected RenderEngine renderEngine;

    abstract public PhysicsEngine physicsEngine(AbstractEngineFactory factory);

    abstract public EventEngine eventEngine(AbstractEngineFactory factory);

    abstract public RenderEngine renderEngine(AbstractEngineFactory factory);




}
