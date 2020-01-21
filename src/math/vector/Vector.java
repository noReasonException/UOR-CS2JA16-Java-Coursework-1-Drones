package math.vector;

import java.util.List;

/**
 * This is a abstract class vector
 */
public class Vector {
    VectorCore core;

    /**
     * retrieve the non-type safe core
     * @return
     */
    public VectorCore getCore() {
        return core;
    }

    @Override
    public String toString() {
        return core.toString();
    }

    /**
     * retrieve the size of the vector
     * @return
     */
    public int dimension() {
        return core.getDimension();
    }

    /**
     * the contructor , using as parameter the direct core
     * @param core the non-type safe vector core
     */
    public Vector(VectorCore core) {
        this.core = core;
    }

    /**
     * The safe contructor , initializes the core of its own
     * @param list the list with the elements of this vector
     */
    public Vector(List<Double> list) {
        this.core = new VectorCore(list, list.size());
    }

}
