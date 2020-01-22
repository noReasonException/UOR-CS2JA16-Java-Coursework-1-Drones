package gui;

import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import logging.DefaultLogger;
import logging.Logger;


/***
 * This is the main menu
 * just a bunch of buttons with their respective handlers
 */
public class ToolArea extends HBox {

    private AbstractEngineFactory engineFactory;
    private AbstractGuiFactory guiFactory;
    private Logger logger = new DefaultLogger();

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public ToolArea(AbstractGuiFactory guiFactory) {
        this.engineFactory = guiFactory.getEngineFactory();
        this.guiFactory = guiFactory;


        setAlignment(Pos.BOTTOM_CENTER);
        Button tmp;
        getChildren().add(new Separator());
        getChildren().add(tmp = new Button("Add Drone"));
        tmp.setOnMouseClicked(addDrone);
        getChildren().add(new Separator());
        getChildren().add(tmp = new Button("Add Turret"));
        tmp.setOnMouseClicked(addTurret);
        getChildren().add(new Separator());
        getChildren().add(tmp = new Button("Clear Objects"));
        tmp.setOnMouseClicked(clear);
        getChildren().add(new Separator());
        getChildren().add(tmp = new Button("Start"));
        tmp.setOnMouseClicked(start);
        getChildren().add(new Separator());
        getChildren().add(tmp = new Button("Pause"));
        tmp.setOnMouseClicked(pause);
        getChildren().add(new Separator());
    }
    /**
     * The 'AddDrone' button action handler
     * uses the Database object to create and subscribe a new Drone into the system
     */
    private EventHandler<MouseEvent> addDrone = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.getDatabase().addDrone();
            logger.info("Drone Added");
        }
    };
    /**
     * The 'addTurret' button action handler
     * uses the Database object to create and subscribe a new Turret into the system
     */
    private EventHandler<MouseEvent> addTurret = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.getDatabase().addTurret();
            logger.info("Turret Added");
        }
    };
    /**
     * The 'ClearDrones' button action handler
     * Uses the Database object to clear all the drones and bullets from the system
     */
    private EventHandler<MouseEvent> clear = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.getDatabase().clear();
            logger.info("Objects cleared");
        }
    };
    /**
     * The 'Start' Button action handler
     * Just starts the physicsEngine AnimationTimer Thread
     */
    private EventHandler<MouseEvent> start = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.getPhysicsEngine().start();
            guiFactory.getGuiThread().start();
            logger.info("Physics Engine Started");
            logger.info("Information panel thread Stopped");
        }
    };

    /**
     * The 'Pause' Button action handler
     * Just stops the physicsEngine AnimationTimer Thread
     */
    private EventHandler<MouseEvent> pause = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.getPhysicsEngine().stop();
            guiFactory.getGuiThread().stop();
            logger.info("Physics Engine Stopped");
            logger.info("Information panel thread Stopped");
        }
    };
}
