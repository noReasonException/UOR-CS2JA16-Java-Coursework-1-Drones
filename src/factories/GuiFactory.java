package factories;

import etc.WindowInfo;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import gui.LogArea;
import gui.Menu;

public class GuiFactory extends AbstractGuiFactory {

    private WindowInfo windowInfo;
    private ResourceLoader loader;
    public GuiFactory(WindowInfo windowInfo,ResourceLoader loader) {
        this.windowInfo=windowInfo;
        this.loader=loader;
    }

    /**
     * Creates a singleton instance of LogArea
     * @return a singleton LogArea Object
     */
    @Override
    public LogArea getLogArea() {
        return super.logArea == null ? super.logArea = new LogArea(this, getEngineFactory()) : super.logArea;
    }

    /**
     * Creates a singleton instance of Menu
     * @return a singleton Menu Object
     */
    @Override
    public Menu getMenu() {
        return (super.menu == null) ? (super.menu = new Menu(getEngineFactory())) : super.menu;
    }
    /**
     * Creates a singleton instance of AbstractEngineFactory
     * @return a singleton AbstractEngineFactory Object
     */
    @Override
    public AbstractEngineFactory getEngineFactory() {return super.engineFactory==null?(super.engineFactory=new EngineFactory(this.windowInfo,this.loader)):super.engineFactory;}
}
