package gui;

import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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

    /**
     * The constructior
     * @param engineFactory the AbstractEngineFactory object , used to manipulate the Database and PhysicsEngine objects
     */
    public ToolArea(AbstractEngineFactory engineFactory) {
        this.engineFactory = engineFactory;


        Button tmp;
        getChildren().add(tmp = new Button("Add Drone"));
        tmp.setOnMouseClicked(addDrone);
        getChildren().add(tmp = new Button("Clear Drones"));
        tmp.setOnMouseClicked(clearDrones);
        getChildren().add(tmp = new Button("Start"));
        tmp.setOnMouseClicked(start);
        getChildren().add(tmp = new Button("Pause"));
        tmp.setOnMouseClicked(pause);
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
     * The 'ClearDrones' button action handler
     * Uses the Database object to clear all the drones and bullets from the system
     */
    private EventHandler<MouseEvent> clearDrones = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.getDatabase().asList().clear();
            engineFactory.getWorldMap().getData().clear();
            logger.info("Drones cleared");
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
            logger.info("Physics Engine Started");
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
            logger.info("Physics Engine Stopped");
        }
    };
}
