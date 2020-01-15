package logging;

public interface Logger {
    default void warn(String s){
        System.out.println(s);
    }
    default void info(String s){
        System.out.println(s);
    }
    default void error(String s){
        System.out.println(s);
    }
}
