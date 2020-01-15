package engines.renderengine;

import engines.AbstractEngine;
import factories.specification.AbstractEngineFactory;
import javafx.scene.canvas.Canvas;
import object.AbstractObject;

import java.util.HashMap;

public class RenderEngine extends AbstractEngine {
    private Canvas canvas;
    private HashMap<Integer, AbstractObject> data;
    public RenderEngine(AbstractEngineFactory factory, Canvas canvas) {
        super(factory);
        this.canvas=canvas;
        this.data=new HashMap<>();
    }

    void xAxisChangedEvent(){

    }
    void yAxisChangedEvent(){

    }
    void zAxisChangedEvent(){

    }
    void rotationChangedEvent(){

    }



    @Override
    public void run() {
        //data.forEach((key,value)->);
    }
}
