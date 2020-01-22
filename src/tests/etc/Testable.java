package tests.etc;

/**
 * Represents a testable entity
 * @param <T> the type of the entity to be tested
 */
public interface Testable<T> {

    /**
     * Generate a new entity
     * @return a newrly created entity
     * @throws EntityInitException in case of any error
     */
    T genEntity() throws EntityInitException;

    /**
     * Run all tests regarding this entity
     * @return true if all tests has been succeed;
     */
    boolean test();

}
