package math.vector;

import math.vector.etc.LinearlyComplexOps;
import java.util.List;

public class Vector2 extends Vector implements LinearlyComplexOps<Vector2> {

    public Vector2 zero() { return new Vector2(core.toZero()); }

    public Double magnitude() { return core.length(); }


    public Vector2 add(Vector2 any) {
        return new Vector2(core.addition(any.core));
    }

    public Vector2 scale(Double scalar) {
        return new Vector2(core.scalar(scalar));
    }
    public Vector2(List<Double> elements) {
        super(new VectorCore(elements,2));
    }

    public Double dot(Vector2 any){ return core.dot(any.core); }
    public Vector2(VectorCore core) { super(core); }
}
