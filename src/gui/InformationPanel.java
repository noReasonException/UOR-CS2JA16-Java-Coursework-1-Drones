package gui;

import database.Database;
import etc.Updateable;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logging.Logger;
import object.AbstractObject;
import object.Bullet;
import object.Drone01;

import java.io.Closeable;
import java.io.IOException;

/**
 * This is the log area
 * Implements the Logger interface in order to be compatibe with the Engine Modules
 *
 */
public class InformationPanel extends ListView implements Closeable, Updateable {
    private ObservableList<VBox> e = FXCollections.observableArrayList();



    private Database database;
    public InformationPanel(Database database) {
        setItems(e);
        this.database=database;
    }

    /**
     * Generates a log enrtry
     * @return a Hbox to be added to the log list(into the observableList)
     */
    public VBox genEntry(AbstractObject o) {
        VBox main = new VBox();
        HBox v = new HBox();


        v.getChildren().add(new ImageView(o.getRepresentation()));
        v.getChildren().add(new Separator());
        v.getChildren().add(new Label("ID:\t"+o.getId()));
        v.getChildren().add(new Separator());


        main.getChildren().add(v);
        HBox v2 = new HBox();
        v2.getChildren().add(new Label("Position:\t"+o.getPosition().truncate().getCore().toString()));
        v2.getChildren().add(new Separator());
        main.getChildren().add(v2);
        HBox v3 = new HBox();
        v3.getChildren().add(new Label("Direction:\t"+o.getDirection()+"\t"));
        main.getChildren().add(v3);
        HBox v4 = new HBox();
        v4.getChildren().add(new Label("Velocity:\t"+o.getVelocity()+"px/frame\t"));
        main.getChildren().add(v4);
        return main;
    }

    /**
     * This is a little trick to force javafx to re-draw this entity
     * We just resize it a bit in order to trigger the internal private draw methods :)
     */
    public void viewUpdate() {
        this.setHeight(this.getHeight() - 0.01);
        this.setHeight(this.getHeight() + 0.01);
    }

    @Override
    public void update() {
        //getChildren().clear();
        e.clear();
        for(AbstractObject b:database.asList()){
                e.add(genEntry(b));
        }

        //setItems(e);
        //viewUpdate();
    }

    @Override
    public void close() throws IOException {
        System.out.println("INformationPanel terminates itself , logs saved at log.txt");
        //TODO save logs

    }
}
