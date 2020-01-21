package math.vector;

import math.utils.VectorCoreUtils;
import math.vector.etc.LinearlyComplexOps;

import java.util.List;

/**
 * This is a vector of size 1
 * please @see Vector for more details
 * please @note that this class is immutable , every operation will result in a new object
 */
public class Vector1 extends Vector implements LinearlyComplexOps<Vector1> {

    /**
     * the size of the vector , using pythagoras triangle theorem
     * @return the size of the vector
     */
    @Override
    public Double magnitude() {
        return core.length();
    }

    /**
     * Returns a zero vector of same size
     * @return a zero vector
     */
    public Vector1 zero() {
        return new Vector1(core.toZero());
    }

    /**
     * Returns 1 , the amount of dimensions in this type of vector
     * @return always 1
     */
    public int dimension() {
        return 1;
    }

    /**
     * The add operator
     * @param any the vector to add to
     * @return a newrly created vector
     */
    public Vector1 add(Vector1 any) {
        return new Vector1(core.addition(any.core));
    }

    /**
     * Scale the vector by scalar k
     * @param scalar the k parameter
     * @return a newrly created scaled vector
     */
    public Vector1 scale(Double scalar) {
        return new Vector1(core.scalar(scalar));
    }

    /**
     * The dot product operator
     * @param any the other vector to perform this operation
     * @return the dot product!
     */
    public Double dot(Vector1 any) {
        return core.dot(any.core);
    }

    /**
     * The safe constructor , creates the non-type safe core of its own
     * @param elements the elements of this vectr
     */
    public Vector1(List<Double> elements) {
        super(new VectorCore(elements, 1));
    }

    /**
     * The non-type safe contructor , you can provide your own core here (useful for casts later)
     * @param core the core to be used in this vector
     */
    public Vector1(VectorCore core) {
        super(core);
    }

    /**
     * The simplest constructor
     * @param x the element of this vector
     */
    public Vector1(double x) {
        super(new VectorCore(VectorCoreUtils.list1(x), 1));
    }
}
