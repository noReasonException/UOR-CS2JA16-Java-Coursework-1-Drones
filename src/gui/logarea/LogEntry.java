package gui.logarea;

import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;

public class LogEntry extends HBox {
    private String prefix,msg;


    /**
     * Generates a log enrtry
     * @param prefix the log prefix
     * @param msg the log message
     */
    public LogEntry(String prefix, String msg) {
        this.prefix=prefix;
        this.msg=msg;
        getChildren().add(new Label(prefix));
        getChildren().add(new Separator());
        getChildren().add(new Label(msg));;
    }

    @Override
    public String toString() {
        return prefix+"\t"+msg+"\n";
    }
}
