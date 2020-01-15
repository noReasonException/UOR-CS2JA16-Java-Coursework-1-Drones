package factories.specification;

import gui.InfoArea;
import gui.LogArea;
import gui.Menu;

abstract public class AbstractGuiFactory {

    protected InfoArea infoArea;
    protected LogArea logArea;
    protected Menu menu;
    protected AbstractEngineFactory engineFactory;

    abstract public InfoArea getInfoArea();

    abstract public LogArea getLogArea() ;

    abstract public Menu getMenu() ;

    abstract public AbstractEngineFactory getEngineFactory();
}
