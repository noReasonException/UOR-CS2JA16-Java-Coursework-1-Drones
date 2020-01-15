package engines.physicsengine;

import engines.AbstractEngine;
import engines.eventengine.Event;
import engines.physicsengine.Interaction.InteractionType;
import factories.specification.AbstractEngineFactory;
import object.AbstractObject;

import java.util.Stack;

public class PhysicsEngine extends AbstractEngine {

    private Stack<Event> eventStack;
    public PhysicsEngine(AbstractEngineFactory factory) {
        super(factory);
        this.eventStack=new Stack<>();
    }

    public void subscribeEvent(Event e){
        eventStack.add(e);
    }
    private InteractionType applyRules(Event v){
        return InteractionType.NoInteraction;
    }

    @Override
    public void run() {
        while (super.isOperational()){
            try {
                for (Event every:eventStack) {
                    InteractionType t = applyRules(every);
                    Event enrichedEvent = every.enrichEvent(t);
                    factory.world().updateWorld(enrichedEvent);
                    factory.renderEngine().subscribeRichEvent(enrichedEvent);
                }
                wait();
            }catch (InterruptedException e){
                logger.error(e);
            }
        }
    }

}
