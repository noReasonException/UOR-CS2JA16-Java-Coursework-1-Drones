package tests.etc;

public interface Testable<T> {

    T genEntity() throws EntityInitException;
    boolean test();

}
