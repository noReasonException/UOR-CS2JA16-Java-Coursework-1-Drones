package factories;

import etc.WindowInfo;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import gui.GuiMenu;
import gui.LogArea;
import gui.ToolArea;

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
    public ToolArea getToolArea() {
        return (super.toolArea == null) ? (super.toolArea = new ToolArea(getEngineFactory())) : super.toolArea;
    }
    /**
     * Creates a singleton instance of AbstractEngineFactory
     * @return a singleton AbstractEngineFactory Object
     */
    @Override
    public AbstractEngineFactory getEngineFactory() {return super.engineFactory==null?(super.engineFactory=new EngineFactory(this.windowInfo,this.loader)):super.engineFactory;}

    @Override
    public GuiMenu getGuiMenu() { return menu==null?menu=new GuiMenu(this,loader):menu; }
}
