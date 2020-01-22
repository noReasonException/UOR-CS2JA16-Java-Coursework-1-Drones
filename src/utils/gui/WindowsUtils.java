package utils.gui;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * A bunch of useful tools for choosing files
 */
public class WindowsUtils{
    /**
     * creates a directoryChooser , it initializes it , and returns the selection of the user
     * @return the selected directory of the user
     */
    public static String genDirectoryChooser(){
        Stage mainStage = new Stage();
        DirectoryChooser fileChooser = new DirectoryChooser();
        fileChooser.setTitle("Select Destination");
        File selectedFile = fileChooser.showDialog(mainStage);
        return selectedFile.getAbsolutePath();
    }
    /**
     * creates a FileChooser , it initializes it with saveDialog
     * and returns the selection of the user
     * @return the selected file of the user
     */
    public static File genFileSaveChooser(){
        Stage mainStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Destination");
        File selectedFile = fileChooser.showSaveDialog(mainStage);

        return selectedFile;
    }
    /**
     * creates a FileChooser , it initializes it with openDialog
     * and returns the selection of the user
     * @return the selected file of the user
     */
    public static File genFileChooser(){
        Stage mainStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Destination");
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        return selectedFile;
    }

}
