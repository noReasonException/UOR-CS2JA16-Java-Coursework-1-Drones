
import factories.EngineFactory;
import factories.GuiFactory;
import factories.ResourceLoader;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import logging.Logger;
import math.vector.Vector3;
import object.AbstractObject;
import world.World;

import java.io.FileNotFoundException;


public class GuiMain extends Application {
    public static void main(String[] args) {
        launch(args);

        /*World w = new World(10,10,10);
        AbstractObject a = new AbstractObject(new Vector3(50,10,1),0,0,null);
        AbstractObject b = new AbstractObject(new Vector3(50,50,1),0,0,null);

        w.updatePosition(b,b.getPosition());
        Vector3 newA,newB;
        for (int i = 0; i < 10; i++) {
            newA=a.getPosition().add(new Vector3(0,10,0));
            //newB=b.getPosition().subtract(new Vector3(0,10,0));
            if(w.collision(a,newA)){
                System.out.println("DONE");
                return;
            }
            else {
                w.updatePosition(a,newA);
               // w.updatePosition(b,newB);
                System.out.println(newA+"\n");
               // System.out.println(newB);
            }
        }*/

    }

    private AbstractEngineFactory engineFactory;
    private AbstractGuiFactory guiFactory;
    private ResourceLoader loader;
    private Logger globalLogger;
    double x=0d,y=0d,angle=0d;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void initializeFactories(){
        try{

            this.engineFactory=new EngineFactory(100,100,100,500,500);
            this.guiFactory=new GuiFactory(engineFactory);

            this.globalLogger=this.guiFactory.getLogArea();
            //this.pulseClock=new Clock();
            this.loader=new ResourceLoader(globalLogger);
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    public void render(){
        engineFactory.renderEngine().start();
        engineFactory.physicsEngine().start();
    }


    @Override
    public void start(Stage theStage) {
        initializeFactories();
        theStage.setTitle( "Timeline Example" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 512, 512 );

        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();
        ((EngineFactory)engineFactory).setGc(gc);
        render();

        engineFactory.getData().asList().add(new AbstractObject(new Vector3(150,150,3),0.1,0.0001,loader.loadResource("drone01-sm")));
        engineFactory.getData().asList().add(new AbstractObject(new Vector3(220,150,3),270,0.1,loader.loadResource("drone01-sm")));
        //engineFactory.getData().asList().add(new AbstractObject(new Vector3(330,150,3),70,0.1,loader.loadResource("droane01-sm")));

        theScene.setRoot(root);
        theStage.setScene(theScene);


        theStage.show();


    }
}