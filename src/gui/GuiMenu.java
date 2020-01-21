package gui;

import factories.ResourceLoader;
import factories.specification.AbstractGuiFactory;
import gui.windows.*;
import gui.windows.errors.ErrorDuringExitWindow;
import gui.windows.errors.ErrorDuringSaveOfLogs;
import gui.windows.errors.ErrorDuringSimulationSave;
import gui.windows.success.LogsSavedInfoWindow;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import logging.DefaultLogger;
import object.AbstractObject;
import utils.FileSaver;
import logging.Logger;
import utils.Serializer;
import utils.gui.WindowsUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

        save.setOnAction(e->{
            try{
                File path = WindowsUtils.genFileSaveChooser();
                if(path==null)return;
                Serializer.toFile(path.getAbsolutePath(),guiFactory.getEngineFactory().getDatabase().asList(),logger);
            }catch (IOException er){
                new ErrorDuringSimulationSave(loader).display();
                logger.error(er);
            }

        });
        load.setOnAction(e->{
            List<AbstractObject> loaded;
            try{
                File path = WindowsUtils.genFileChooser();
                if(path==null)return;
                loaded = Serializer.fromFile(path.getAbsolutePath(),logger);
                guiFactory.getEngineFactory().getDatabase().asList().clear();
                guiFactory.getEngineFactory().getDatabase().asList().addAll(loaded);
            }catch (IOException|ClassNotFoundException er){
                new ErrorDuringSimulationSave(loader).display();
                logger.error(er);
                er.printStackTrace();
            }
        });
        load_default.setOnAction(e -> {
            guiFactory.getEngineFactory().getDatabase().genDefaultDatabase();
        });
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
            File a = WindowsUtils.genFileSaveChooser();
            if(a==null)return;
            try{
                new LogsSavedInfoWindow(loader,FileSaver.saveToFile(a.getAbsolutePath(),guiFactory.getLogArea().toString())).display();
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
}
