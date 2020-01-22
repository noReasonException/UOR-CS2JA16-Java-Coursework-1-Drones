package logging;

/**
 * Represents a object able to append logs to an external medium(in this case , the System.out)
 */
public class DefaultLogger implements Logger {


    /**
     * generates a Warning Log entry
     *
     * @param s the message of the entry
     */
    @Override
    public void warn(String s) {
        System.out.println(s);
    }

    /**
     * generates a info  Log entry
     *
     * @param s the message of the entry
     */
    @Override
    public void info(String s) {
        System.out.println(s);
    }

    /**
     * generates a error Log entry
     *
     * @param s the message of the entry
     */

    @Override
    public void error(String s) {
        System.out.println(s);
    }

    /**
     * generates a Warning Log entry
     *
     * @param e the exception caused this log
     */
    @Override
    public void error(Exception e) {
        System.out.println(e.getMessage());
    }
}
