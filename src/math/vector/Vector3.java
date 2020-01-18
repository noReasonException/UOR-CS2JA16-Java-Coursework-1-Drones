package math.vector;
import math.vector.etc.LinearlyComplexOps;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static math.utils.VectorCoreUtils.list3;

public class Vector3 extends Vector implements LinearlyComplexOps<Vector3> {


    public Vector3 zero() { return new Vector3(core.toZero()); }


    public Double magnitude() { return core.length(); }


    public Vector3 add(Vector3 any) {
        return new Vector3(core.addition(any.core));
    }

    public Vector3 scale(Double scalar) {
        return new Vector3(core.scalar(scalar));
    }

    public Double dot(Vector3 any){ return core.dot(any.core); }

    public Vector3(List<Double> elements) {
        super(new VectorCore(elements,3));
    }

    public Vector3(VectorCore core) { super(core); }
    public Vector3(double x,double y,double z) {
        super(new VectorCore(list3(x,y,z),3));
    }

    public Vector3 truncate(){
        return new Vector3(core.getData().stream().map(i->Integer.valueOf(i.intValue()).doubleValue()).collect(Collectors.toList()));
    }

    public Vector3 addX(double x){
        return new Vector3(core.addition(new VectorCore(list3(x,0,0),3)));
    }
    public Vector3 addY(double y){
        return new Vector3(core.addition(new VectorCore(list3(0,y,0),3)));
    }
    public Vector3 addZ(double z){
        return new Vector3(core.addition(new VectorCore(list3(0,0,z),3)));
    }

    @Override
    public int hashCode() {
        return getCore().getElement(0).hashCode()*1000+ getCore().getElement(1).hashCode()*100+getCore().getElement(2).hashCode()*10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3 v2 = (Vector3) o;
        return Objects.equals(core.getData().get(0), v2.getCore().getElement(0))&&Objects.equals(core.getData().get(1), v2.getCore().getElement(1))&&Objects.equals(core.getData().get(2), v2.getCore().getElement(2));
    }

}
