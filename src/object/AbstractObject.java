package object;

import engines.eventengine.Event;
import engines.eventengine.eventType.EventType;
import javafx.scene.image.Image;
import math.vector.Vector2;
import math.vector.Vector3;
import world.World;

public class AbstractObject {
    private Vector3 position;
    private Vector2 direction;
    private Image   representation;


    public AbstractObject(Vector3 position, Vector2 direction,Image representation) {
        this.position = position;
        this.direction = direction;
        this.representation=representation;
    }

    public Image getRepresentation() {
        return representation;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Vector2 getDirection() {
        return direction;

    }
    public Event genEvent(World world) {
        return new Event(this, EventType.NoEvent,new Vector3(0,0,0));
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }
}
