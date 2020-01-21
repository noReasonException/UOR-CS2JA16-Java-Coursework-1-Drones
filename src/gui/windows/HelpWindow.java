package gui.windows;

import factories.ResourceLoader;
import javafx.scene.image.Image;

public class HelpWindow extends AbstractInfoWindow {

    public HelpWindow(ResourceLoader loader) {
        super(loader);
    }

    @Override
    protected Image getLeftImage() {
        return super.loader.loadResource("drone01-sm");
    }

    @Override
    protected String getTitle() {
        return "Help";
    }

    @Override
    protected String getText() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \n" +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure\n" +
                " dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                " proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
    }
}
