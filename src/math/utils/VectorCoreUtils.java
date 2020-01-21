package math.utils;

import math.vector.VectorCore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***
 * VectorCoreUtils
 * contains various useful tools for manipulating a vectorCore
 * @see VectorCore for more details
 */
public class VectorCoreUtils {

    /**
     * Generates a zero vector of same size , as the parameter given
     * @param core the given vector
     * @return a zero vector
     */
    static VectorCore zeroVector(VectorCore core) {
        return new VectorCore(core.getData().stream().map(i -> 0d).collect(Collectors.toList()), core.getDimension());
    }

    /**
     * The absolute distance between the origin and the points given as parameters
     * @param list the points of any vector
     * @return the euclidean distance
     */
    static public double length(List<Double> list) {
        return Math.sqrt(list.stream().map(i -> i * i).reduce(0d, (a, b) -> a + b));
    }

    /**
     * The dot product of two vectors of arbitary size , given as list of points
     * @param lista the first vector's points
     * @param listb the second vector's points
     * @return
     */
    static public double dot(List<Double> lista, List<Double> listb) {
        double curr = 0;
        for (int i = 0; i < lista.size(); i++) {
            curr += lista.get(i) * listb.get(i);
        }
        return curr;
    }

    /**
     * Creates a list of 3 elements , given below
     * @param x the first element
     * @param y the second element
     * @param z the third element
     * @return the newrly created list
     */
    static public List<Double> list3(double x, double y, double z) {
        List<Double> retval = list2(x, y);
        retval.add(z);
        return retval;
    }
    /**
     * Creates a list of 2 elements , given below
     * @param x the first element
     * @param y the second element
     * @return the newrly created list
     */
    static public List<Double> list2(double x, double y) {
        List<Double> retval = list1(x);
        retval.add(y);
        return retval;
    }
    /**
     * Creates a list of 1 element , given below
     * @param x the first element
     * @return the newrly created list
     */
    static public List<Double> list1(double x) {
        List<Double> retval = new ArrayList<>();
        retval.add(x);
        return retval;
    }


}
