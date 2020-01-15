package engines;

import factories.specification.AbstractEngineFactory;
import logging.Logger;

abstract public class AbstractEngine implements Runnable{

    protected AbstractEngineFactory factory;
    protected Logger logger;
    protected boolean operational=true;

    public AbstractEngine(AbstractEngineFactory factory) {
        this.factory = factory;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public boolean isOperational() {
        return operational;
    }

    public void kill(){
        this.operational = false;
    }

    @Override
    abstract public void run();
}
