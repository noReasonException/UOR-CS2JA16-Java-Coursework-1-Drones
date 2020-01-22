package gui.windows.errors;

import factories.ResourceLoader;
import gui.windows.AbstractInfoWindow;
import javafx.scene.image.Image;

/***
 * An error displayed in case of any error during the save of logs procedure
 */
public class ErrorDuringSaveOfLogs extends AbstractInfoWindow {
    public ErrorDuringSaveOfLogs(ResourceLoader loader) {
        super(loader);
    }

    @Override
    protected Image getLeftImage() {
        return super.loader.loadResource("drone01-sm");
    }

    @Override
    protected String getTitle() {
        return "Error";
    }

    @Override
    protected String getText() {
        return "An unexpected error happened during log save \nlog file may broke as a result";
    }
}
