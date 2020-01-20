package object;

import engines.physicsengine.FieldOfView;
import etc.Nothing;
import javafx.scene.image.Image;
import math.vector.Vector1;
import math.vector.Vector2;
import math.vector.Vector3;
import random.RandomUtills;
import world.World;

import java.util.Random;
import java.util.function.Function;

public class AbstractObject {
    private Vector3 position;
    private double direction;
    private double velocity;
    private Image   representation;
    private Random rand=new Random();
    private RandomUtills randomUtills;
    private boolean isVisible=true;
    private int lifes=10;


    private boolean isDead() {
        this.lifes-=1;
        if(this.lifes<=0){
            isVisible=false;
            return true;
        }
        return false;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public Function<FieldOfView, Nothing> collisionEventHandler=new Function<FieldOfView, Nothing>() {
        @Override
        public Nothing apply(FieldOfView fieldOfView) {
            if(isDead()){
                fieldOfView.world.getData().remove(getPosition());
            }else{
                double direction = randomUtills.getRandomDirection(d->{
                    setDirection(d);
                    if(collisionAt(getPosition(),fieldOfView.world,10)==10){
                        return true;
                    }
                    else return false;

                });
                setDirection(direction);
            }
            return Nothing.sigleton;
        }
    };
    public Function<Nothing,Vector3> nextPositionHandler=new Function<Nothing, Vector3>() {
        @Override
        public Vector3 apply(Nothing nothing) {
            return nextPosition(getPosition());
        }
    };
    public Vector3 nextPosition(Vector3 v){
        return v.add(new Vector3((getVelocity()*Math.cos(Math.toRadians(getDirection()))),
                (getVelocity()*Math.sin(Math.toRadians(getDirection()))),0));
    }
    public int collisionAt(Vector3 v,World w,int upper){
        int real=0;
        for (int i = 0; i < upper; i++) {
            v=nextPosition(v);
            if(!w.collision(this,v))break;;
            real+=1;
        }
        return real;

    }

    public AbstractObject(Vector3 position, double direction,double velocity,Image representation,RandomUtills randomUtills) {
        this.position = position;
        this.direction = direction;
        this.representation=representation;
        this.velocity=velocity;
        this.randomUtills=randomUtills;
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
