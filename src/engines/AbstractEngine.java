package engines;

import factories.specification.AbstractEngineFactory;

abstract public class AbstractEngine implements Runnable{

    protected AbstractEngineFactory factory;

    public AbstractEngine(AbstractEngineFactory factory) {
        this.factory = factory;
    }

    @Override
    abstract public void run();
}
