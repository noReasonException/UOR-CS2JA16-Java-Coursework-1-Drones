package tests.mathSpec.vector;

import logging.Logger;
import math.vector.Vector1;
import math.vector.Vector2;
import tests.etc.EntityInitException;
import tests.etc.Testable;

public class Vector2Spec implements Testable<Vector2> {
    Logger logger;

    public Vector2Spec(Logger logger) {
        this.logger = logger;
    }

    /**
     * Generate a new entity
     * @return a newrly created entity
     * @throws EntityInitException in case of any error
     */
    @Override
    public Vector2 genEntity() throws EntityInitException {
        return new Vector2(1.0,1.0);
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
        Vector2 v = new Vector2(2.0,1.0);
        return v.magnitude()==Math.sqrt(5);
    }
    /**
     * tests if the zero method returns proper results
     * @return true if the test succeeds
     */
    public boolean zeroSpec(){
        Vector2 v = new Vector2(1.0,1.0);
        return v.zero().getCore().getElement(0)==0.0&&v.zero().getCore().getElement(1)==0.0;
    }
    /**
     * tests if the dimension method returns proper results
     * @return true if the test succeeds
     */
    public boolean dimensionSpec(){
        Vector2 v = new Vector2(1.0,1.0);
        return v.dimension()==2;
    }
    /**
     * tests if the addition method returns proper results
     * @return true if the test succeeds
     */
    public boolean addSpec(){
        Vector2 v = new Vector2(1.0,1.0);
        Vector2 v2 = new Vector2(0.0,0.0);
        return v.add(v2).getCore().equals(v.getCore());
    }
    /**
     * tests if the scale method returns proper results
     * @return true if the test succeeds
     */
    public boolean scaleSpec(){
        Vector2 v = new Vector2(1.0,1.0);
        return v.scale(0d).getCore().equals(v.zero().getCore());
    }
}