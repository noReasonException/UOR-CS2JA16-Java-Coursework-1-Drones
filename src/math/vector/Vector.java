package math.vector;

import java.util.List;

public class Vector {
    VectorCore core;

    public VectorCore getCore() {
        return core;
    }

    @Override
    public String toString() {
        return core.toString();
    }
    public int dimension() {
        return core.getDimension();
    }

    public Vector(VectorCore core) {
        this.core = core;
    }
    public Vector(List<Double> list) {
        this.core = new VectorCore(list,list.size());
    }

}
