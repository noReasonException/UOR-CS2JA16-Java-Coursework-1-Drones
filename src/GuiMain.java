
import database.Database;
import engines.physicsengine.PhysicsEngine;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import logging.Logger;
import math.vector.Vector3;
import object.AbstractObject;
import world.World;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class GuiMain extends Application {
    public static void main(String[] args) {
       launch(args);

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


            this.loader=new ResourceLoader(globalLogger);
            this.engineFactory=new EngineFactory(50,50,50,500,500,500,loader);
            this.guiFactory=new GuiFactory(engineFactory);

            this.globalLogger=this.guiFactory.getLogArea();
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
        theStage.setTitle( "ru020363" );

        BorderPane root = new BorderPane();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 500, 500 );

        root.setCenter(canvas);


        root.setRight(guiFactory.getInfoArea());
        root.setLeft(guiFactory.getLogArea());
        root.setBottom(guiFactory.getMenu());

        GraphicsContext gc = canvas.getGraphicsContext2D();
        ((EngineFactory)engineFactory).setGc(gc);
        render();


        theScene.setRoot(root);
        theStage.setScene(theScene);


        theStage.show();


    }
}