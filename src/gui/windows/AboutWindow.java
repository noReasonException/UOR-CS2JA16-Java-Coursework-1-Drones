package gui.windows;

import factories.ResourceLoader;
import javafx.scene.image.Image;

public class AboutWindow extends AbstractInfoWindow {

    public AboutWindow(ResourceLoader loader) {
        super(loader);
    }

    @Override
    protected Image getLeftImage() {
        return super.loader.loadResource("drone01-sm");
    }

    @Override
    protected String getTitle() {
        return "About";
    }

    @Override
    protected String getText() {
        return "\tSpace drones simulation\t\n\tVersion 1.0.0\t\n\tBy Stefanos Stefanou(ru020363)\t\n";
    }
}
