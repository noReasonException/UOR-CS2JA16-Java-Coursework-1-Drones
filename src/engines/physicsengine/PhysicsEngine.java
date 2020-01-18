package engines.physicsengine;

import database.Database;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import math.vector.Vector;
import math.vector.Vector3;
import object.AbstractObject;
import world.World;

import java.math.*;

public class PhysicsEngine extends AnimationTimer {
    private Database<AbstractObject> dataRef;
    private World world;


    public PhysicsEngine(Database<AbstractObject> dataRef,World w) {
        this.dataRef = dataRef;
        this.world=w;
    }

    public Vector3 nextPosition(AbstractObject b){
        Vector3 v = b.getPosition();
        return v.add(new Vector3(b.getVelocity()*Math.sin(Math.toRadians(b.getDirection())),
                b.getVelocity()*Math.cos(Math.toRadians(b.getDirection())),0)).truncate();
    }

    @Override
    public void handle(long l) {
        for (int i = 0; i < dataRef.asList().size(); i++) {
            AbstractObject b = dataRef.asList().get(i);
            Vector3 v = nextPosition(b);
            if(world.collision(b,v)){
                System.out.println("Collision");
                b.collisionEventHandler.apply(v);
            }
            else world.updatePosition(b,v);


        }System.out.println("------------------\n");
    }
}
