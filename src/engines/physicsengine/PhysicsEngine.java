package engines.physicsengine;

import database.Database;
import etc.Nothing;
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
    private Database dataRef;
    private World world;


    public PhysicsEngine(Database dataRef,World w) {
        this.dataRef = dataRef;
        this.world=w;
    }

    @Override
    public void handle(long l) {

        for (int i = 0; i < dataRef.asList().size(); i++) {
            AbstractObject b = dataRef.asList().get(i);
            if(b.isVisible()){
                Vector3 v = b.nextPositionHandler.apply(Nothing.nothing());
                if(world.collision(b,v)){
                    System.out.println("Collision");
                    b.collisionEventHandler.apply(new FieldOfView(v,world));
                }
                else world.updatePosition(b,v);
            }
        }
    }
}
