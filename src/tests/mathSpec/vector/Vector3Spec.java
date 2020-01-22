package tests.mathSpec.vector;

import logging.Logger;
import math.vector.Vector2;
import math.vector.Vector3;
import tests.etc.EntityInitException;
import tests.etc.Testable;

public class Vector3Spec implements Testable<Vector3> {
    Logger logger;

    public Vector3Spec(Logger logger) {
        this.logger = logger;
    }

    /**
     * Generate a new entity
     * @return a newrly created entity
     * @throws EntityInitException in case of any error
     */
    @Override
    public Vector3 genEntity() throws EntityInitException {
        return new Vector3(1.0,1.0,1.0);
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
        Vector3 v = new Vector3(2.0,1.0,3.0);
        return v.magnitude()==Math.sqrt(14);
    }
    /**
     * tests if the zero method returns proper results
     * @return true if the test succeeds
     */
    public boolean zeroSpec(){
        Vector3 v = new Vector3(1.0,1.0,1.0);
        return v.zero().getCore().getElement(0)==0.0&&v.zero().getCore().getElement(1)==0.0&&v.zero().getCore().getElement(2)==0.0;
    }
    /**
     * tests if the dimension method returns proper results
     * @return true if the test succeeds
     */
    public boolean dimensionSpec(){
        Vector3 v = new Vector3(1.0,1.0,1.0);
        return v.dimension()==3;
    }
    /**
     * tests if the addition method returns proper results
     * @return true if the test succeeds
     */
    public boolean addSpec(){
        Vector3 v = new Vector3(1.0,1.0,1.0);
        Vector3 v2 = new Vector3(0.0,0.0,0.0);
        return v.add(v2).getCore().equals(v.getCore());
    }
    /**
     * tests if the scale method returns proper results
     * @return true if the test succeeds
     */
    public boolean scaleSpec(){
        Vector3 v = new Vector3(1.0,1.0,1.0);
        return v.scale(0d).getCore().equals(v.zero().getCore());
    }
}