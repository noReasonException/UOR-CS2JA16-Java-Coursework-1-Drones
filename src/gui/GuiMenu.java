package gui;

import factories.ResourceLoader;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import gui.windows.AboutWindow;
import gui.windows.AbstractInfoWindow;
import gui.windows.ErrorDuringExitWindow;
import gui.windows.HelpWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import logging.DefaultLogger;
import logging.Logger;

import java.io.IOException;

/**
 * This is the main menu
 * just a bunch of buttons with their respective handlers
 */
public class GuiMenu extends MenuBar {


    private AbstractGuiFactory guiFactory;
    private ResourceLoader loader;
    private Logger logger = new DefaultLogger();

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public GuiMenu(AbstractGuiFactory guiFactory,ResourceLoader loader) {
        this.guiFactory = guiFactory;
        this.loader=loader;
        getMenus().add(getFileMenu());
        getMenus().add(getSimulationMenu());
        getMenus().add(getConfigurationMenu());
        getMenus().add(getHelpMenu());


    }

    private Menu getFileMenu(){
        Menu b = new Menu("File");
        MenuItem m = new MenuItem("Exit");
        b.getItems().add(m);
        m.setOnAction(e->{
            try {
                guiFactory.close();
            }catch (IOException er){
                new ErrorDuringExitWindow(loader);
            }

        });
        return b;
    }
    private Menu getSimulationMenu(){
        Menu b = new Menu("Simulation");
        b.getItems().add(new MenuItem("Exit"));
        return b;
    }
    private Menu getConfigurationMenu(){
        Menu b = new Menu("Configuration");
        b.getItems().add(new MenuItem("Exit"));
        return b;
    }
    private Menu getHelpMenu(){
        Menu b = new Menu("Help");
        MenuItem about = new MenuItem("About");
        b.getItems().add(about);
        about.setOnAction(e-> {
            new AboutWindow(loader).display();
        });
        MenuItem help = new MenuItem("Help");
        b.getItems().add(help);
        help.setOnAction(e-> {
            new HelpWindow(loader).display();
        });
        return b;
    }


    /**
     * The 'AddDrone' button action handler
     * uses the Database object to create and subscribe a new Drone into the system
     */
    private EventHandler<ActionEvent> addDrone = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };
    /**
     * The 'ClearDrones' button action handler
     * Uses the Database object to clear all the drones and bullets from the system
     */
    private EventHandler<ActionEvent> clearDrones = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };
    /**
     * The 'Start' Button action handler
     * Just starts the physicsEngine AnimationTimer Thread
     */
    private EventHandler<ActionEvent> start = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };

    /**
     * The 'Pause' Button action handler
     * Just stops the physicsEngine AnimationTimer Thread
     */
    private EventHandler<ActionEvent> pause = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };
}
