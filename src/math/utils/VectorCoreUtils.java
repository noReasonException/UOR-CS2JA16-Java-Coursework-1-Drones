package math.utils;

import math.vector.VectorCore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VectorCoreUtils {
    static VectorCore zeroVector(VectorCore core){
        return new VectorCore(core.getData().stream().map(i->0d).collect(Collectors.toList()),core.getDimension());
    }
    static public double length(List<Double> list){
        return Math.sqrt(list.stream().map(i->i*i).reduce(0d,(a,b)->a+b));
    }
    static public double dot(List<Double> lista,List<Double>listb){
        double curr=0;
        for (int i = 0; i < lista.size(); i++) {
            curr+=lista.get(i)*listb.get(i);
        }
        return curr;
    }
    static public List<Double> list3(double x,double y ,double z){
        ArrayList<Double> retval = new ArrayList<>();
        retval.add(x);
        retval.add(y);
        retval.add(z);
        return retval;
    }



}
