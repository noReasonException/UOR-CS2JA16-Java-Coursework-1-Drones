package math.vector;

import math.vector.etc.LinearlyComplexOps;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static math.utils.VectorCoreUtils.list3;

public class Vector3 extends Vector implements LinearlyComplexOps<Vector3> {


    /**
     * Returns a zero vector of same size
     * @return a zero vector
     */
    public Vector3 zero() {
        return new Vector3(core.toZero());
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
    public Vector3 add(Vector3 any) {
        return new Vector3(core.addition(any.core));
    }

    /**
     * Scale the vector by scalar k
     * @param scalar the k parameter
     * @return a newrly created scaled vector
     */
    public Vector3 scale(Double scalar) {
        return new Vector3(core.scalar(scalar));
    }

    /**
     * The dot product operator
     * @param any the other vector to perform this operation
     * @return the dot product!
     */
    public Double dot(Vector3 any) {
        return core.dot(any.core);
    }

    /**
     * The safe constructor , creates the non-type safe core of its own
     * @param elements the elements of this vectr
     */
    public Vector3(List<Double> elements) {
        super(new VectorCore(elements, 3));
    }

    /**
     * The non-type safe contructor , you can provide your own core here (useful for casts later)
     * @param core the core to be used in this vector
     */
    public Vector3(VectorCore core) {
        super(core);
    }

    /**
     * The simplest constructor
     * @param x the element of this vector
     */
    public Vector3(double x, double y, double z) {
        super(new VectorCore(list3(x, y, z), 3));
    }

    /**
     * cast to vector 2
     * note how beautifully this is implemented!
     * @return
     */
    public Vector2 toVector2() {
        return new Vector2(core);
    }

    /**
     * Truncates this vector to 0 decimal places
     * @return the truncated version of this vector
     */
    public Vector3 truncate() {
        return new Vector3(core.getData().stream().map(i -> Integer.valueOf(i.intValue()).doubleValue()).collect(Collectors.toList()));
    }
    @Override
    public int hashCode() {
        return getCore().getElement(0).hashCode() * 1000 + getCore().getElement(1).hashCode() * 100 + getCore().getElement(2).hashCode() * 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3 v2 = (Vector3) o;
        return core.getData().get(0).equals(v2.getCore().getElement(0)) &&
                core.getData().get(1).equals(v2.getCore().getElement(1)) &&
                core.getData().get(2).equals(v2.getCore().getElement(2));
    }

}
