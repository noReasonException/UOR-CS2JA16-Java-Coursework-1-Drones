package gui;

import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import jdk.jfr.Event;

import java.awt.event.ActionEvent;

public class Menu extends HBox {

    private AbstractEngineFactory engineFactory;
    private AbstractGuiFactory guiFactory;

    public Menu(AbstractGuiFactory guiFactory, AbstractEngineFactory engineFactory) {
        this.engineFactory=engineFactory;
        this.guiFactory=guiFactory;


        Button tmp;
        getChildren().add(tmp=new Button("Add Drone"));
        tmp.setOnMouseClicked(addDrone);
        getChildren().add(tmp=new Button("Clear Drones"));
        tmp.setOnMouseClicked(clearDrones);
        getChildren().add(tmp=new Button("Start"));
        tmp.setOnMouseClicked(start);
        getChildren().add(tmp=new Button("Pause"));
        tmp.setOnMouseClicked(pause);


    }
    private EventHandler<MouseEvent> addDrone=new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.getData().addDrone();
            System.out.println("OK");
        }
    };
    private EventHandler<MouseEvent> clearDrones=new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.getData().asList().clear();
            engineFactory.world().getData().clear();
        }
    };
    private EventHandler<MouseEvent> start=new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.physicsEngine().start();
        }
    };
    private EventHandler<MouseEvent> pause=new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent mouseEvent) {
            engineFactory.physicsEngine().stop();
        }
    };
}
