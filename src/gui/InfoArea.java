package gui;

import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import object.AbstractObject;

import javafx.scene.image.ImageView;
import java.awt.*;

public class InfoArea extends VBox {
    private AbstractEngineFactory engineFactory;
    private AbstractGuiFactory guiFactory;


    public InfoArea(AbstractGuiFactory guiFactory, AbstractEngineFactory engineFactory) {
        this.guiFactory=guiFactory;
        this.engineFactory=engineFactory;
        subscribe();
    }

    protected HBox genObjectCard(AbstractObject object){
        HBox box = new HBox();
        box.getChildren().add(new ImageView(object.getRepresentation()));
        box.getChildren().add(new Label(object.toString()));
        box.getChildren().add(new Label(object.getPosition().toString()));
        box.getChildren().add(new Label(object.getDirection().toString()));

        return box;

    }

    public void subscribe(AbstractObject object){
        getChildren().add(genObjectCard(object));
    }
    public void update(){
        setHeight(getHeight()-0.01);
        setHeight(getHeight()+0.01);

    }

}
