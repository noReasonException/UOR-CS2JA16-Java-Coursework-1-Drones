package logging;

public interface Logger {
    /**
     * generates a Warning Log entry
     *
     * @param s the message of the entry
     */
    void warn(String s);

    /**
     * generates a info  Log entry
     *
     * @param s the message of the entry
     */
    void info(String s);

    /**
     * generates a error Log entry
     *
     * @param s the message of the entry
     */

    void error(String s);

    /**
     * generates a Warning Log entry
     *
     * @param e the exception caused this log
     */
    void error(Exception e);

}
