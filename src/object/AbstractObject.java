package object;

import engines.physicsengine.FieldOfView;
import javafx.scene.image.Image;
import math.vector.Vector3;
import random.RandomUtills;
import world.World;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;

/**
 * AbstractObject
 * This class represents any object that can be handled by the RenderEngine
 *
 */
abstract public class AbstractObject  implements Serializable {
    private Vector3 position;
    private double direction;
    private double velocity;
    private String representationResourceName;
    private Random rand = new Random();
    private RandomUtills randomUtills;
    private boolean isVisible = true;
    private int lifes = 10000;

    private boolean hasFired = true;

    private int id;

    /**
     * Makes this object not visible
     * useful if a object has lost its lifes(a.k.a dies)
     * @param visible
     */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    private static int ID = 0;

    /**
     * calculates if is dead
     * @return true if is dead , false otherwise
     */
    private boolean isDead() {
        this.lifes -= 1;
        if (this.lifes <= 0) {
            return true;
        }
        return false;
    }

    /**
     * gets the unique identifier of this object
     * @return an incremental ID of this object
     *
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return true if is dead , false otherwise
     */
    public boolean isVisible() {
        return isVisible;
    }

    /**
     *this event handler is called every time this object is hitting another object
     * @return true if the last hit was resulted in the dead of the drone , false otherwise
     */
    public Function<FieldOfView, Boolean> collisionEventHandler() {
        return new Function<FieldOfView, Boolean>() {
            @Override
            public Boolean apply(FieldOfView fieldOfView) {
                if (isDead()) {
                    fieldOfView.logger.warn("Drone " + id + " is Dead");
                    return true;
                } else {
                    double direction = randomUtills.getRandomDirection(d -> {
                        setDirection(d);
                        return collisionAt(getPosition(), fieldOfView.world, 3) == 3;

                    });
                    setDirection(direction);
                }
                return false;
            }
        };
    }

    /**
     * this event handler is called every time the object doesnt hit anywhere
     * @return true if this object want to fire a bullet , false otherwise
     */
    public Function<FieldOfView, Boolean> nonCollisionEventHandler() {
        return new Function<FieldOfView, Boolean>() {
            @Override
            public Boolean apply(FieldOfView fieldOfView) {
                return Math.abs(rand.nextInt(1000000)) < 10000;
                //return hasFired == true ? !(hasFired = false) : hasFired;
            }
        };
    }

    /**
     * calculates the next position of this object
     * @param v the current position
     * @return
     */
    public Vector3 nextPosition(Vector3 v) {
        return v.add(new Vector3((getVelocity() * Math.cos(Math.toRadians(getDirection()))),
                (getVelocity() * Math.sin(Math.toRadians(getDirection()))), 0));
    }

    /***
     *
     * @param v the current position
     * @param w the world
     * @param upper the uppermost step allowed(preventing inf loops)
     * @return the amount of steps until you hit something , useful for change direction
     */
    public int collisionAt(Vector3 v, World w, int upper) {
        int real = 0;
        for (int i = 0; i < upper; i++) {
            v = nextPosition(v);
            if (!w.collision(this, v)) break;
            ;
            real += 1;
        }
        return real;

    }

    /**
     * The constructor
     *
     * @param position the position of the object
     * @param direction the direction (0<=x<=360)
     * @param velocity the speed at pixels per frame
     * @param representation the image representing this object
     * @param randomUtills the randomUtills object
     */
    public AbstractObject(Vector3 position, double direction, double velocity, String representation, RandomUtills randomUtills) {
        this.position = position;
        this.direction = direction;
        this.representationResourceName = representation;
        this.velocity = velocity;
        this.randomUtills = randomUtills;
        this.id = (ID += 1);
    }

    ///Getters and setters
    public String getRepresentationResourceName() {
        return representationResourceName;
    }

    public double getVelocity() {
        return velocity;
    }


    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void setRepresentationResourceName(String representationResourceName) {
        this.representationResourceName = representationResourceName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractObject that = (AbstractObject) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }
}
