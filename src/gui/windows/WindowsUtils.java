package gui.windows;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class WindowsUtils{
    public static String genFileChooser(){
        Stage mainStage = new Stage();
        DirectoryChooser fileChooser = new DirectoryChooser();
        fileChooser.setTitle("Select Destination");
        File selectedFile = fileChooser.showDialog(mainStage);
        return selectedFile.getAbsolutePath();
    }


}
