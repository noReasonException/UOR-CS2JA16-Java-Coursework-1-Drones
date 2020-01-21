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


abstract public class AbstractInfoWindow {



    protected ResourceLoader loader;

    Stage stage=new Stage();

    public AbstractInfoWindow(ResourceLoader loader) {
        this.loader=loader;
    }

    abstract protected Image getLeftImage();
    abstract protected String getTitle();
    abstract protected String getText();

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