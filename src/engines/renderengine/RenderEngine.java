package engines.renderengine;

import engines.AbstractEngine;
import engines.eventengine.Event;
import engines.physicsengine.Interaction.InteractionType;
import factories.specification.AbstractEngineFactory;
import javafx.scene.canvas.Canvas;
import logging.Logger;
import object.AbstractObject;

import java.util.HashMap;
import java.util.Stack;

public class RenderEngine extends AbstractEngine {
    private Canvas canvas;
    private Stack<Event> events;
    public RenderEngine(AbstractEngineFactory factory) {
        super(factory);
        this.events=new Stack<>();

    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
    public void subscribeRichEvent(Event v){
        events.add(v);

    }

    void draw(Event v){

    }
    @Override
    public void run() {
        while (super.isOperational()){
            try {
                for (Event every:events) {
                    draw(every);
                }
                wait();
            }catch (InterruptedException e){
                logger.error(e);
            }
        }
    }
}
