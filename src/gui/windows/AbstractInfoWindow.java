package gui.windows;

import factories.ResourceLoader;
import javafx.geometry.Pos;
        import javafx.scene.*;
        import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * This class represent an generic feedback window , providing useful information to the user
 */
abstract public class AbstractInfoWindow {
    protected ResourceLoader loader;

    Stage stage=new Stage();

    public AbstractInfoWindow(ResourceLoader loader) {
        this.loader=loader;
    }

    /**
     *
     * @return the left image object
     */
    abstract protected Image getLeftImage();

    /**
     *
     * @return the title
     */
    abstract protected String getTitle();

    /**
     *
     * @return the main text
     */
    abstract protected String getText();

    /***
     * Triggers the window
     */
    public void display()
    {

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(getTitle());

        HBox box = new HBox();
        VBox main = new VBox();



        box.getChildren().add(new Separator());
        box.getChildren().add(new ImageView(getLeftImage()));
        box.getChildren().add(new Separator());
        box.getChildren().add(new Label(getText()));
        box.getChildren().add(new Separator());

        main.getChildren().add(new Separator());
        main.getChildren().add(box);
        main.getChildren().add(new Separator());

        Scene scene1= new Scene(main);

        stage.setScene(scene1);

        stage.showAndWait();

    }

}