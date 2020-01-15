
import factories.EngineFactory;
import factories.GuiFactory;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import gui.LogArea;
import gui.Menu;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GuiMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private AbstractEngineFactory engineFactory;
    private AbstractGuiFactory guiFactory;

    public void initializeFactories(){
        this.engineFactory=new EngineFactory();
        this.guiFactory=new GuiFactory(engineFactory);
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
        root.setLeft(a);
        a.error(new IllegalArgumentException("invalid"));

        primaryStage.setScene(new Scene(root, 800, 650));
        primaryStage.show();
    }
}