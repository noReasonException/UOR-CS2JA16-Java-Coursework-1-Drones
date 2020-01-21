package gui.windows.errors;

import factories.ResourceLoader;
import gui.windows.AbstractInfoWindow;
import javafx.scene.image.Image;

public class ErrorDuringSimulationSave extends AbstractInfoWindow {
    public ErrorDuringSimulationSave(ResourceLoader loader) {
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
        return "An unexpected error happened during simulation saving\\n saved simulation file may broke as a result";
    }
}
