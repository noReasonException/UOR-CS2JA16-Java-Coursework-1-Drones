package factories;

import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import gui.InfoArea;
import gui.LogArea;
import gui.Menu;

public class GuiFactory extends AbstractGuiFactory {

    public GuiFactory(AbstractEngineFactory engineFactory) {
        super.engineFactory=engineFactory;
    }

    @Override
    public InfoArea getInfoArea() {
        return super.infoArea==null?super.infoArea=new InfoArea(this,getEngineFactory()):super.infoArea;
    }

    @Override
    public LogArea getLogArea() {
        return super.logArea==null?super.logArea=new LogArea(this,getEngineFactory()):super.logArea;
    }

    @Override
    public Menu getMenu() {
        return (super.menu==null)?(super.menu=new Menu(this,getEngineFactory())):super.menu;
    }

    @Override
    public AbstractEngineFactory getEngineFactory() {
        return super.engineFactory;
    }
}
