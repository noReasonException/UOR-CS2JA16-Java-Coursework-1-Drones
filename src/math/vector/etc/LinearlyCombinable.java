package math.vector.etc;

/**
 * Represents any object that is linearly combinable
 * @param <A>
 */
public interface LinearlyCombinable<A> {
    A add(A any);
    A scale(Double scalar);
}
