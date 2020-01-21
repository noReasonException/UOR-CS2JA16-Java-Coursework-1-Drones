package logging;

public interface Logger {
     void warn(String s);

     void info(String s);

     void error(String s);

     void error(Exception e);

}
