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
        getChildren().add(new Button("Add Drone"));
        getChildren().add(new Button("Clear Drones"));
        getChildren().add(new Button("Start"));
        getChildren().add(new Button("Pause"));
    }
    private EventHandler<MouseEvent> addDrone=new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent mouseEvent) {

        }
    };
    private EventHandler<MouseEvent> clearDrones=new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent mouseEvent) {

        }
    };
    private EventHandler<MouseEvent> start=new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent mouseEvent) {

        }
    };
    private EventHandler<MouseEvent> pause=new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent mouseEvent) {

        }
    };
}
