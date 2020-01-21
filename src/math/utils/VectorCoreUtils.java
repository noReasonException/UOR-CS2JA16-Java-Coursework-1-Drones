package math.utils;

import math.vector.VectorCore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VectorCoreUtils {
    static VectorCore zeroVector(VectorCore core) {
        return new VectorCore(core.getData().stream().map(i -> 0d).collect(Collectors.toList()), core.getDimension());
    }

    static public double length(List<Double> list) {
        return Math.sqrt(list.stream().map(i -> i * i).reduce(0d, (a, b) -> a + b));
    }

    static public double dot(List<Double> lista, List<Double> listb) {
        double curr = 0;
        for (int i = 0; i < lista.size(); i++) {
            curr += lista.get(i) * listb.get(i);
        }
        return curr;
    }

    static public List<Double> list3(double x, double y, double z) {
        List<Double> retval = list2(x, y);
        retval.add(z);
        return retval;
    }

    static public List<Double> list2(double x, double y) {
        List<Double> retval = list1(x);
        retval.add(y);
        return retval;
    }

    static public List<Double> list1(double x) {
        List<Double> retval = new ArrayList<>();
        retval.add(x);
        return retval;
    }


}
