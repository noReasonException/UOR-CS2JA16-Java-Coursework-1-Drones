package gui.windows.errors;

import factories.ResourceLoader;
import gui.windows.AbstractInfoWindow;
import javafx.scene.image.Image;

public class ErrorDuringExitWindow extends AbstractInfoWindow {

    public ErrorDuringExitWindow(ResourceLoader loader) {
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
        return "An unexpected error happened during exit \nlog or configuration files may broke as a result";
    }
}
