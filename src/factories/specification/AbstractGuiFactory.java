package factories.specification;

import gui.GuiMenu;
import gui.InformationPanel;
import gui.LogArea;
import gui.ToolArea;
import gui.threads.GuiThread;
import logging.Logger;

import java.io.Closeable;
import java.io.IOException;

/***
 * This is the AbstractGuiFactory
 * takes care of D.I in this project , from the GUI side(javafx) , providing us with every gui object we want
 */
abstract public class AbstractGuiFactory implements Closeable {

    protected LogArea logArea;
    protected ToolArea toolArea;
    protected AbstractEngineFactory engineFactory;
    protected GuiMenu menu;
    protected InformationPanel informationPanel;
    protected GuiThread guiThread;
    /**
     * Creates a singleton instance of LogArea
     * @return a singleton LogArea Object
     */
    abstract public LogArea getLogArea();
    /**
     * Creates a singleton instance of Menu
     * @return a singleton Menu Object
     */
    abstract public ToolArea getToolArea();
    /**
     * Creates a singleton instance of AbstractEngineFactory
     * @return a singleton AbstractEngineFactory Object
     */
    abstract public AbstractEngineFactory getEngineFactory();

    /**
     * Creates a singleton instance of GuiMenu
     * @return a singleton GuiMenu Object
     */
    abstract public GuiMenu getGuiMenu();

    /**
     * Creates a singleton instance of InformationPanel
     * @return a singleton InformationPanel Object
     */
    abstract public InformationPanel getInformationPanel();
    /**
     * Creates a singleton instance of GuiThread
     * @return a singleton GuiThread Object
     */
    abstract public GuiThread getGuiThread();

    /**
     * Terminates properly this objects lifetime
     *
     * @throws IOException if a stream fails to close properly(not used here)
     */
    @Override
    public void close() throws IOException {
        System.out.println("Gui factory terminates itself");
        getEngineFactory().close();
        getLogArea().close();

    }
}
