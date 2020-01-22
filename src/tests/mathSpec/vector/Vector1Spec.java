package tests.mathSpec.vector;

import logging.Logger;
import math.utils.VectorCoreUtils;
import math.vector.Vector;
import math.vector.Vector1;
import tests.etc.EntityInitException;
import tests.etc.Testable;


public class Vector1Spec implements Testable<Vector1> {
    Logger logger;

    public Vector1Spec(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Vector1 genEntity() throws EntityInitException {
        return new Vector1(1.0);
    }

    @Override
    public boolean test() {
        return magnitudeSpec()&&zeroSpec()&&dimensionSpec()&&addSpec()&&scaleSpec();
    }

    public boolean magnitudeSpec(){
        Vector1 v = new Vector1(1.0);
        return v.magnitude()==1.0;
    }
    public boolean zeroSpec(){
        Vector1 v = new Vector1(1.0);
        return v.zero().getCore().getElement(0)==0.0;
    }
    public boolean dimensionSpec(){
        Vector1 v = new Vector1(1.0);
        return v.dimension()==1;
    }
    public boolean addSpec(){
        Vector1 v = new Vector1(1.0);
        Vector1 v2 = new Vector1(0.0);
        return v.add(v2).getCore().equals(v.getCore());
    }
    public boolean scaleSpec(){
        Vector1 v = new Vector1(1.0);
        return v.scale(0d).getCore().equals(v.zero().getCore());
    }
}