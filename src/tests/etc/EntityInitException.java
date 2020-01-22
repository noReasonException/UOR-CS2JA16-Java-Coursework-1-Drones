package tests.etc;

/**
 * Represents any particular error may occur in the initialization of the testable entity
 */
public class EntityInitException extends Exception {
    public EntityInitException(Throwable cause) {
        super(cause);
    }
}
