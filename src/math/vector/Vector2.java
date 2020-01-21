package math.vector;

import math.vector.etc.LinearlyComplexOps;
import math.vector.etc.Quantrant;

import java.util.Arrays;
import java.util.List;

import static math.utils.VectorCoreUtils.list2;

public class Vector2 extends Vector implements LinearlyComplexOps<Vector2> {


    /**
     * Returns a zero vector of same size
     * @return a zero vector
     */
    public Vector2 zero() {
        return new Vector2(core.toZero());
    }

    /**
     * the size of the vector , using pythagoras triangle theorem
     * @return the size of the vector
     */
    public Double magnitude() {
        return core.length();
    }


    /**
     * The add operator
     * @param any the vector to add to
     * @return a newrly created vector
     */
    public Vector2 add(Vector2 any) {
        return new Vector2(core.addition(any.core));
    }

    /**
     * Scale the vector by scalar k
     * @param scalar the k parameter
     * @return a newrly created scaled vector
     */
    public Vector2 scale(Double scalar) {
        return new Vector2(core.scalar(scalar));
    }

    /**
     * The safe constructor , creates the non-type safe core of its own
     * @param elements the elements of this vectr
     */
    public Vector2(List<Double> elements) {
        super(new VectorCore(elements, 2));
    }

    /**
     * The simplest constructor
     * @param x the element of this vector
     */
    public Vector2(double x, double y) {
        super(new VectorCore(list2(x, y), 2));
    }

    /**
     * The dot product operator
     * @param any the other vector to perform this operation
     * @return the dot product!
     */
    public Double dot(Vector2 any) {
        return core.dot(any.core);
    }

    /**
     * The non-type safe contructor , you can provide your own core here (useful for casts later)
     * @param core the core to be used in this vector
     */
    public Vector2(VectorCore core) {
        super(core);
    }

    public Quantrant getQuantrant() {
        if (core.getElement(0) > 0) {
            if (core.getElement(1) > 0) {
                return Quantrant.First;
            } else return Quantrant.Fourth;
        } else {
            if (core.getElement(1) > 0) {
                return Quantrant.Second;
            } else return Quantrant.Third;
        }
    }

    @Override
    public int hashCode() {
        return core.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vector && Arrays.equals(core.getData().toArray(), ((Vector3) obj).getCore().getData().toArray());

    }
}
