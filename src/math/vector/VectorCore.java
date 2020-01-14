package math.vector;

import math.utils.VectorCoreUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VectorCore{

    private List<Double> data;

    //Info
    private int dimension;

    protected void pre_getElements_check(int i) throws IllegalArgumentException{
        if(i>=dimension) throw new IllegalArgumentException("given element index exceeds the vector dimension");
        else if(i<0) throw new IllegalArgumentException("given index below zero");
    }
    public VectorCore(List<Double>data,int dimension) {
        if(data.size()!=dimension) throw new IllegalArgumentException("given arraylist non compatible with this Vector type("+data.size()+""+dimension+")");
        this.data=data;
        this.dimension=dimension;
    }

    public VectorCore toZero(){
        return new VectorCore(data.stream().map(i->0d).collect(Collectors.toList()),dimension);
    }

    public double length(){
        return VectorCoreUtils.length(data);
    }
    public double distance(VectorCore any){
        return VectorCoreUtils.length(any.addition(scalar(-1d)).getData());
    }



    public VectorCore addition(VectorCore any) {
        List<Double> arrayList= new ArrayList<Double>();
        for (int i = 0; i < dimension; i++) {
            arrayList.add(getElement(i)+any.getElement(i));
        }
        return new VectorCore(arrayList,dimension);
    }
    public VectorCore scalar(Double scalar) {
        List<Double> arrayList=new ArrayList<Double>();
        for (Double everyElement:data){
            arrayList.add(everyElement*scalar);
        }
        return new VectorCore(arrayList,dimension);
    }

    public int compareTo(VectorCore vector2) {
        return Arrays.equals(data.toArray(),vector2.data.toArray())?0:1;
    }

    public Double getElement(int i) throws IllegalArgumentException {
        pre_getElements_check(i);
        return data.get(i);
    }

    public Double dot(VectorCore b){
        return VectorCoreUtils.dot(data,b.data);
    }


    public List<Double> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Vector"+dimension+" Object : "+"["+Arrays.toString(data.toArray())+"]";
    }

    public int getDimension() {
        return dimension;
    }
}