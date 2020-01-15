package gui;

import engines.AbstractEngine;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logging.Logger;

import javax.swing.text.Element;

public class LogArea extends ListView implements Logger {
    private ObservableList<HBox>e = FXCollections.observableArrayList();

    private AbstractEngineFactory engineFactory;
    private AbstractGuiFactory guiFactory;
    public LogArea(AbstractGuiFactory guiFactory, AbstractEngineFactory engineFactory) {
        setItems(e);
        this.guiFactory=guiFactory;
        this.engineFactory=engineFactory;
    }

    public HBox genLogArea(String prefix,String msg){
        HBox v=new HBox();
        v.getChildren().add(new Label(prefix));
        v.getChildren().add(new Separator());
        v.getChildren().add(new Label(msg));
        return v;
    }
    public void update(){
        this.setHeight(this.getHeight()-0.01);
        this.setHeight(this.getHeight()+0.01);
    }
    @Override
    public void warn(String s) {
        e.add(genLogArea("Warn",s));
        update();
    }

    @Override
    public void info(String s) {
        e.add(genLogArea("Info",s));
        update();
    }

    @Override
    public void error(String s) {
        e.add(genLogArea("Error",s));
        update();
    }
    @Override
    public void error(Exception err) {
        e.add(genLogArea("Error",err.getMessage()));
        update();
    }
}
