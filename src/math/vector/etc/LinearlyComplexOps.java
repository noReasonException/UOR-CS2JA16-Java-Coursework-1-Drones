package math.vector.etc;

/**
 * provides useful operations for a linearly combinable class
 * @param <A> the type of the class
 */
public interface LinearlyComplexOps<A extends LinearlyComplexOps<A>> extends LinearlyCombinable<A> {

    A zero();

    Double dot(A any);

    Double magnitude();

    default A norm() {
        return this.scale(1 / magnitude());
    }

    default A neg() {
        return scale(-1d);
    }

    default A subtract(A any) {
        return add(any.scale(-1d));
    }

    /**
     * Warning , this is position/agnostic operations (TODO explain more here!)
     *
     * @param any
     * @return
     */
    default public Double cosine(A any) {
        return (dot(any) / (magnitude() * any.magnitude()));
    }

    default public Double angle(A any) {
        return Math.acos((dot(any) / (magnitude() * any.magnitude())));
    }
    //default public Double sine(A any){ return Math.sqrt(1-Math.pow(cosine(any),2));}
    //default public Double tan(A any){ return sine(any)/cosine(any);}

}
