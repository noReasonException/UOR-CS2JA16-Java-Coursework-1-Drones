package math.vector;
import math.vector.etc.LinearlyComplexOps;
import java.util.List;

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
}
