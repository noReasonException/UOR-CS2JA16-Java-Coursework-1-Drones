package gui;

import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import jdk.jfr.Event;
import logging.DefaultLogger;
import logging.Logger;

import java.awt.event.ActionEvent;

public class Menu extends HBox {

    private AbstractEngineFactory engineFactory;
    private AbstractGuiFactory guiFactory;
    private Logger logger = new DefaultLogger();

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Menu(AbstractGuiFactory guiFactory, AbstractEngineFactory engineFactory) {
        this.engineFactory = engineFactory;
        this.guiFactory = guiFactory;


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

    private EventHandler<MouseEvent> addDrone = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.getData().addDrone();
            logger.info("Drone Added");
        }
    };
    private EventHandler<MouseEvent> clearDrones = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.getData().asList().clear();
            engineFactory.world().getData().clear();
            logger.info("Drones cleared");
        }
    };
    private EventHandler<MouseEvent> start = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.physicsEngine().start();
            logger.info("Physics Engine Started");
        }
    };
    private EventHandler<MouseEvent> pause = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.physicsEngine().stop();
            logger.info("Physics Engine Stopped");
        }
    };
}
