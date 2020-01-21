package etc;

public class Nothing {
    public static Nothing sigleton;

    public static Nothing nothing() {
        return sigleton == null ? sigleton = new Nothing() : sigleton;
    }
}
