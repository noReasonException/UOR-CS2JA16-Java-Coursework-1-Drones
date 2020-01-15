package engines.eventengine;

import engines.eventengine.eventType.EventType;
import engines.physicsengine.Interaction.InteractionType;
import etc.Nothing;
import math.vector.Vector3;
import object.AbstractObject;

import java.util.function.Function;

public class Event {
    //EventService provides theese
    private AbstractObject caller;
    private EventType type;
    private Vector3 move;
    //PhysicsService provides theese
    private InteractionType interactionType;

    private Function<Event, Nothing> noInteractionCallback=new Function<Event, Nothing>() {
        @Override
        public Nothing apply(Event event) {
            return Nothing.sigleton;
        }
    };
    private Function<Event, Nothing> collisionWithDroneCallback=new Function<Event, Nothing>() {
        @Override
        public Nothing apply(Event event) {
            return Nothing.sigleton;
        }
    };
    private Function<Event, Nothing> collisionWithLevelLimitsCallback =new Function<Event, Nothing>() {
        @Override
        public Nothing apply(Event event) {
            return Nothing.sigleton;
        }
    };


    public Event(AbstractObject caller, EventType type, Vector3 move) {
        this.caller = caller;
        this.type = type;
        this.move = move;
    }

    public AbstractObject getCaller() {
        return caller;
    }

    public EventType getType() {
        return type;
    }

    public Vector3 getMove() {
        return move;
    }

    public Event enrichEvent(InteractionType type){
        interactionType=type;
        enrichCallback();
        return this;
    }
    private void enrichCallback(){
        switch (interactionType){
            case NoInteraction :{noInteractionCallback.apply(this);break;}
            case CollisionWithDrone: {collisionWithDroneCallback.apply(this);break;}
            case CollisionWithLevelLimits: { collisionWithLevelLimitsCallback.apply(this);break;}
            default:break;
        }
    }



}
