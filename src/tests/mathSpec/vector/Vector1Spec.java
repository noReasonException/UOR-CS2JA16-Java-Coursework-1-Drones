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

    /**
     * Generate a new entity
     * @return a newrly created entity
     * @throws EntityInitException in case of any error
     */
    @Override
    public Vector1 genEntity() throws EntityInitException {
        return new Vector1(1.0);
    }
    /**
     * Run all tests regarding this entity
     * @return true if all tests has been succeed;
     */
    @Override
    public boolean test() {
        return magnitudeSpec()&&zeroSpec()&&dimensionSpec()&&addSpec()&&scaleSpec();
    }

    /**
     * tests if the magniture method returns proper results
     * @return true if the test succeeds
     */
    public boolean magnitudeSpec(){
        Vector1 v = new Vector1(1.0);
        return v.magnitude()==1.0;
    }
    /**
     * tests if the zero method returns proper results
     * @return true if the test succeeds
     */
    public boolean zeroSpec(){
        Vector1 v = new Vector1(1.0);
        return v.zero().getCore().getElement(0)==0.0;
    }
    /**
     * tests if the dimension method returns proper results
     * @return true if the test succeeds
     */
    public boolean dimensionSpec(){
        Vector1 v = new Vector1(1.0);
        return v.dimension()==1;
    }
    /**
     * tests if the addition method returns proper results
     * @return true if the test succeeds
     */
    public boolean addSpec(){
        Vector1 v = new Vector1(1.0);
        Vector1 v2 = new Vector1(0.0);
        return v.add(v2).getCore().equals(v.getCore());
    }
    /**
     * tests if the scale method returns proper results
     * @return true if the test succeeds
     */
    public boolean scaleSpec(){
        Vector1 v = new Vector1(1.0);
        return v.scale(0d).getCore().equals(v.zero().getCore());
    }
}