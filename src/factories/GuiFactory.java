package factories;

import etc.WindowInfo;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import gui.GuiMenu;
import gui.InformationPanel;
import gui.LogArea;
import gui.ToolArea;
import gui.threads.GuiThread;

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
        return super.logArea == null ? super.logArea = new LogArea() : super.logArea;
    }

    /**
     * Creates a singleton instance of Menu
     * @return a singleton Menu Object
     */
    @Override
    public ToolArea getToolArea() {
        return (super.toolArea == null) ? (super.toolArea = new ToolArea(this)) : super.toolArea;
    }
    /**
     * Creates a singleton instance of AbstractEngineFactory
     * @return a singleton AbstractEngineFactory Object
     */
    @Override
    public AbstractEngineFactory getEngineFactory() {return super.engineFactory==null?(super.engineFactory=new EngineFactory(this.windowInfo,this.loader)):super.engineFactory;}

    /**
     * Creates a singleton instance of GuiMenu
     * @return a singleton GuiMenu Object
     */
    @Override
    public GuiMenu getGuiMenu() { return menu==null?menu=new GuiMenu(this,loader):menu; }

    /**
     * Creates a singleton instance of InformationPanel
     * @return a singleton InformationPanel Object
     */
    @Override
    public InformationPanel getInformationPanel() { return super.informationPanel==null?informationPanel=new InformationPanel(getEngineFactory().getDatabase(),loader):super.informationPanel; }

    /**
     * Creates a singleton instance of GuiThread
     * @return a singleton GuiThread Object
     */
    @Override
    public GuiThread getGuiThread() {
        return super.guiThread==null?guiThread=new GuiThread(getInformationPanel()):guiThread;
    }
}
