package gui;

import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import gui.logarea.LogEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import logging.Logger;

import java.io.Closeable;
import java.io.IOException;

/**
 * This is the log area
 * Implements the Logger interface in order to be compatibe with the Engine Modules
 *
 */
public class LogArea extends ListView implements Logger , Closeable {
    private ObservableList<LogEntry> e = FXCollections.observableArrayList();

    public LogArea() {
        setItems(e);
    }


    /**
     * This is a little trick to force javafx to re-draw this entity
     * We just resize it a bit in order to trigger the internal private draw methods :)
     */
    public void update() {
        this.setHeight(this.getHeight() - 0.01);
        this.setHeight(this.getHeight() + 0.01);
    }

    /**
     * Generate a warning log entry
     * @param s the log's message
     */
    @Override
    public void warn(String s) {
        e.add(new LogEntry("Warn", s));
        update();
    }

    /**
     * generate a info log entry
     * @param s the log's message
     */
    @Override
    public void info(String s) {
        e.add(new LogEntry("Info", s));
        update();
    }

    /**
     * generate an error log entry
     * @param s the log's message
     */
    @Override
    public void error(String s) {
        e.add(new LogEntry("Error", s));
        update();
    }

    /**
     * an alternative a nice way to catch exceptions with loggers
     * @param err the logs exception cause
     */
    @Override
    public void error(Exception err) {
        e.add(new LogEntry("Error", err.getMessage()));
        update();
    }

    @Override
    public void close() throws IOException {
        System.out.println("LogArea terminates itself , logs saved at log.txt");
        //TODO save logs

    }

    @Override
    public String toString() {
        return e.stream().map(LogEntry::toString).reduce("",(a,b)->a+b);
    }
}
