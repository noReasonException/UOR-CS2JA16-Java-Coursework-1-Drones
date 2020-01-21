package object;

import engines.physicsengine.FieldOfView;
import javafx.scene.image.Image;
import math.vector.Vector3;
import random.RandomUtills;
import world.World;

import java.util.Objects;
import java.util.Random;
import java.util.function.Function;

/**
 *
 */
abstract public class AbstractObject {
    private Vector3 position;
    private double direction;
    private double velocity;
    private Image representation;
    private Random rand = new Random();
    private RandomUtills randomUtills;
    private boolean isVisible = true;
    private int lifes = 10;

    private boolean hasFired = true;

    private int id;

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    private static int ID = 0;

    private boolean isDead() {
        this.lifes -= 1;
        if (this.lifes <= 0) {
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public boolean isVisible() {
        return isVisible;
    }

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

    public Function<FieldOfView, Boolean> nonCollisionEventHandler() {
        return new Function<FieldOfView, Boolean>() {
            @Override
            public Boolean apply(FieldOfView fieldOfView) {
                return Math.abs(rand.nextInt(1000000)) < 10000;
                //return hasFired == true ? !(hasFired = false) : hasFired;
            }
        };
    }

    public Vector3 nextPosition(Vector3 v) {
        return v.add(new Vector3((getVelocity() * Math.cos(Math.toRadians(getDirection()))),
                (getVelocity() * Math.sin(Math.toRadians(getDirection()))), 0));
    }

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

    public AbstractObject(Vector3 position, double direction, double velocity, Image representation, RandomUtills randomUtills) {
        this.position = position;
        this.direction = direction;
        this.representation = representation;
        this.velocity = velocity;
        this.randomUtills = randomUtills;
        this.id = (ID += 1);
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
