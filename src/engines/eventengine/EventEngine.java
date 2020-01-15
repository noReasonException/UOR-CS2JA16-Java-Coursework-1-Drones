package engines.eventengine;

import engines.AbstractEngine;
import engines.physicsengine.PhysicsEngine;
import factories.specification.AbstractEngineFactory;
import object.AbstractObject;
import world.World;

import java.util.ArrayList;
import java.util.Stack;

public class EventEngine extends AbstractEngine {

    private ArrayList<AbstractObject> obj;
    public EventEngine(AbstractEngineFactory factory) {
        super(factory);
        this.obj=new ArrayList<>();
    }

    public void addSubscriber(AbstractObject sub) {
        this.obj.add(sub);
    }

    @Override
    public void run() {
        while (super.isOperational()){
            try {
                for (AbstractObject everyobj:obj) {
                    Event v = everyobj.genEvent(factory.world());
                    factory.physicsEngine().subscribeEvent(v);
                }
                wait();
            }catch (InterruptedException e){
                logger.error(e);
            }
        }
    }
}
