package gui.windows.success;

import factories.ResourceLoader;
import gui.windows.AbstractInfoWindow;
import javafx.scene.image.Image;

public class LogsSavedInfoWindow extends AbstractInfoWindow {

    private String filepath;
    public LogsSavedInfoWindow(ResourceLoader loader,String filepath) {

        super(loader);
        this.filepath=filepath;
    }

    @Override
    protected Image getLeftImage() {
        return super.loader.loadResource("drone01-sm");
    }

    @Override
    protected String getTitle() {
        return "Success";
    }

    @Override
    protected String getText() {
        return "The contents of logpanel has been saved into "+filepath;
    }
}
