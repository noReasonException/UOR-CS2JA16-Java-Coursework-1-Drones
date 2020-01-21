package logging;

public class DefaultLogger implements Logger {

    @Override
    public void warn(String s) {
        System.out.println(s);
    }

    @Override
    public void info(String s) {
        System.out.println(s);
    }

    @Override
    public void error(String s) {
        System.out.println(s);
    }

    @Override
    public void error(Exception e) {
        System.out.println(e.getMessage());
    }
}
