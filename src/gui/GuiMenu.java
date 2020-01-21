package gui;

import factories.ResourceLoader;
import factories.specification.AbstractGuiFactory;
import gui.windows.*;
import gui.windows.errors.ErrorDuringExitWindow;
import gui.windows.errors.ErrorDuringSaveOfLogs;
import gui.windows.success.LogsSavedInfoWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import logging.DefaultLogger;
import logging.FileSaver;
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
        getMenus().add(getLogMenu());
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

        MenuItem save = new MenuItem("Save");
        MenuItem load = new MenuItem("Load");
        MenuItem load_default = new MenuItem("Load Default");

        b.getItems().add(save);
        b.getItems().add(load);
        b.getItems().add(load_default);
        return b;
    }
    private Menu getConfigurationMenu(){
        Menu b = new Menu("Configuration");
        MenuItem edit_default = new MenuItem("Edit Default");
        MenuItem editor = new MenuItem("Editor");
        b.getItems().add(edit_default);
        b.getItems().add(editor);
        return b;
    }

    private Menu getLogMenu(){
        Menu b = new Menu("Logs");
        MenuItem save_logs = new MenuItem("Save Logs");
        MenuItem clear_logs = new MenuItem("Clear Logs");
        b.getItems().add(save_logs);
        b.getItems().add(clear_logs);
        clear_logs.setOnAction(e->guiFactory.getLogArea().getItems().clear());
        save_logs.setOnAction(e->{
            String a = WindowsUtils.genFileChooser();
            try{
                new LogsSavedInfoWindow(loader,FileSaver.saveToFile(a,guiFactory.getLogArea().toString())).display();
            }catch (IOException er){
                new ErrorDuringSaveOfLogs(loader).display();
            }

        });

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
