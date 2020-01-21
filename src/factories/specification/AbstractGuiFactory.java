package factories.specification;

import gui.LogArea;
import gui.Menu;

/***
 * This is the AbstractGuiFactory
 * takes care of D.I in this project , from the GUI side(javafx) , providing us with every gui object we want
 */
abstract public class AbstractGuiFactory {

    protected LogArea logArea;
    protected Menu menu;
    protected AbstractEngineFactory engineFactory;
    /**
     * Creates a singleton instance of LogArea
     * @return a singleton LogArea Object
     */
    abstract public LogArea getLogArea();
    /**
     * Creates a singleton instance of Menu
     * @return a singleton Menu Object
     */
    abstract public Menu getMenu();
    /**
     * Creates a singleton instance of AbstractEngineFactory
     * @return a singleton Database AbstractEngineFactory
     */
    abstract public AbstractEngineFactory getEngineFactory();
}
