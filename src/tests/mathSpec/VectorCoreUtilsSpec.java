package tests.mathSpec;

import database.Database;
import etc.WindowInfo;
import factories.GuiFactory;
import factories.ResourceLoader;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import logging.Logger;
import math.utils.VectorCoreUtils;
import math.vector.Vector1;
import math.vector.Vector2;
import tests.etc.EntityInitException;
import tests.etc.Testable;


public class VectorCoreUtilsSpec implements Testable<VectorCoreUtils> {
    Logger logger;

    public VectorCoreUtilsSpec(Logger logger) {
        this.logger = logger;
    }

    /**
     * Generate a new entity
     * @return a newrly created entity
     * @throws EntityInitException in case of any error
     */
    @Override
    public VectorCoreUtils genEntity() throws EntityInitException {
        return new VectorCoreUtils();
    }

    /**
     * Run all tests regarding this entity
     * @return true if all tests has been succeed;
     */
    @Override
    public boolean test() {
        return lengthSpec()&&dotProductSpec();
    }

    /**
     * tests if the length method returns proper results
     * @return true if the test succeeds
     */
    public boolean lengthSpec(){
        Vector2 vector2=new Vector2(5,5);
        return VectorCoreUtils.length(vector2.getCore().getData()) == Math.sqrt(50);
    }

    /**
     * tests if the dot product method returns proper results
     * @return true if the test succeeds
     */
    public boolean dotProductSpec(){
        Vector2 vector21=new Vector2(1,1);
        Vector2 vector22=new Vector2(1,1);
        return VectorCoreUtils.dot(vector21.getCore().getData(),vector22.getCore().getData())==2.0;
    }
}
