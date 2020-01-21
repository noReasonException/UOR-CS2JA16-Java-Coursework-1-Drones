
import etc.WindowInfo;
import factories.EngineFactory;
import factories.GuiFactory;
import factories.ResourceLoader;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logging.Logger;

import java.io.FileNotFoundException;


public class GuiMain extends Application {
    /**
     * the main method , launches the application
     * @param args the systems args(not used)
     */
    public static void main(String[] args) {
        launch(args);

    }

    private WindowInfo windowInfo;
    private AbstractEngineFactory engineFactory;
    private AbstractGuiFactory guiFactory;
    private ResourceLoader loader;
    private Logger globalLogger;

    /**
     * Initializes this session's factories ,loggers and resource loaders
     */
    public void initializeFactories() {
        try {


            this.windowInfo = new WindowInfo(50, 50, 50, 500, 500, 720);
            this.loader = ResourceLoader.siglentonInitializer();


            this.guiFactory = new GuiFactory(windowInfo, loader);
            this.engineFactory = guiFactory.getEngineFactory();


            this.globalLogger = this.guiFactory.getLogArea();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Assigns in each Loggable module a the Gui logger
     */
    public void initializeLoggers() {
        this.engineFactory.getPhysicsEngine().setLogger(guiFactory.getLogArea());
        this.engineFactory.getRenderEngine().setLogger(guiFactory.getLogArea());
        this.engineFactory.getWorldMap().setLogger(guiFactory.getLogArea());
        this.guiFactory.getToolArea().setLogger(guiFactory.getLogArea());
        this.guiFactory.getGuiMenu().setLogger(guiFactory.getLogArea());
        this.loader.setLogger(guiFactory.getLogArea());
    }

    /**
     * starts the RenderEngine and the PhysicsEngine
     */
    public void startThreads() {
        engineFactory.getRenderEngine().start();
        engineFactory.getPhysicsEngine().start();
        guiFactory.getGuiThread().start();
    }


    /**
     * The GuiMain main entry point.
     * @param theStage the javafx pre-initialized stage
     */
    @Override
    public void start(Stage theStage) {
        initializeFactories();

        theStage.setTitle("ru020363");

        BorderPane root = new BorderPane();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(500, 500);

        root.setCenter(canvas);


        root.setTop(guiFactory.getGuiMenu());
        root.setLeft(guiFactory.getLogArea());
        root.setBottom(guiFactory.getToolArea());
        root.setRight(guiFactory.getInformationPanel());

        GraphicsContext gc = canvas.getGraphicsContext2D();
        ((EngineFactory) engineFactory).setGc(gc);
        startThreads();


        theScene.setRoot(root);
        theStage.setScene(theScene);


        initializeLoggers();
        theStage.show();


    }
}