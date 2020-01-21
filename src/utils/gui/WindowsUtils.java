package utils.gui;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;
import java.util.function.Supplier;

public class WindowsUtils{
    public static String genDirectoryChooser(){
        Stage mainStage = new Stage();
        DirectoryChooser fileChooser = new DirectoryChooser();
        fileChooser.setTitle("Select Destination");
        File selectedFile = fileChooser.showDialog(mainStage);
        return selectedFile.getAbsolutePath();
    }
    public static String genFileChooser(){
        Stage mainStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Destination");
        File selectedFile = fileChooser.showSaveDialog(mainStage);
        return selectedFile.getAbsolutePath();
    }
    public static String genSafeFileChooser(){
        return Optional.of(genFileChooser()).orElseGet(()->{return "";});
    }


}
