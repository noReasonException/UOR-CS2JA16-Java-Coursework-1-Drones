package math.vector.etc;

public interface LinearlyComplexOps<A extends LinearlyComplexOps<A>> extends LinearlyCombinable<A>{

    A zero();
    Double dot(A any);
    Double magnitude();
    default A norm(){ return this.scale(1/magnitude()); }
    default A neg(){return scale(-1d);}
    default A subtract(A any){ return add(any.scale(-1d)); }
    default public Double cosine(A any){ return (dot(any)/(magnitude()*any.magnitude())); }

}
