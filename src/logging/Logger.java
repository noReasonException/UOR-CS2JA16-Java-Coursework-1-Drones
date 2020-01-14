package logging;

public interface Logger {
    default void warn(String s){
        System.out.println(s);
    }
}
