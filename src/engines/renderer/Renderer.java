package engines.renderer;

import database.Database;
import etc.WindowInfo;
import factories.ResourceLoader;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import logging.DefaultLogger;
import logging.Logger;
import object.AbstractObject;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;


public class Renderer extends AnimationTimer implements Closeable {
    private Database dataRef;
    private GraphicsContext gc;
    private ResourceLoader loader;
    private WindowInfo windowInfo;


    private Logger logger = new DefaultLogger();

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * The constructor
     * @param dataRef a reference of the database object
     * @param gc      the GraphicsContent
     * @param windowInfo the windowInfo object , providing information such as window width,height etc
     */
    public Renderer(Database dataRef, GraphicsContext gc, WindowInfo windowInfo, ResourceLoader loader) {
        this.dataRef = dataRef;
        this.gc = gc;
        this.windowInfo = windowInfo;
        this.loader=loader;
    }

    /**
     * Rotate the whole canvas by specific angle by the points px,py
     * @param gc the graphicsContent
     * @param angle the angle in degrees
     * @param px the pivot point x
     * @param py the pivot point y
     */
    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    /**
     * Draws a given image , rotated by specific angles , though the points tlpx,tlpy
     * @param gc        The GraphicsContent(2D)
     * @param image     The image object
     * @param angle     The angle (0<=x<=360)
     * @param tlpx      the pivot point x
     * @param tlpy      the pivot point y
     */
    private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        rotate(gc, fromJavafxAngleToMathAngle(angle), tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        gc.drawImage(image, tlpx, tlpy);
        gc.restore(); // back to original state (before rotation)
    }

    /**
     * Our engine uses different resting point for 0 degrees , so we need to rotate every image by a constant
     * @param angle the angle , expressed in our engine system
     * @return the angle , expressed in javafx angles
     */
    private double fromJavafxAngleToMathAngle(double angle) {
        return angle + 90;

    }

    /**
     * Clears the canvas , by drawing a big rectangle in the screen
     */
    private void clearCanvas() {
        gc.clearRect(0, 0, windowInfo.getWindowX(), windowInfo.getWindowY());
    }

    /**
     * The main rendrerers mainloop
     * in each frame , we clear the canvas , and draw each object in their respective position , calculated by PhysicsEngine
     * @param l the current timestamp(not used here)
     */
    @Override
    public void handle(long l) {
        clearCanvas();
        Collections.sort(dataRef.asList(), new Comparator<AbstractObject>() {
            @Override
            public int compare(AbstractObject o1, AbstractObject o2) {
                return o1.getPosition().getCore().getElement(2).compareTo(o2.getPosition().getCore().getElement(2));
            }
        });
        for (int i = 0; i < dataRef.asList().size(); i++) {
            AbstractObject every = dataRef.asList().get(i);
            if (every.isVisible()) {
                drawRotatedImage(gc,
                                loader.loadResource(every),
                                every.getDirection(),
                                every.getPosition().getCore().getElement(0),
                                every.getPosition().getCore().getElement(1));
            }

        }

    }

    @Override
    public void close() throws IOException {
        this.logger.info("Renderer Thread terminates itself ");
        this.stop();
    }
}
