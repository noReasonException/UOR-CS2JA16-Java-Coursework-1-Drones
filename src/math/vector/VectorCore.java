package math.vector;

import math.utils.VectorCoreUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the non-type safe implementation of a vector
 */
public class VectorCore implements Serializable {

    private List<Double> data;

    //Info
    private int dimension;

    /***
     * check if we attemt to elevate a vector outside of its dimension
     * @param i the element we requested to see
     * @throws IllegalArgumentException in case of illegal position in the list
     */
    protected void pre_getElements_check(int i) throws IllegalArgumentException {
        if (i >= dimension) throw new IllegalArgumentException("given element index exceeds the vector dimension");
        else if (i < 0) throw new IllegalArgumentException("given index below zero");
    }

    /**
     * The constructor
     * @param data the points of the vector
     * @param dimension the dimension of the vector
     * why i cant figure out the dimension of the vector based on the size of the data?
     *                  it is very useful in the casts l8r!
     */
    public VectorCore(List<Double> data, int dimension) {
        if (data.size() != dimension)
            throw new IllegalArgumentException("given arraylist non compatible with this Vector type(" + data.size() + "" + dimension + ")");
        this.data = data;
        this.dimension = dimension;
    }

    /**
     * create a zero vector with the same magniture
     * @return the zero vector
     */
    public VectorCore toZero() {
        return new VectorCore(data.stream().map(i -> 0d).collect(Collectors.toList()), dimension);
    }

    /**
     * the pythagorean length from the origin
     * @return the distance
     */
    public double length() {
        return VectorCoreUtils.length(data);
    }

    /**
     * The distance between theese vectors
     * @param any the second vector to calculate distance
     * @return the distance
     */
    public double distance(VectorCore any) {
        return VectorCoreUtils.length(any.addition(scalar(-1d)).getData());
    }

    /**
     * Non-type safe addition between vectors
     * @param any the second vector to perform addition
     * @return a new vector as a result of addition
     */
    public VectorCore addition(VectorCore any) {
        List<Double> arrayList = new ArrayList<Double>();
        for (int i = 0; i < dimension; i++) {
            arrayList.add(getElement(i) + any.getElement(i));
        }
        return new VectorCore(arrayList, dimension);
    }

    /**
     * non type-safe scalar operator
     * @param scalar the scalar
     * @return a new vectorcore as a result of scaling
     */
    public VectorCore scalar(Double scalar) {
        List<Double> arrayList = new ArrayList<Double>();
        for (Double everyElement : data) {
            arrayList.add(everyElement * scalar);
        }
        return new VectorCore(arrayList, dimension);
    }

    /**
     * CompareTo implementation
     * @param secondVector the second vector to compare
     * @return 0 equals or 1 otherwise
     */
    @Override
    public boolean equals(Object secondVector) {
        if(secondVector instanceof VectorCore){
            return Arrays.equals(data.toArray(), ((VectorCore)secondVector).data.toArray());
        }
        return false;
    }


    /**
     * get particular element of the list
     * @param i the index of the element
     * @return the element
     * @throws IllegalArgumentException in case of invalid index (<0 or >dimension)
     */
    public Double getElement(int i) throws IllegalArgumentException {
        pre_getElements_check(i);
        return data.get(i);
    }

    /**
     * The dot product
     * @param b the second vectorCore
     * @return
     */
    public Double dot(VectorCore b) {
        return VectorCoreUtils.dot(data, b.data);
    }

    /**
     * Retrieve the data of this core as list
     * @return the list
     */
    public List<Double> getData() {
        return data;
    }

    @Override
    public String toString() {
        return Arrays.toString(data.toArray()).replace("[", "").replace("]", "");
    }

    /**
     * The amount of dimensions in this core
     * @return
     */
    public int getDimension() {
        return dimension;
    }
}