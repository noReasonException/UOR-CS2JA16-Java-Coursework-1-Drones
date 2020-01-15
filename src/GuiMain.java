
import clock.Clock;
import factories.EngineFactory;
import factories.GuiFactory;
import factories.ResourceLoader;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import gui.LogArea;
import gui.Menu;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logging.Logger;

import java.io.FileNotFoundException;


public class GuiMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private AbstractEngineFactory engineFactory;
    private AbstractGuiFactory guiFactory;
    private ResourceLoader loader;
    private Clock   pulseClock;
    private Logger globalLogger;

    public void initializeFactories(){
        try{

            this.engineFactory=new EngineFactory(100,100);
            this.guiFactory=new GuiFactory(engineFactory);
            this.globalLogger=this.guiFactory.getLogArea();
            //this.pulseClock=new Clock();
            this.loader=new ResourceLoader(globalLogger);
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void start(Stage primaryStage) {
        initializeFactories();
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        BorderPane root = new BorderPane();
        root.setBottom(guiFactory.getMenu());
        LogArea a = guiFactory.getLogArea();
        ImageView v = loader.loadResourceView("drone10");
        root.setLeft(a);
        root.setCenter(v);

        primaryStage.setScene(new Scene(root, 800, 650));
        primaryStage.show();
    }
}