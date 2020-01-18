package engines.renderer;

import database.Database;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import object.AbstractObject;

public class Renderer extends AnimationTimer {
    private Database<AbstractObject> dataRef;
    private GraphicsContext gc;
    private int windowSizeX,windowSizeY;


    public Renderer(Database<AbstractObject> dataRef, GraphicsContext gc,int windowSizeX,int windowSizeY) {
        this.dataRef = dataRef;
        this.gc=gc;
        this.windowSizeX=windowSizeX;
        this.windowSizeY=windowSizeY;
    }
    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }
    private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        gc.drawImage(image, tlpx, tlpy);
        gc.restore(); // back to original state (before rotation)
    }
    private void clearCanvas(){
        gc.clearRect(0, 0, windowSizeX, windowSizeY);
    }

    @Override
    public void handle(long l) {
        clearCanvas();
        for (AbstractObject every : dataRef.asList()) {
            drawRotatedImage(gc,every.getRepresentation(),every.getDirection(),every.getPosition().getCore().getElement(0),every.getPosition().getCore().getElement(1));
        }
    }
}
