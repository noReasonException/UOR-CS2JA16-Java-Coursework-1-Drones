package factories.specification;

import gui.LogArea;
import gui.Menu;

abstract public class AbstractGuiFactory {

    protected LogArea logArea;
    protected Menu menu;
    protected AbstractEngineFactory engineFactory;

    abstract public LogArea getLogArea();

    abstract public Menu getMenu();

    abstract public AbstractEngineFactory getEngineFactory();
}
