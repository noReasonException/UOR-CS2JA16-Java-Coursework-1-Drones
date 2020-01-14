package math.vector;

import math.vector.etc.LinearlyComplexOps;

import java.util.List;

public class Vector1 extends Vector implements LinearlyComplexOps<Vector1> {

    @Override
    public Double magnitude() { return core.length(); }

    public Vector1 zero() { return new Vector1(core.toZero()); }

    public int dimension() {
        return 1;
    }

    public Vector1 add(Vector1 any) {
        return new Vector1(core.addition(any.core));
    }

    public Vector1 scale(Double scalar) {
        return new Vector1(core.scalar(scalar));
    }

    public Double dot(Vector1 any){ return core.dot(any.core); }

    public Vector1(List<Double> elements) {
        super(new VectorCore(elements,1));
    }

    public Vector1(VectorCore core) { super(core); }
}
