package math.vector.etc;

public interface LinearlyCombinable<A> {
    A add(A any);

    A scale(Double scalar);
}
