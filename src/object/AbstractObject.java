package object;

import etc.Nothing;
import javafx.scene.image.Image;
import math.vector.Vector1;
import math.vector.Vector2;
import math.vector.Vector3;
import world.World;

import java.util.function.Function;

public class AbstractObject {
    private Vector3 position;
    private double direction;
    private double velocity;
    private Image   representation;


    public Function<Vector3, Nothing> collisionEventHandler=new Function<Vector3, Nothing>() {
        @Override
        public Nothing apply(Vector3 vector3) {
            setDirection(direction-1);
            return Nothing.sigleton;
        }
    };


    public AbstractObject(Vector3 position, double direction,double velocity,Image representation) {
        this.position = position;
        this.direction = direction;
        this.representation=representation;
        this.velocity=velocity;
    }

    public Image getRepresentation() {
        return representation;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void setRepresentation(Image representation) {
        this.representation = representation;
    }

    public Vector3 getPosition() {
        return position;
    }

    public AbstractObject setPosition(Vector3 position) {
        this.position = position;
        return this;
    }

    public double getDirection() {
        return direction;

    }
    public void setDirection(double direction) {
        this.direction = direction;
    }
}
